package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Rolling_x_train extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rolling_x_train_detail);

        Button MapButton = findViewById(R.id.rolling_x_train_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Rolling_x_train.this, AttractionMap.class);
            intent.putExtra("latitude", 37.292933);
            intent.putExtra("longitude", 127.201275);
            intent.putExtra("name", getString(R.string.rollingxtrain));
            startActivity(intent);
        });
    }
}
