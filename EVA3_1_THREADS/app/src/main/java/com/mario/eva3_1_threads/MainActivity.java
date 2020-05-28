package com.mario.eva3_1_threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SIMULAR UNA ACTIVIDAD QUE TOME MUCHO TIEMPO
        //ejemplo
        //10s
        for (int i =  0;i < 10; i++){
            //DUERME AL HILO PRINCIPAL
            try {
                Thread.sleep(1000);// 1sg = 1000 millis
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
