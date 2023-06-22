package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lets_twist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lets_twist_detail);

        Button MapButton = findViewById(R.id.lets_twist_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lets_twist.this, AttractionMap.class);
            intent.putExtra("latitude", 37.292706);
            intent.putExtra("longitude", 127.200860);
            intent.putExtra("name", getString(R.string.letstwist));
            startActivity(intent);
        });
    }

}
