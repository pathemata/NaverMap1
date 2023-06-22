package com.example.navermap1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ListActivity extends AppCompatActivity {

    private Fragment fragmentAttractionList;
    private Fragment fragmentEntertainmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        fragmentAttractionList = new AttractionList();
        fragmentEntertainmentList = new EntertainmentList();

        FragmentManager fragmentManager1 = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        fragmentTransaction1.add(R.id.showlist,fragmentAttractionList);
        fragmentTransaction1.commit();

        Button btn_attractionlist = findViewById(R.id.btn_attractionlist);
        btn_attractionlist.setOnClickListener(v->{
            FragmentManager fm1 = getSupportFragmentManager();
            FragmentTransaction ft1 = fragmentManager1.beginTransaction();
            ft1.replace(R.id.showlist, fragmentAttractionList);
            ft1.commit();
        });

        Button btn_entertainmentlist = findViewById(R.id.btn_entertainmentlist);
        btn_entertainmentlist.setOnClickListener(v->{
            FragmentManager fm3 = getSupportFragmentManager();
            FragmentTransaction ft3 = fragmentManager1.beginTransaction();
            ft3.replace(R.id.showlist, fragmentEntertainmentList);
            ft3.commit();
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button backToMap = findViewById(R.id.back_to_map_1);
        backToMap.setOnClickListener(v->{
            Intent intent = new Intent(ListActivity.this, com.example.navermap1.MapActivity.class);
            startActivity(intent);
        });

    }
}
