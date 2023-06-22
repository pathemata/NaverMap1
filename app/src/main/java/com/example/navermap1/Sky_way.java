package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sky_way extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sky_way_detail);

        Button MapButton = findViewById(R.id.sky_way_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Sky_way.this, AttractionMap.class);
            intent.putExtra("latitude", 37.291187);
            intent.putExtra("longitude", 127.202453);
            intent.putExtra("name", getString(R.string.skyway));
            startActivity(intent);
        });
    }
}
