package com.mario.eva3_8_handler_runnbales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Handler myHandler = new Handler();
    TextView mensaje;
    int i=0;
    Runnable backgroundRun = new Runnable() {//trabajo en segundo plano
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myHandler.post(foreGroundRun);
                Log.wtf("background",i+"");
                i++;
            }

        }
    };
    Runnable foreGroundRun = new Runnable() {//se encarga de intercatuar con la UI
        @Override
        public void run() {
            //txtMensaje
            mensaje.append("valor_i="+i+"\n");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensaje = findViewById(R.id.txtViewMensaje);
        Thread myThread = new Thread(backgroundRun);
        myThread.start();

    }
}
