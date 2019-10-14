package com.example.builditbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.displayjokelib.DisplayJokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.concurrent.ExecutionException;


public class MainActivityFree extends AppCompatActivity {
    String joke = "";
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        findViewById(R.id.tv_tell_me_joke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJoke();
                if (!joke.isEmpty()) {

                    Intent intent = new Intent(MainActivityFree.this, DisplayJokeActivity.class);
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

    @Override
    protected void onResume() {
        super.onResume();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
}
