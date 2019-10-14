package com.example.displayjokelib;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayJokeActivity extends AppCompatActivity {
    public final static String EXTRA_JOKE = "joke";
    private TextView mJokeDetailsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        mJokeDetailsTV = findViewById(R.id.tv_joke_details_display);
        mJokeDetailsTV.setText(joke);

    }
}
