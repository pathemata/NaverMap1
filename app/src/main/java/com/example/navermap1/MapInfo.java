package com.example.navermap1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Math.round;

public class MapInfo extends AppCompatActivity {

    private TextView getMapInfoName;
    private TextView getMapInfoDetail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        int layout1 = getIntent().getIntExtra("layout", 0);
        setContentView(layout1);

        getMapInfoName = findViewById(R.id.map_info_name);
        getMapInfoDetail = findViewById(R.id.map_info_detail);

        String name = getIntent().getStringExtra("name");
        String detail = getIntent().getStringExtra("detail");

        getMapInfoName.setText(name);
        getMapInfoDetail.setText(detail);
        initLayout();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 오버레이 액티비티를 종료하고자 하는 터치 이벤트를 처리
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            finish(); // 액티비티 종료
            return true; // 이벤트 소비
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_OK);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initLayout();
    }

    private void initLayout() {

        Display display = getWindowManager().getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        getWindow().setLayout((int) round(width * 1), (int) round(height * 0.17));

        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}