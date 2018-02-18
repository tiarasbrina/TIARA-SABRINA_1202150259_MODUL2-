package com.example.tiara.tiarasabrina_1202150259_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
public class DaftarMenuAdapter extends RecyclerView.Adapter <DaftarMenuAdapter.ViewHolder> {
    private ArrayList<String> arrayListMenu; //variabel untuk menampung nilai tipe String
    private ArrayList<String> arrayListsPrice; //variable untuk menampung nilai tipe String
    private ArrayList<Integer> gambar; //variable untuk menampung gambar

    DaftarMenuAdapter(ArrayList<String> arrayListMenu, ArrayList<String> arrayListsPrice, ArrayList<Integer> Gambar){ //membuat konstruktor
        this.arrayListMenu = arrayListMenu;
        this.arrayListsPrice = arrayListsPrice;
        this.gambar = Gambar;
    }


    class ViewHolder extends RecyclerView.ViewHolder{ //kelas untuk menampung referensi dari beberapa view

        private TextView menu, price; //variable untuk menampung nilai dari bagianMenu
        private ImageView gambar; //variable untuk menampung nilai dari bagianPrice
        private LinearLayout ItemList; //variable untuk menampung nilai dari item_list

        //method viewHolder
        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            menu = itemView.findViewById(R.id.bagianMenu); //menemukan dan menyimpan nilai
            price = itemView.findViewById(R.id.bagianPrice);//menemukan dan menyimpan nilai
            gambar = itemView.findViewById(R.id.image);//menemukan dan menyimpan nilai
            ItemList = itemView.findViewById(R.id.item_list);//menemukan dan menyimpan nilai
        }
    }

    public DaftarMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }


    public void onBindViewHolder(final DaftarMenuAdapter.ViewHolder holder, final int position) {

        final String menu = arrayListMenu.get(position);//mengambil data dari array sesuai posisinya
        final String price = arrayListsPrice.get(position);//mengambil data dari array sesuai posisinya
        final Integer image = gambar.get(position);//mengambil data dari array sesuai posisinya
        holder.menu.setText(menu); //set variable menu untuk ditampilkam
        holder.price.setText("Harga Rp. "+price); //set variable price untuk ditampilkan
        holder.gambar.setImageResource(image); // untuk ditampilkan

        //membuat respon saat menu diklik
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //membuat respon saat itemlist diklik
        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMenu.class); //membuat intent
                String komposisi; //membuat variabel
                switch (position){ //membuat kondisi untuk posisi
                    case 0: //kondisi pertama
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Nori, Nasi, Tuna, Timun, Bumbu ";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 1://kondisi kedua
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Mie, Telur, Bumbu, Saos, Tomat";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 2: //kondisi ketiga
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Roti, Sosis, Saos, Mayonaise, Jamur, Keju";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 3: //kondisi keempat
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Ayam Goreng/Daging, Sayur Asem, Tahu, Tempe, Ikan Asin, Nasi, Sambel";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 4: //kondisi ke lima
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Dagig Sapi, Kentang Goreng, Jagung, Wortel, Saos";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 5: //kondisi ke enam
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("price", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Ice Cream, Topping, Float ";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                }
            }
        });
    }

    public int getItemCount() {
        return arrayListMenu.size();
    }
}
