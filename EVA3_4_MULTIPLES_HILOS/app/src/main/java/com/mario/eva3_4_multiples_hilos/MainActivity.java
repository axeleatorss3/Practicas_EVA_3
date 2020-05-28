package com.mario.eva3_4_multiples_hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //----MiThread
        MiHilo mihilo1 = new MiHilo();
        mihilo1.start();
        //-----MiRunnable
        MiRunnable miRunnable = new MiRunnable();
        Thread thilo1 = new Thread(miRunnable);
        thilo1.start();

    }
}
