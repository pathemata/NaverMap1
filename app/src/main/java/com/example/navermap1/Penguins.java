package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Penguins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.penguins_detail);

        Button MapButton = findViewById(R.id.penguins_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Penguins.this, EntertainmentMap.class);
            intent.putExtra("latitude", 37.292809);
            intent.putExtra("longitude", 127.204969);
            intent.putExtra("name", getString(R.string.penguins));
            startActivity(intent);
        });
    }
}
