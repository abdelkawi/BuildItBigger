package com.example.builditbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.displayjokelib.DisplayJokeActivity;

import java.util.concurrent.ExecutionException;


public class MainActivityPaid extends AppCompatActivity {
    String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_tell_me_joke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJoke();
            }
        });

    }

    void getJoke() {
        new EndpointsAsyncTask().execute(this);
    }



}
