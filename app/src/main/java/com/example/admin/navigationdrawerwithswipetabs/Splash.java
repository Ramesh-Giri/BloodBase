package com.example.admin.navigationdrawerwithswipetabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ramesh on 5/19/2017.
 */

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_splash);

        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        }, 1500);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Splash.this.finish();
    }
}
