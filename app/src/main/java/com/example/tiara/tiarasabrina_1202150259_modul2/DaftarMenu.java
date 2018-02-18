package com.example.tiara.tiarasabrina_1202150259_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class DaftarMenu extends AppCompatActivity {
    //membuat variable untuk menampung nilai
    private RecyclerView recyclerView;
    private DaftarMenuAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Menu;
    private ArrayList<String> Price;
    private ArrayList<Integer> Gambar;


    private String[] menu = {"Nuri Sushi", "Omelet", "Papperoni Pizza", "Nasi Timbel", "Steak", "Ice Scream"}; //membuat array sebagai daftar menu
    private String[] price = {"55.000", "15.000", "74.000", "30.000", "40.000", "10.000"}; //membuat array sebagai daftar harga
    private int[] image = {R.drawable.nurisushi, R.drawable.omelet, R.drawable.papperonipizza, R.drawable.nasitimbel, R.drawable.steak,
            R.drawable.icecream}; //membuat array sebagai daftar gambar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu); //mengambil konten dari layout tsb

        //membuat arraylist
        Menu = new ArrayList<>();
        Price = new ArrayList<>();
        Gambar = new ArrayList<>();
        recyclerView= findViewById(R.id.recyclerview);
        DaftarItem();

        //membuat list yang vertical dan membuat layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new DaftarMenuAdapter(Menu, Price, Gambar);

        //set adapter pada recyclerView
        recyclerView.setAdapter(adapter);
    }
    //membuat method untuk perulangan
    private void DaftarItem() {
        for (int w=0; w<menu.length; w++){
            Gambar.add(image[w]);
            Menu.add(menu[w]);
            Price.add(price[w]);
        }
    }
}
