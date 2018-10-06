package com.example.chethan.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                /*ProgressDialog progressBar=new ProgressDialog(splash.this);
                progressBar.setMessage("Loading...");
                progressBar.show();*/
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(splash.this, MainActivity.class));
                }
            }
        });
        t.start();
    }
}
