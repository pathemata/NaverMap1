package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Peter_pan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peter_pan_detail);

        Button MapButton = findViewById(R.id.peter_pan_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Peter_pan.this, AttractionMap.class);
            intent.putExtra("latitude", 37.292636);
            intent.putExtra("longitude", 127.198944);
            intent.putExtra("name", getString(R.string.peterpan));
            startActivity(intent);
        });
    }
}
