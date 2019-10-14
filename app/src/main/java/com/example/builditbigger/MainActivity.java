package com.example.builditbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.displayjokelib.DisplayJokeActivity;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {
    String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_tell_me_joke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJoke();
                if (!joke.isEmpty()) {

                    Intent intent = new Intent(MainActivity.this, DisplayJokeActivity.class);
                    intent.putExtra(DisplayJokeActivity.EXTRA_JOKE, joke);
                    startActivity(intent);
                }
            }
        });

    }

    void getJoke() {
        try {
            joke = new EndpointsAsyncTask().execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
