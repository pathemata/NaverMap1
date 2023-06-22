package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class RestaurantList extends Fragment implements View.OnClickListener {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attractionlist, container, false);
        // 프래그먼트 뷰 초기화 및 이벤트 처리 등 추가 작업 수행

        LinearLayout amazon_express = view.findViewById(R.id.amazon_express);
        LinearLayout bumper_cars = view.findViewById(R.id.bumper_cars);

        amazon_express.setOnClickListener(this);
        bumper_cars.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        // 클릭 이벤트 처리
        Intent intent;

        switch (v.getId()) {
            case R.id.amazon_express:
                // attraction1 클릭 시 Activity1으로 화면 전환
                intent = new Intent(getActivity(), Amazon_express.class);
                startActivity(intent);
                break;
            case R.id.bumper_cars:
                // attraction2 클릭 시 Activity2으로 화면 전환
                intent = new Intent(getActivity(), Bumper_cars.class);
                startActivity(intent);
                break;
// 케이스 추가만 하면 넘어가는 건 끝














        }
    }
}
