package com.example.navermap1;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.navermap1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FindActivity extends AppCompatActivity {

    private LocationManager locationManager;
    ArrayList<Location> myLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        myLocations = new ArrayList<>();
        // 위치 관리자 초기화
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        FloatingActionButton backToMap = findViewById(R.id.back_to_map_2);
        backToMap.setOnClickListener(v->{
            Intent intent = new Intent(FindActivity.this, com.example.navermap1.MapActivity.class);
            startActivity(intent);
        });

        Button selectEndButton = findViewById(R.id.select_end);
        selectEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DetailFindActivity로 전달할 인텐트 생성
                Intent intent = new Intent(FindActivity.this, com.example.navermap1.DetailFindActivity.class);

                // myLocations를 인텐트에 추가
                intent.putParcelableArrayListExtra("myLocations", myLocations);

                // DetailFindActivity 호출
                startActivity(intent);
            }
        });
        Button selectNowButton = findViewById(R.id.select_now);
        selectNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(FindActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // 권한이 없을 경우 권한 요청
                    ActivityCompat.requestPermissions(FindActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    return;
                }

                // 위치 관리자 초기화
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                // 최적의 위치 제공자 선택
                Criteria criteria = new Criteria();
                String bestProvider = locationManager.getBestProvider(criteria, false);

                // 최적의 위치 제공자를 사용하여 현재 위치 요청
                locationManager.requestSingleUpdate(bestProvider, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();

                        Location clicked = new Location("");
                        clicked.setLatitude(latitude);
                        clicked.setLongitude(longitude);

                        myLocations.add(clicked);

                        // 위치 업데이트를 더 이상 받지 않기 위해 위치 관리자의 업데이트 요청을 제거할 수도 있습니다.
                        locationManager.removeUpdates(this);
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                    }
                }, null);

            }
        });

        findViewById(R.id.amazon_express_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.291200);
                clicked.setLongitude(127.206472);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.bumper_cars_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292307);
                clicked.setLongitude(127.199522);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.championship_rodeo_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.294178);
                clicked.setLongitude(127.200781);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.columbus_adventures_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.294502);
                clicked.setLongitude(127.199313);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.double_rock_spin_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292978);
                clicked.setLongitude(127.201815);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.hurricane_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.293990);
                clicked.setLongitude(127.201595);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.lets_twist_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292706);
                clicked.setLongitude(127.200860);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.panda_world_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292937);
                clicked.setLongitude(127.202817);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.peter_pan_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292636);
                clicked.setLongitude(127.198944);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.rolling_x_train_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292933);
                clicked.setLongitude(127.201275);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.safari_world_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.290898);
                clicked.setLongitude(127.205005);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.sky_cruise_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.291861);
                clicked.setLongitude(127.200118);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.sky_way_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.291187);
                clicked.setLongitude(127.202453);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.t_express_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.289946);
                clicked.setLongitude(127.202618);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.thunder_falls_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.293674);
                clicked.setLongitude(127.198569);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.grandadventures_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.290915);
                clicked.setLongitude(127.201146);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.penguins_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292809);
                clicked.setLongitude(127.204969);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.sealions_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292500);
                clicked.setLongitude(127.205028);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.superswings_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.292152);
                clicked.setLongitude(127.203438);
                myLocations.add(clicked);
            }
        });

        findViewById(R.id.tigers_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location clicked = new Location("");
                clicked.setLatitude(37.293137);
                clicked.setLongitude(127.204481);
                myLocations.add(clicked);
            }
        });
    }

}
