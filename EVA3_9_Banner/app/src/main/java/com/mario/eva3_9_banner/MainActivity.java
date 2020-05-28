package com.mario.eva3_9_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int[] imagenes = {R.drawable.f1,R.drawable.f2,R.drawable.f3};
    int indice=0;
    Handler myHandler = new Handler();
    Runnable background = new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myHandler.post(foreground);
            }
        }
    };
    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            imageView.setImageResource(imagenes[indice]);
            if(indice== 2){
                indice = 0;
            }
            else{
                indice++;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageVwBanner);
        Thread thread = new Thread(background);
        thread.start();

    }
}
