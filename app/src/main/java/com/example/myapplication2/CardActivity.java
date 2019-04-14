package com.example.myapplication2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.myapplication2.rest.DTOs.PostResponse;

import java.util.Arrays;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        String key = null;
        String id = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            key = extras.getString("hashCode");
            id = extras.getString("id");
        }

        PostResponse list = HTTPRequestHelper.getValue(Integer.valueOf(key));
        PostResponse.DataObject dataObject = list.getRecipes().get(Integer.valueOf(id));


/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
*/
    }
}
