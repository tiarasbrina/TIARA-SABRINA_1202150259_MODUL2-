package com.example.tiara.tiarasabrina_1202150259_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu); //mengambil konten dari layout tsb

        //membuat button back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //mengambil nilai string dari aktivity sebelumnya
        String menu = getIntent().getStringExtra("menu"); //mengambil nilai menu
        Integer image = getIntent().getIntExtra("image", 0); //mengambil nilai gambar
        String price = getIntent().getStringExtra("price"); //mengambil nilai harga
        String komposisi = getIntent().getStringExtra("komposisi"); //mengambil nilai komposisi


        //menemukan dan mengambil nilai dari textView dan ImangeView dan disimpan di variabel
        TextView txtMenu = findViewById(R.id.namaMenu);
        TextView txtPrice = findViewById(R.id.price);
        TextView txtkomposisi = findViewById(R.id.listkomposisi);
        ImageView images = findViewById(R.id.imageMenu);

        //set nilai variabel txtMenu dll
        txtMenu.setText(menu);
        txtPrice.setText(price);
        txtkomposisi.setText(komposisi);
        images.setImageResource(image);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //function ketika button back di klik maka akan kembali ke view sebelumnya
        onBackPressed();
        return true;
    }
}
