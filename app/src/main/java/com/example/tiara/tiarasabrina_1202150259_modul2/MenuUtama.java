package com.example.tiara.tiarasabrina_1202150259_modul2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MenuUtama extends AppCompatActivity {
    //membuat variable untuk menampung nilai dari radio grup dan radio button
    private RadioGroup a;
    private RadioButton b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama); //menu utama menggunakan content dari layout activity_menu_utama

    }

    public void btPesanSekarang(View view) { //memasukan aktivitas pada button btPesanSekarang
        a = (RadioGroup) findViewById(R.id.jenisMenu); //mengambil nilai radio group jenisMenu
        int selecteditem = a.getCheckedRadioButtonId(); //masuk ke radio button yang ada di dalam radio grup

        //mengambil nilai dari radiobutton
        b = (RadioButton) findViewById(R.id.radioDine);
        c = (RadioButton) findViewById(R.id.radioTake);

        //membuat sebuah kondisi yaitu jika yang dipilih adalah radio button dengan id RadioDine, akan pindah menuju laman Dine In
        if (selecteditem == b.getId()) {
            Intent pindah = new Intent(MenuUtama.this, DineIn.class);
            startActivity(pindah);
            Toast.makeText(MenuUtama.this, "Dine In", Toast.LENGTH_LONG).show();
        }
        //membuat sebuah kondisi yaitu jika yang dipilih adalah radio button dengan id radioTake, akan pindah menuju laman Take Away
        else if (selecteditem == c.getId()) {
            Intent pindah1 = new Intent(MenuUtama.this, TakeAway.class);
            startActivity(pindah1);
            Toast.makeText(MenuUtama.this, "Take Away", Toast.LENGTH_LONG).show();
        }
        //kondisi jika tidak milih salah satu antara kedua radio button
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Alert Message");
            alert.setMessage("Must choose one menu!")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = alert.create();

            alertDialog.show();
        }


    }
}