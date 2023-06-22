package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Hurricane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hurricane_detail);

        Button MapButton = findViewById(R.id.hurricane_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Hurricane.this, AttractionMap.class);
            intent.putExtra("latitude", 37.293990);
            intent.putExtra("longitude", 127.201595);
            intent.putExtra("name", getString(R.string.hurricane));
            startActivity(intent);
        });
    }
}
