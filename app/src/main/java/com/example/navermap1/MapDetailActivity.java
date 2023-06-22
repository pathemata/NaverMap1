package com.example.navermap1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.overlay.Marker;

public class MapDetailActivity extends AppCompatActivity {

    private NaverMap naverMap;

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
                    .add(R.id.map_container1, mapFragment)
                    .commit();
        }

        mapFragment.getMapAsync(this::onMapReady);

        // ...
    }

    private void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;

        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("latitude", 37.293759);
        double longitude = intent.getDoubleExtra("longitude", 127.202022);
        double name = intent.getDoubleExtra("name", 127.202022);

        // 초기 화면 위치 설정
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(latitude, longitude));
        naverMap.moveCamera(cameraUpdate);

        // 마커 표시
        LatLng markerPosition = new LatLng(latitude, longitude);
        Marker marker = new Marker();
        marker.setPosition(markerPosition);
        marker.setMap(naverMap);
        marker.setWidth(90);
        marker.setHeight(130);
    }

    // ...
}

