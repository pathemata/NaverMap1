package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class EntertainmentList extends Fragment implements View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entertainmentlist, container, false);
        // 프래그먼트 뷰 초기화 및 이벤트 처리 등 추가 작업 수행

        LinearLayout grandadventures = view.findViewById(R.id.grandadventures);
        LinearLayout penguins = view.findViewById(R.id.penguins);
        LinearLayout sealions = view.findViewById(R.id.sealions);
        LinearLayout superswings = view.findViewById(R.id.superswings);
        LinearLayout tigers = view.findViewById(R.id.tigers);

        grandadventures.setOnClickListener(this);
        penguins.setOnClickListener(this);
        sealions.setOnClickListener(this);
        superswings.setOnClickListener(this);
        tigers.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        // 클릭 이벤트 처리
        Intent intent;

        switch (v.getId()) {
            case R.id.grandadventures:
                intent = new Intent(getActivity(), Grandadventures.class);
                startActivity(intent);
                break;
            case R.id.penguins:
                intent = new Intent(getActivity(), Penguins.class);
                startActivity(intent);
                break;
            case R.id.sealions:
                intent = new Intent(getActivity(), Sealions.class);
                startActivity(intent);
                break;
            case R.id.superswings:
                intent = new Intent(getActivity(), Superswings.class);
                startActivity(intent);
                break;
            case R.id.tigers:
                intent = new Intent(getActivity(), Tigers.class);
                startActivity(intent);
                break;


        }
    }
}
