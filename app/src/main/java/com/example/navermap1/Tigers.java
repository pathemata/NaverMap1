package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tigers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tigers_detail);

        Button MapButton = findViewById(R.id.tigers_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Tigers.this, EntertainmentMap.class);
            intent.putExtra("latitude", 37.293137);
            intent.putExtra("longitude", 127.204481);
            intent.putExtra("name", getString(R.string.tigers));
            startActivity(intent);
        });
    }
}
