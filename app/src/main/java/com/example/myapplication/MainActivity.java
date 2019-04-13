package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.rest.DTOs.PostResponse;
import com.example.myapplication.rest.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private MenuItem textItem;

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
                case R.id.textCenter:
                    textItem = item;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        call_service();
    }

    public void call_service() {
        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID()
                .enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<PostResponse> call, @NonNull Response<PostResponse> response) {
                        PostResponse post = response.body();
                        //mTextMessage.
                        //mTextMessage.setText(post.getTest12());
                        textItem.setTitle(post.getTest12());
                    }

                    @Override
                    public void onFailure(@NonNull Call<PostResponse> call, @NonNull Throwable t) {

                        mTextMessage.setText("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}

