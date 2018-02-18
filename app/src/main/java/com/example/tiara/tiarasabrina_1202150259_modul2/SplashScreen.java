package com.example.tiara.tiarasabrina_1202150259_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private static int splashInterval = 2000; //menentukan interval dan disimpan di variabel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen); //splash screen menggunakan content dari layout activity_splash_screen

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() { //mengoveride method run
                // TODO Auto-generated method stub
                Intent i = new Intent(SplashScreen.this, MenuUtama.class); //membuat intent
                startActivity(i); // menghubungkan activity splashscren ke menu utama dengan intent

                Toast.makeText(SplashScreen.this,"TIARASABRINA_1202150259",Toast.LENGTH_LONG).show(); //membuat toast saat splash screen menuju menu utama

                this.finish(); //menyelesaikan running splash screen
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    };
}
