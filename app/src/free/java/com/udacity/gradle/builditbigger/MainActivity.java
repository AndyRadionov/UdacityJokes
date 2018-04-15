package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity {

    //Not local for testing needs
    EndpointsAsyncTask mEndpointsAsyncTask;
    private InterstitialAd mInterstitialAd;
    private Button mTellJokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTellJokeButton = findViewById(R.id.btn_tell_joke);
        setupInterstitial();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unchecked")
    public void tellJoke(View view) {
        mEndpointsAsyncTask = new EndpointsAsyncTask(this);
        mEndpointsAsyncTask.execute();

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void setupInterstitial() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {


            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                mTellJokeButton.setEnabled(true);
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mTellJokeButton.setEnabled(true);
            }
        });
    }
}
