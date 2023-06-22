package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class T_express extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_express_detail);

        Button MapButton = findViewById(R.id.t_express_map);
        MapButton.setOnClickListener(v -> {
            Intent intent = new Intent(T_express.this, AttractionMap.class);
            intent.putExtra("latitude", 37.289946);
            intent.putExtra("longitude", 127.202618);
            intent.putExtra("name", getString(R.string.texpress));
            startActivity(intent);
        });
    }
}
