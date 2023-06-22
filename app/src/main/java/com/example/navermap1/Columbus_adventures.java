package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Columbus_adventures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.columbus_adventures_detail);

        Button MapButton = findViewById(R.id.columbus_adventures_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Columbus_adventures.this, AttractionMap.class);
            intent.putExtra("latitude", 37.294502);
            intent.putExtra("longitude", 127.199313);
            intent.putExtra("name", getString(R.string.columbusadventures));
            startActivity(intent);
        });
    }
}
