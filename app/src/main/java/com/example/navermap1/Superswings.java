package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Superswings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.superswings_detail);

        Button MapButton = findViewById(R.id.superswings_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Superswings.this, EntertainmentMap.class);
            intent.putExtra("latitude", 37.292152);
            intent.putExtra("longitude", 127.203438);
            intent.putExtra("name", getString(R.string.superswings));
            startActivity(intent);
        });
    }
}
