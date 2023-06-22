package com.example.navermap1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navermap1.activities.MainActivity;
import com.example.navermap1.activities.SignInActivity;

public class StartActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 2000; // 2초 표시 시간 설정

    private LinearLayout buttonLayout;
    private Button chatButton;
    private Button mapButton;
    private Button otherButton;
    private ImageView everlandImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        buttonLayout = findViewById(R.id.button_layout);
        chatButton = findViewById(R.id.button_chat);
        mapButton = findViewById(R.id.button_map);
        otherButton = findViewById(R.id.button_other);
        everlandImage = findViewById(R.id.everlandimage);

        // 에버랜드 사진에 알파 애니메이션 적용 (흐려지는 애니메이션)
        ObjectAnimator alphaAnimatorOut = ObjectAnimator.ofFloat(everlandImage, "alpha", 1f, 0.5f);
        ObjectAnimator objectAnimator = alphaAnimatorOut.setDuration(4000);
        alphaAnimatorOut.setInterpolator(new DecelerateInterpolator());

        // 애니메이션 세트를 생성하고 애니메이션을 추가
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(alphaAnimatorOut);
        animatorSet.start();

        // 버튼 레이아웃에 알파 애니메이션 적용
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(4000); // 애니메이션 지속 시간 설정
        buttonLayout.startAnimation(fadeIn);
        buttonLayout.setVisibility(View.VISIBLE); // 버튼 레이아웃을 보이도록 설정

        // 버튼 클릭 리스너 설정
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 채팅 버튼 클릭 시 동작
                // ListActivity로 액티비티 전환 코드 작성
                Intent intent = new Intent(StartActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 지도 버튼 클릭 시 동작
                // FindActivity로 액티비티 전환 코드 작성
                Intent intent = new Intent(StartActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 기타 버튼 클릭 시 동작
                // 다른 액티비티로 전환하는 코드 작성
                Intent intent = new Intent(StartActivity.this, GptActivity.class);
                startActivity(intent);
            }
        });
    }
}
