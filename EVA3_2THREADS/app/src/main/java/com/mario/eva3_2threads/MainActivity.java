package com.mario.eva3_2threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* for (int i =  0;i < 10; i++){
            //DUERME AL HILO PRINCIPAL  //10s
            try {
                Thread.sleep(1000);// 1sg = 1000 millis
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */
       Thread thilo1 = new Thread(){
           @Override
           public void run() {//aqui es donde va el trabajo en segundo plano
               super.run();
               //aqui
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
       thilo1.start();//crea un nuevo hilo

    }
}
