package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Safari_world extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safari_world_detail);

        Button MapButton = findViewById(R.id.safari_world_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Safari_world.this, AttractionMap.class);
            intent.putExtra("latitude", 37.290898);
            intent.putExtra("longitude", 127.205005);
            intent.putExtra("name", getString(R.string.safariworld));
            startActivity(intent);
        });
    }
}
