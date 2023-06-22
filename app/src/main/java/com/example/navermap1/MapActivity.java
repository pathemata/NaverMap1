package com.example.navermap1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.MarkerIcons;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private static final int REQUEST_MAP_INFO = 1;

    private NaverMap naverMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mapFragment = MapFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.map_container, mapFragment);
        fragmentTransaction.commit();

        mapFragment.getMapAsync(naverMap -> {
            this.naverMap = naverMap;
            // 에버랜드의 위도와 경도를 설정합니다.
            LatLng everlandLatLng = new LatLng(37.293759, 127.202022);

            // 지도의 초기 위치를 에버랜드로 설정합니다.
            CameraUpdate cameraUpdate = CameraUpdate.scrollTo(everlandLatLng).animate(CameraAnimation.Fly);  // 애니메이션 적용 여부 설정
            naverMap.moveCamera(cameraUpdate);

            addMarkers();
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        FloatingActionButton backToStart = findViewById(R.id.back_to_start);
        backToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DetailFindActivity로 전달할 인텐트 생성
                Intent intent = new Intent(MapActivity.this, com.example.navermap1.StartActivity.class);
                // DetailFindActivity 호출
                startActivity(intent);
            }
        });
    }

    private void addMarkers() {

        //어트랙션
        LatLng  pandaworld = new LatLng(37.292937, 127.202817);
        LatLng  bumpercars = new LatLng(37.292307, 127.199522);
        LatLng  championshiprodeo = new LatLng(37.294178, 127.200781);
        LatLng  amazonexpress = new LatLng(37.291200, 127.206472);
        LatLng  columbusadventures = new LatLng(37.294502, 127.199313);
        LatLng  thunderfalls = new LatLng(37.293674, 127.198569);
        LatLng  texpress = new LatLng(37.289946, 127.202618);
        LatLng  doublerockspin = new LatLng(37.292978, 127.201815);
        LatLng  hurricane = new LatLng(37.294046, 1270202129);
        LatLng  letstwist = new LatLng(37.292706, 127.200860);
        LatLng  peterpan = new LatLng(37.292636, 127.198944);
        LatLng  rollingxtrain = new LatLng(37.292933, 127.201275);
        LatLng  safariworld = new LatLng(37.290898, 127.205005);
        LatLng  skycruise = new LatLng(37.291861, 127.200118);
        LatLng  skyway = new LatLng(37.291187, 127.202453);

        //엔터테인먼트
        LatLng  superswings = new LatLng(37.292152, 127.203438);
        LatLng  penguins = new LatLng(37.292809, 127.204969);
        LatLng  sealions = new LatLng(37.292500, 127.205028);
        LatLng  grandadventures = new LatLng(37.290915, 127.201146);
        LatLng  tigers = new LatLng(37.293137, 127.204481);


        //화장실
        LatLng  bath1 = new LatLng(37.292124, 127.199837);
        LatLng  bath2 = new LatLng(37.291953, 127.201332);
        LatLng  bath3 = new LatLng(37.292436, 127.202482);
        LatLng  bath4 = new LatLng(37.293206, 127.202767);
        LatLng  bath5 = new LatLng(37.292675, 127.200511);
        LatLng  bath6 = new LatLng(37.294395, 127.199242);
        LatLng  bath7 = new LatLng(37.292612, 127.198558);
        LatLng  bath8 = new LatLng(37.290659, 127.203195);
        LatLng  bath9 = new LatLng(37.291396, 127.204733);

        List<LatLng> bathList = new ArrayList<>();
        bathList.add(bath1);
        bathList.add(bath2);
        bathList.add(bath3);
        bathList.add(bath4);
        bathList.add(bath5);
        bathList.add(bath6);
        bathList.add(bath7);
        bathList.add(bath8);
        bathList.add(bath9);

        Marker[] bathMarkers = new Marker[9];
        for (int i = 0; i < bathMarkers.length; i++) {
            LatLng position = bathList.get(i);
            bathMarkers[i] = new Marker();
            bathMarkers[i].setPosition(position); // 마커의 위치 설정


            BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.bathroom);
            OverlayImage icon = OverlayImage.fromBitmap(bitmapDrawable.getBitmap());
            bathMarkers[i].setIcon(icon); // 마커 아이콘 설정

            bathMarkers[i].setWidth(70);
            bathMarkers[i].setHeight(70);
            bathMarkers[i].setCaptionText(getResources().getString(R.string.bath));
            bathMarkers[i].setMap(naverMap); // 마커를 지도에 추가
        }

        //어트랙션
        Marker pandaworldMarker = new Marker();
        Marker bumpercarsMarker = new Marker();
        Marker championshiprodeoMarker = new Marker();
        Marker amazonexpressMarker = new Marker();
        Marker columbusadventuresMarker = new Marker();
        Marker thunderfallsMarker = new Marker();
        Marker texpressMarker = new Marker();
        Marker doublerockspinMarker = new Marker();
        Marker hurricaneMarker = new Marker();
        Marker letstwistMarker = new Marker();
        Marker peterpanMarker = new Marker();
        Marker rollingxtrainMarker = new Marker();
        Marker safariworldMarker = new Marker();
        Marker skycruiseMarker = new Marker();
        Marker skywayMarker = new Marker();

        //엔터테인먼트
        Marker superswingsMarker = new Marker();
        Marker penguinsMarker = new Marker();
        Marker sealionsMarker = new Marker();
        Marker grandadventuresMarker = new Marker();
        Marker tigersMarker = new Marker();

        //어트랙션
        pandaworldMarker.setPosition(pandaworld);
        bumpercarsMarker.setPosition(bumpercars);
        championshiprodeoMarker.setPosition(championshiprodeo);
        amazonexpressMarker.setPosition(amazonexpress);
        columbusadventuresMarker.setPosition(columbusadventures);
        thunderfallsMarker.setPosition(thunderfalls);
        texpressMarker.setPosition(texpress);
        doublerockspinMarker.setPosition(doublerockspin);
        hurricaneMarker.setPosition(hurricane);
        letstwistMarker.setPosition(letstwist);
        peterpanMarker.setPosition(peterpan);
        rollingxtrainMarker.setPosition(rollingxtrain);
        safariworldMarker.setPosition(safariworld);
        skycruiseMarker.setPosition(skycruise);
        skywayMarker.setPosition(skyway);

        //엔터테인먼트
        superswingsMarker.setPosition(superswings);
        penguinsMarker.setPosition(penguins);
        sealionsMarker.setPosition(sealions);
        grandadventuresMarker.setPosition(grandadventures);
        tigersMarker.setPosition(tigers);

        //어트랙션
        pandaworldMarker.setMap(naverMap);
        bumpercarsMarker.setMap(naverMap);
        championshiprodeoMarker.setMap(naverMap);
        amazonexpressMarker.setMap(naverMap);
        columbusadventuresMarker.setMap(naverMap);
        thunderfallsMarker.setMap(naverMap);
        texpressMarker.setMap(naverMap);
        doublerockspinMarker.setMap(naverMap);
        hurricaneMarker.setMap(naverMap);
        letstwistMarker.setMap(naverMap);
        peterpanMarker.setMap(naverMap);
        rollingxtrainMarker.setMap(naverMap);
        safariworldMarker.setMap(naverMap);
        skycruiseMarker.setMap(naverMap);
        skywayMarker.setMap(naverMap);

        //엔터테인먼트
        superswingsMarker.setMap(naverMap);
        penguinsMarker.setMap(naverMap);
        sealionsMarker.setMap(naverMap);
        grandadventuresMarker.setMap(naverMap);
        tigersMarker.setMap(naverMap);

        //어트랙션
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.attraction);
        OverlayImage attraction = OverlayImage.fromBitmap(bitmapDrawable.getBitmap());

        pandaworldMarker.setIcon(attraction);
        bumpercarsMarker.setIcon(attraction);
        championshiprodeoMarker.setIcon(attraction);
        amazonexpressMarker.setIcon(attraction);
        columbusadventuresMarker.setIcon(attraction);
        thunderfallsMarker.setIcon(attraction);
        texpressMarker.setIcon(attraction);
        doublerockspinMarker.setIcon(attraction);
        hurricaneMarker.setIcon(attraction);
        letstwistMarker.setIcon(attraction);
        peterpanMarker.setIcon(attraction);
        rollingxtrainMarker.setIcon(attraction);
        safariworldMarker.setIcon(attraction);
        skycruiseMarker.setIcon(attraction);
        skywayMarker.setIcon(attraction);

        pandaworldMarker.setWidth(90);
        pandaworldMarker.setHeight(130);
        bumpercarsMarker.setWidth(90);
        bumpercarsMarker.setHeight(130);
        championshiprodeoMarker.setWidth(90);
        championshiprodeoMarker.setHeight(130);
        amazonexpressMarker.setWidth(90);
        amazonexpressMarker.setHeight(130);
        columbusadventuresMarker.setWidth(90);
        columbusadventuresMarker.setHeight(130);
        thunderfallsMarker.setWidth(90);
        thunderfallsMarker.setHeight(130);
        texpressMarker.setWidth(90);
        texpressMarker.setHeight(130);
        doublerockspinMarker.setWidth(90);
        doublerockspinMarker.setHeight(130);
        hurricaneMarker.setWidth(90);
        hurricaneMarker.setHeight(130);
        letstwistMarker.setWidth(90);
        letstwistMarker.setHeight(130);
        peterpanMarker.setWidth(90);
        peterpanMarker.setHeight(130);
        rollingxtrainMarker.setWidth(90);
        rollingxtrainMarker.setHeight(130);
        safariworldMarker.setWidth(90);
        safariworldMarker.setHeight(130);
        skycruiseMarker.setWidth(90);
        skycruiseMarker.setHeight(130);
        skywayMarker.setWidth(90);
        skywayMarker.setHeight(130);

        //엔터테인먼트
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.entertainment);
        OverlayImage entertainment = OverlayImage.fromBitmap(bitmapDrawable2.getBitmap());

        superswingsMarker.setIcon(entertainment);
        penguinsMarker.setIcon(entertainment);
        sealionsMarker.setIcon(entertainment);
        grandadventuresMarker.setIcon(entertainment);
        tigersMarker.setIcon(entertainment);


        superswingsMarker.setWidth(90);
        superswingsMarker.setHeight(130);
        penguinsMarker.setWidth(90);
        penguinsMarker.setHeight(130);
        sealionsMarker.setWidth(90);
        sealionsMarker.setHeight(130);
        grandadventuresMarker.setWidth(90);
        grandadventuresMarker.setHeight(130);
        tigersMarker.setWidth(90);
        tigersMarker.setHeight(130);


        //어트랙션
        pandaworldMarker.setCaptionText(getResources().getString(R.string.pandaworld));
        bumpercarsMarker.setCaptionText(getResources().getString(R.string.bumpercars));
        championshiprodeoMarker.setCaptionText(getResources().getString(R.string.championshiprodeo));
        amazonexpressMarker.setCaptionText(getResources().getString(R.string.amazonexpress));
        columbusadventuresMarker.setCaptionText(getResources().getString(R.string.columbusadventures));
        thunderfallsMarker.setCaptionText(getResources().getString(R.string.thunderfalls));
        texpressMarker.setCaptionText(getResources().getString(R.string.texpress));
        doublerockspinMarker.setCaptionText(getResources().getString(R.string.doublerockspin));
        hurricaneMarker.setCaptionText(getResources().getString(R.string.hurricane));
        letstwistMarker.setCaptionText(getResources().getString(R.string.letstwist));
        peterpanMarker.setCaptionText(getResources().getString(R.string.peterpan));
        rollingxtrainMarker.setCaptionText(getResources().getString(R.string.rollingxtrain));
        safariworldMarker.setCaptionText(getResources().getString(R.string.safariworld));
        skycruiseMarker.setCaptionText(getResources().getString(R.string.skycruise));
        skywayMarker.setCaptionText(getResources().getString(R.string.skyway));

        //엔터테인먼트
        superswingsMarker.setCaptionText(getResources().getString(R.string.superswings));
        penguinsMarker.setCaptionText(getResources().getString(R.string.penguins));
        sealionsMarker.setCaptionText(getResources().getString(R.string.sealions));
        grandadventuresMarker.setCaptionText(getResources().getString(R.string.grandadventures));
        tigersMarker.setCaptionText(getResources().getString(R.string.tigers));

        pandaworldMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.pandaworld); //이름 설정
                String mapDetail = getResources().getString(R.string.pandaworld_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.panda_world);
                startActivity(intent);
                return false;
            }
        });

        bumpercarsMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.bumpercars); //이름 설정
                String mapDetail = getResources().getString(R.string.bumpercars_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.bumper_cars);
                startActivity(intent);
                return false;
            }
        });

        championshiprodeoMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.championshiprodeo); //이름 설정
                String mapDetail = getResources().getString(R.string.championshiprodeo_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.championship_rodeo);
                startActivity(intent);
                return false;
            }
        });

        amazonexpressMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.amazonexpress); //이름 설정
                String mapDetail = getResources().getString(R.string.amazonexpress_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.amazon_express);
                startActivity(intent);
                return false;
            }
        });

        columbusadventuresMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.columbusadventures); //이름 설정
                String mapDetail = getResources().getString(R.string.columbusadventures_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.columbus_adventures);
                startActivity(intent);
                return false;
            }
        });

        thunderfallsMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.thunderfalls); //이름 설정
                String mapDetail = getResources().getString(R.string.thunderfalls_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.thunder_falls);
                startActivity(intent);
                return false;
            }
        });


        texpressMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.texpress); //이름 설정
                String mapDetail = getResources().getString(R.string.texpress_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.t_express);
                startActivity(intent);
                return false;
            }
        });

        doublerockspinMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.doublerockspin); //이름 설정
                String mapDetail = getResources().getString(R.string.doublerockspin_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.double_rock_spin);
                startActivity(intent);
                return false;
            }
        });

        hurricaneMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.hurricane); //이름 설정
                String mapDetail = getResources().getString(R.string.hurricane_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.hurricane);
                startActivity(intent);
                return false;
            }
        });

        letstwistMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.letstwist); //이름 설정
                String mapDetail = getResources().getString(R.string.letstwist_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.lets_twist);
                startActivity(intent);
                return false;
            }
        });

        peterpanMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.peterpan); //이름 설정
                String mapDetail = getResources().getString(R.string.peterpan_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.peter_pan);
                startActivity(intent);
                return false;
            }
        });

        rollingxtrainMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.rollingxtrain); //이름 설정
                String mapDetail = getResources().getString(R.string.rollingxtrain_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.rolling_x_train);
                startActivity(intent);
                return false;
            }
        });

        safariworldMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.safariworld); //이름 설정
                String mapDetail = getResources().getString(R.string.safariworld_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.safari_world);
                startActivity(intent);
                return false;
            }
        });

        skycruiseMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.skycruise); //이름 설정
                String mapDetail = getResources().getString(R.string.skycruise_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.sky_cruise);
                startActivity(intent);
                return false;
            }
        });

        skywayMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.skyway); //이름 설정
                String mapDetail = getResources().getString(R.string.skycruise_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.sky_way);
                startActivity(intent);
                return false;
            }
        });

        superswingsMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.superswings); //이름 설정
                String mapDetail = getResources().getString(R.string.superswings_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.superswings);
                startActivity(intent);
                return false;
            }
        });

        penguinsMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.penguins); //이름 설정
                String mapDetail = getResources().getString(R.string.penguins_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.penguins);
                startActivity(intent);
                return false;
            }
        });

        sealionsMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.sealions); //이름 설정
                String mapDetail = getResources().getString(R.string.sealions_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.sealions);
                startActivity(intent);
                return false;
            }
        });

        grandadventuresMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.grandadventures); //이름 설정
                String mapDetail = getResources().getString(R.string.grandadventures_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.grandadventures);
                startActivity(intent);
                return false;
            }
        });

        tigersMarker.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                String mapInfoName = getResources().getString(R.string.tigers); //이름 설정
                String mapDetail = getResources().getString(R.string.tigers_detail); // 설명 설정
                Intent intent = new Intent(MapActivity.this, MapInfo.class);
                intent.putExtra("name", mapInfoName);
                intent.putExtra("detail", mapDetail);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("layout", R.layout.tigers);
                startActivity(intent);
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_MAP_INFO && resultCode == RESULT_OK) {
            // MapInfo 액티비티에서 돌아왔을 때의 처리
            // 예: 필요한 작업을 수행하거나 데이터를 업데이트하는 등의 코드를 추가하세요
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.option1) {
            Intent intent = new Intent(MapActivity.this, ListActivity.class);
            startActivity(intent);
            return true;
        }
        else if (itemId == R.id.option2) {
            Intent intent = new Intent(MapActivity.this, FindActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}