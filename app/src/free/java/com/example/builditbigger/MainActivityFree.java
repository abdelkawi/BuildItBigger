package com.example.builditbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



public class MainActivityFree extends AppCompatActivity {
    String joke = "";
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.unitId));
        findViewById(R.id.tv_tell_me_joke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJoke();
            }
        });

    }


    void getJoke() {
        new EndpointsAsyncTask().execute(this);
        mInterstitialAd.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
}
