package com.example.navermap1;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;

public class AttractionMap extends AppCompatActivity {

    private NaverMap naverMap;
    private FloatingActionButton myF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_detail);

        // 네이버지도 초기화 및 설정
        NaverMapSdk.getInstance(this).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("7nphjuik8j")
        );

        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.map_container, mapFragment)
                    .commit();
        }

        mapFragment.getMapAsync(this::onMapReady);

        // ...

       setOnclicklistener();
    }

    public void setOnclicklistener()
    {
        myF= findViewById(R.id.backback);
        myF.setOnClickListener(v->onBackPressed());
    }


    private void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;

        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("latitude", 37.293759);
        double longitude = intent.getDoubleExtra("longitude", 127.202022);
        String name = intent.getStringExtra("name");

        // 초기 화면 위치 설정
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(latitude, longitude));
        naverMap.moveCamera(cameraUpdate);

        // 마커 표시
        LatLng markerPosition = new LatLng(latitude, longitude);
        Marker marker = new Marker();
        marker.setPosition(markerPosition);
        marker.setMap(naverMap);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.attraction);
        OverlayImage attraction = OverlayImage.fromBitmap(bitmapDrawable.getBitmap());
        marker.setIcon(attraction);
        marker.setWidth(90);
        marker.setHeight(130);
        // name 값 활용하여 마커에 텍스트 적용
        if (name != null) {
            marker.setCaptionText(name);
        }
    }
    // ...
}

