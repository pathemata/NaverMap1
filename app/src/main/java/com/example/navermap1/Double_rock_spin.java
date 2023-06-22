package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Double_rock_spin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_rock_spin_detail);

        Button MapButton = findViewById(R.id.double_rock_spin_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Double_rock_spin.this, AttractionMap.class);
            intent.putExtra("latitude", 37.292978);
            intent.putExtra("longitude", 127.201815);
            intent.putExtra("name", getString(R.string.doublerockspin));
            startActivity(intent);
        });
    }
}
