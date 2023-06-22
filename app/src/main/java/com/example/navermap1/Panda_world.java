package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Panda_world extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pandaworld_detail);

        Button MapButton = findViewById(R.id.panda_world_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Panda_world.this, AttractionMap.class);
            intent.putExtra("latitude", 37.292937);
            intent.putExtra("longitude", 127.202817);
            intent.putExtra("name", getString(R.string.pandaworld));
            startActivity(intent);
        });
    }
}
