package com.mario.eva3_3_runnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                for (int i =  0;i < 10; i++){
                    //DUERME AL HILO PRINCIPAL  //10s
                    try {
                        Thread.sleep(1000);// 1sg = 1000 millis
                        Log.wtf("hilo1",i+"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thilo = new Thread(run1);
        thilo.start();
    }
}
