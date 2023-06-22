package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Grandadventures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grandadventures_detail);

        Button MapButton = findViewById(R.id.grandadventures_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Grandadventures.this, EntertainmentMap.class);
            intent.putExtra("latitude", 37.290915);
            intent.putExtra("longitude", 127.201146);
            intent.putExtra("name", getString(R.string.grandadventures));
            startActivity(intent);
        });
    }
}
