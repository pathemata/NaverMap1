package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sky_cruise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sky_cruise_detail);

        Button MapButton = findViewById(R.id.sky_cruise_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Sky_cruise.this, AttractionMap.class);
            intent.putExtra("latitude", 37.291861);
            intent.putExtra("longitude", 127.200118);
            intent.putExtra("name", getString(R.string.skycruise));
            startActivity(intent);
        });
    }
}
