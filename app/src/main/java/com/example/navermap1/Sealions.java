package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sealions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sealions_detail);

        Button MapButton = findViewById(R.id.sealions_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Sealions.this, EntertainmentMap.class);
            intent.putExtra("latitude", 37.292500);
            intent.putExtra("longitude", 127.205028);
            intent.putExtra("name", getString(R.string.sealions));
            startActivity(intent);
        });
    }
}
