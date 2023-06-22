package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Amazon_express extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amazon_express_detail);

        Button MapButton = findViewById(R.id.amazon_express_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Amazon_express.this, AttractionMap.class);
            intent.putExtra("latitude", 37.291200);
            intent.putExtra("longitude", 127.206472);
            intent.putExtra("name", getString(R.string.amazonexpress));
            startActivity(intent);
        });

    }
}
