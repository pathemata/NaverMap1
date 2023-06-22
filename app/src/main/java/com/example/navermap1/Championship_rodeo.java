package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Championship_rodeo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.championship_rodeo_detail);

        Button MapButton = findViewById(R.id.championship_rodeo_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Championship_rodeo.this, AttractionMap.class);
            intent.putExtra("latitude", 37.294178);
            intent.putExtra("longitude", 127.200781);
            intent.putExtra("name", getString(R.string.championshiprodeo));
            startActivity(intent);
        });
    }

}
