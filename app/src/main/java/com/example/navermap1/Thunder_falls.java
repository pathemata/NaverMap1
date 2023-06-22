package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Thunder_falls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thunder_falls_detail);

        Button MapButton = findViewById(R.id.thunder_falls_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Thunder_falls.this, AttractionMap.class);
            intent.putExtra("latitude", 37.293674);
            intent.putExtra("longitude", 127.198569);
            intent.putExtra("name", getString(R.string.thunderfalls));
            startActivity(intent);
        });
    }

}
