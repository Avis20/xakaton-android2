package com.example.myapplication2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication2.rest.DTOs.PostResponse;
import com.example.myapplication2.rest.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    private TextView mTextMessage;
    private Button buttonCenter;
    private ConstraintLayout mContainer;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        buttonCenter = (Button) findViewById(R.id.buttonCenter);
        mContainer = (ConstraintLayout)findViewById(R.id.container);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        call_service();
    }

    public void call_service() {
        NetworkService
                .getInstance()
                .getJSONApi()
                .getData()
                .enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<PostResponse> call, @NonNull Response<PostResponse> response) {
                        PostResponse post = response.body();
                        buttonCenter.setText(post.getTest12());
                        List<PostResponse.DataObject> list = post.getRecipes();

                        int bottom = 5;
                        for(PostResponse.DataObject p: list ){
                            TextView tv = new TextView(mContainer.getContext());
                            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT));
                            tv.setGravity(Gravity.CENTER);
                            tv.setTextSize(18);
                            tv.setPadding(0, 5, 0, 5);
                            tv.setText(p.getCookTime());
                            mContainer.addView(tv);
                        }

                        for(PostResponse.DataObject p: list ) {
                            System.out.println(p.getCookTime());
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<PostResponse> call, @NonNull Throwable t) {

                        mTextMessage.setText("Ошибка подключения к интернету");
                        t.printStackTrace();
                    }
                });
    }
}
