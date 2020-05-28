package com.mario.eva3_5_interrupt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Runnable mirunable = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //break, continue
                    break;
                }
                Log.wtf("MiRunnable",i+"");
                i++;
            }

        }
    };
    Thread miThread1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miThread1 = new Thread(mirunable);
        Log.wtf("MiRunnable","Estado:"+miThread1.getState());
        Toast.makeText(this, "Estado;"+miThread1.getState(), Toast.LENGTH_SHORT).show();
        miThread1.start();
        Toast.makeText(this, "Estado;"+miThread1.getState(), Toast.LENGTH_SHORT).show();
        Log.wtf("MiRunnable","Estado:"+miThread1.getState());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        miThread1.interrupt();

    }
}
