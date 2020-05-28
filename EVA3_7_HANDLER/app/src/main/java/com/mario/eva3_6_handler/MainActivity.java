package com.mario.eva3_6_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
Handler miHandler = new Handler(){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        //AQUI PODEMOS MODIFICAR LA INTERFAZ GRAFICA (UI)
        int valor_i = (int)msg.obj;
        textView.append("hilo: "+ msg.what+ "valor i ="+valor_i+"\n");
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view_datos);
        Thread miThread = new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //se crea el mensaje
                    Message msg = miHandler.obtainMessage(100,i);
                    miHandler.sendMessage(msg);
                    //se envia el mensaje al Handler
                    Log.wtf("MiThread",i+"");
                    i++;
                }
            }
        };
        miThread.start();
    }
}
