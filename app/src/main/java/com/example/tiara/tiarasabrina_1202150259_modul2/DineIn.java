package com.example.tiara.tiarasabrina_1202150259_modul2;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class DineIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //membuat variable untuk menampung nilai dari inputan
    private String noMeja = "";
    Button btPilihPesanan;
    private static final String TAG = MenuUtama.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in); // //Dine In menggunakan content dari layout activity_dine_in

        //mengambil nilai dari button dan spinner dan disimpan di variabel
        btPilihPesanan = (Button)findViewById(R.id.btPilihPesanan);
        Spinner spinner = (Spinner)findViewById(R.id.spinnerMeja);
        //membuat kondisi jika nilai spinner adalah kosong
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        //menampilkan array di spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.labels_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        if (spinner != null){
            spinner.setAdapter(adapter);
        }

        //membuat aktivitas untuk button btPilihPesanan
        btPilihPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(DineIn.this,DaftarMenu.class); //membuat intent
                Toast.makeText(DineIn.this, noMeja+" Terpilih", Toast.LENGTH_LONG).show(); //membuat toast
                startActivity(a); //start toast
            }
        });

    }

    //method untuk mengambil posisi dari array
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        noMeja = adapterView.getItemAtPosition(i).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }

}
