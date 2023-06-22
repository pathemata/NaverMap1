package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Bumper_cars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bumper_cars_detail);

        Button MapButton = findViewById(R.id.bumper_cars_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Bumper_cars.this, AttractionMap.class);
            intent.putExtra("latitude", 37.292307);
            intent.putExtra("longitude", 127.199522);
            intent.putExtra("name", getString(R.string.bumpercars));
            startActivity(intent);
        });

    }

}
