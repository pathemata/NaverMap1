package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class AttractionList extends Fragment implements View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attractionlist, container, false);
        // 프래그먼트 뷰 초기화 및 이벤트 처리 등 추가 작업 수행

        LinearLayout amazon_express = view.findViewById(R.id.amazon_express);
        LinearLayout bumper_cars = view.findViewById(R.id.bumper_cars);
        LinearLayout championship_rodeo = view.findViewById(R.id.championship_rodeo);
        LinearLayout columbus_adventures = view.findViewById(R.id.columbus_adventures);
        LinearLayout double_rock_spin = view.findViewById(R.id.double_rock_spin);
        LinearLayout hurricane = view.findViewById(R.id.hurricane);
        LinearLayout lets_twist = view.findViewById(R.id.lets_twist);
        LinearLayout panda_world = view.findViewById(R.id.panda_world);
        LinearLayout peter_pan = view.findViewById(R.id.peter_pan);
        LinearLayout rolling_x_train = view.findViewById(R.id.rolling_x_train);
        LinearLayout safari_world = view.findViewById(R.id.safari_world);
        LinearLayout sky_cruise = view.findViewById(R.id.sky_cruise);
        LinearLayout sky_way = view.findViewById(R.id.sky_way);
        LinearLayout t_express = view.findViewById(R.id.t_express);
        LinearLayout thunder_falls = view.findViewById(R.id.thunder_falls);

        amazon_express.setOnClickListener(this);
        bumper_cars.setOnClickListener(this);
        championship_rodeo.setOnClickListener(this);
        columbus_adventures.setOnClickListener(this);
        double_rock_spin.setOnClickListener(this);
        hurricane.setOnClickListener(this);
        lets_twist.setOnClickListener(this);
        panda_world.setOnClickListener(this);
        peter_pan.setOnClickListener(this);
        rolling_x_train.setOnClickListener(this);
        safari_world.setOnClickListener(this);
        sky_cruise.setOnClickListener(this);
        sky_way.setOnClickListener(this);
        t_express.setOnClickListener(this);
        thunder_falls.setOnClickListener(this);

        
        

        return view;
    }

    @Override
    public void onClick(View v) {
        // 클릭 이벤트 처리
        Intent intent;

        switch (v.getId()) {
            case R.id.amazon_express:
                intent = new Intent(getActivity(), Amazon_express.class);
                startActivity(intent);
                break;
            case R.id.bumper_cars:
                intent = new Intent(getActivity(), Bumper_cars.class);
                startActivity(intent);
                break;
            case R.id.championship_rodeo:
                intent = new Intent(getActivity(), Championship_rodeo.class);
                startActivity(intent);
                break;
            case R.id.columbus_adventures:
                intent = new Intent(getActivity(), Columbus_adventures.class);
                startActivity(intent);
                break;
            case R.id.double_rock_spin:
                intent = new Intent(getActivity(), Double_rock_spin.class);
                startActivity(intent);
                break;
            case R.id.hurricane:
                intent = new Intent(getActivity(), Hurricane.class);
                startActivity(intent);
                break;
            case R.id.lets_twist:
                intent = new Intent(getActivity(), Lets_twist.class);
                startActivity(intent);
                break;
            case R.id.panda_world:
                intent = new Intent(getActivity(), Panda_world.class);
                startActivity(intent);
                break;
            case R.id.peter_pan:
                intent = new Intent(getActivity(), Peter_pan.class);
                startActivity(intent);
                break;
            case R.id.rolling_x_train:
                intent = new Intent(getActivity(), Rolling_x_train.class);
                startActivity(intent);
                break;
            case R.id.safari_world:
                intent = new Intent(getActivity(), Safari_world.class);
                startActivity(intent);
                break;
            case R.id.sky_cruise:
                intent = new Intent(getActivity(), Sky_cruise.class);
                startActivity(intent);
                break;
            case R.id.sky_way:
                intent = new Intent(getActivity(), Sky_way.class);
                startActivity(intent);
                break;
            case R.id.t_express:
                intent = new Intent(getActivity(), T_express.class);
                startActivity(intent);
                break;
            case R.id.thunder_falls:
                intent = new Intent(getActivity(), Thunder_falls.class);
                startActivity(intent);
                break;

        }
    }
}










