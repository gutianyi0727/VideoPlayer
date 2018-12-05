package com.example.elvis.videoplayer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.content.Context.MODE_PRIVATE;

public class SplashActivity extends Activity {

    private SharedPreferences mSharedPreferences;
    private static final int GO_HOME = 1;
    private static final int GO_Guide = 2;
    private static final int ENTER_DUTATION = 2000;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_Guide:
                    startGuideActivity();
                    break;
                case GO_HOME:
                    startHomeActivity();
                    break;
                default: 
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getSharedPreferences("config",MODE_PRIVATE);
        init();
    }

    private void init() {
        Boolean isFirstIn = mSharedPreferences.getBoolean("mIsFirstIn",true);
        if (isFirstIn) {
            mHandler.sendEmptyMessageDelayed(GO_Guide,ENTER_DUTATION);
        }else{
            mHandler.sendEmptyMessageDelayed(GO_HOME,ENTER_DUTATION);
        }
    }

    private void startGuideActivity() {
        Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
        startActivity(intent);
        finish();
    }

    private void startHomeActivity() {
        Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
