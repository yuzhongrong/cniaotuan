package com.example.yuzhongrong.cn5shop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


public class SplashActivity extends AppCompatActivity {


    private Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sp=getPreferences(MODE_PRIVATE);
                boolean isfirst=sp.getBoolean("isfirst",true);
                Intent intent=new Intent();
                if(isfirst){

                    sp.edit().putBoolean("isfirst",false).commit();
                    intent.setClass(SplashActivity.this,GuideActivity.class);


                }else{

                    intent.setClass(SplashActivity.this,MainActivity.class);


                }

                startActivity(intent);
                finish();


            }
        },3000);

    }
}
