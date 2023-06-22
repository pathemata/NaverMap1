package com.example.navermap1;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.MarkerIcons;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DetailFindActivity extends AppCompatActivity {
    private static final int TOAST_DELAY = 3000;
    final Handler handler = new Handler();
    final Handler handler1 = new Handler();
    final int delay = 4100;
    private List<Location> myLocations;
    private NaverMap naverMap;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_find);

        mapView = findViewById(R.id.map_view);

        MapFragment mapFragment = MapFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.map_view, mapFragment);
        fragmentTransaction.commit();

        // FindActivity로부터 위치 정보 리스트 전달 받기
        myLocations = getIntent().getParcelableArrayListExtra("myLocations");

        // 최적의 경로 찾기
        List<Location> optimalRoute = findOptimalRoute(myLocations);


        for (int i = 0; i < optimalRoute.size(); i++) {
            final int index1 = i;
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Location location = optimalRoute.get(index1);

                    double lat = location.getLatitude();
                    double lng = location.getLongitude();

                    String id = getIdForLocation(lat, lng);
                    String message;
                    if (index1 != 0) {
                        message = index1 + "번째 " + id;
                    } else {
                        message = "최적의 경로를 알려드리겠습니다!";
                    }
                    Toast.makeText(DetailFindActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }, (long) TOAST_DELAY * i);
        }

        mapFragment.getMapAsync(naverMap -> {
            this.naverMap = naverMap;
            for (int i = 0; i < optimalRoute.size(); i++) {

                final int index = i;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Location location = optimalRoute.get(index);
                        double lat = location.getLatitude();
                        double lng = location.getLongitude();
                        String id = getIdForLocation(lat, lng);

                        LatLng pos = new LatLng(lat, lng);
                        Marker marker = new Marker();
                        marker.setPosition(pos);
                        marker.setWidth(70);
                        marker.setHeight(100);
                        marker.setCaptionText(index+"번 "+id);

                        if (index == 0){
                            marker.setWidth(50);
                            marker.setHeight(50);
                            marker.setIcon(MarkerIcons.BLACK);
                            marker.setCaptionText("현위치");
                        } else if (index % 8 == 1) {
                            marker.setIcon(MarkerIcons.RED);
                        } else if (index % 8  == 2) {
                            marker.setIcon(MarkerIcons.PINK);
                        } else if (index % 8  == 3) {
                            marker.setIcon(MarkerIcons.YELLOW);
                        } else if (index % 8  == 4) {
                            marker.setIcon(MarkerIcons.GREEN);
                        } else if (index % 8  == 5) {
                            marker.setIcon(MarkerIcons.LIGHTBLUE);
                        } else if (index % 8  == 6) {
                            marker.setIcon(MarkerIcons.BLUE);
                        } else if (index % 8  == 7){
                            marker.setIcon(MarkerIcons.GRAY);
                        } else if (index % 8  == 0 && index != 0){
                            marker.setIcon(MarkerIcons.BLACK);
                        }
                        marker.setMap(naverMap);

                        // 더 이상 마커를 표시하지 않을 때까지 계속 반복
                        if (index < optimalRoute.size() - 1) {
                            handler.postDelayed(this, delay);
                        }
                    }
                }, (long) delay * i);
            }
            LatLng everlandLatLng = new LatLng(37.293759, 127.202022);
            CameraUpdate cameraUpdate = CameraUpdate.scrollTo(everlandLatLng);
            naverMap.moveCamera(cameraUpdate);

            mapView.onResume();
        });

        FloatingActionButton reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DetailFindActivity로 전달할 인텐트 생성
                Intent intent = new Intent(DetailFindActivity.this, com.example.navermap1.FindActivity.class);
                // DetailFindActivity 호출
                myLocations = new ArrayList<>();
                startActivity(intent);
            }
        });
    }

    // Nearest Neighbor 알고리즘 사용함
    private List<Location> findOptimalRoute(List<Location> locations) {
        List<Location> optimalRoute = new ArrayList<>();
        List<Location> remainingLocations = new ArrayList<>(locations);

        // 첫 번째 위치를 시작점으로 선택
        Location firstLocation = remainingLocations.remove(0);
        optimalRoute.add(firstLocation);

        // 현재 위치를 첫 번째 위치로 설정
        Location currentLocation = firstLocation;

        while (!remainingLocations.isEmpty()) {
            double minDistance = Double.MAX_VALUE;
            Location closestLocation = null;

            // 현재 위치에서 가장 가까운 위치 찾기
            for (Location location : remainingLocations) {
                double distance = calculateDistance(currentLocation, location);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestLocation = location;
                }
            }
            // 가장 가까운 위치를 다음 위치로 선택
            currentLocation = closestLocation;
            optimalRoute.add(currentLocation);
            remainingLocations.remove(closestLocation);
        }

        return optimalRoute;
    }

    private double calculateDistance(Location location1, Location location2) {
        // 두 위치 사이의 거리 계산 로직
        // 예시 코드를 그대로 사용했으므로, 실제로는 좌표 간 거리를 정확하게 계산

        double lat1 = location1.getLatitude();
        double lng1 = location1.getLongitude();
        double lat2 = location2.getLatitude();
        double lng2 = location2.getLongitude();

        double distance = Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lng2 - lng1, 2));
        return distance;
    }
    private void showSortedLocations(List<Location> sortedLocations) {
        Handler handler = new Handler();
        for (int i = 0; i < sortedLocations.size(); i++) {
            Location location = sortedLocations.get(i);
            double lat = location.getLatitude();
            double lng = location.getLongitude();

            String id = getIdForLocation(lat, lng);
            String message;
            if (i > 0) {
                message = i + "번째 " + id;
            } else {
                message = "최적의 경로를 알려드리겠습니다!";
            }

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(DetailFindActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }, i * TOAST_DELAY);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mapView != null) {
            mapView.onResume();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mapView != null) {
            mapView.onPause();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapView != null) {
            mapView.onDestroy();
        }
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }
    private String getIdForLocation(double lat, double lng) {
        if (lat == 37.291200 && lng == 127.206472) {
            return "아마존 익스프레스";
        }
        else if (lat == 37.292307 && lng == 127.199522) {
            return "범퍼카";
        }
        else if (lat == 37.294178 && lng == 127.200781) {
            return "챔피언쉽 로데오";
        }
        else if (lat == 37.294502 && lng == 127.199313) {
            return "콜럼버스 어드벤쳐";
        }
        else if (lat == 37.292978 && lng == 127.201815) {
            return "더블락스핀";
        }
        else if (lat == 37.293990 && lng == 127.201595) {
            return "허리케인";
        }
        else if (lat == 37.292706 && lng == 127.200860) {
            return "렛츠 트위스트";
        }
        else if (lat == 37.292937 && lng == 127.202817) {
            return "판다월드";
        }
        else if (lat == 37.292636 && lng == 127.198944) {
            return "피터팬";
        }
        else if (lat == 37.292933 && lng == 127.201275) {
            return "롤링엑스 트레인";
        }
        else if (lat == 37.290898 && lng == 127.205005) {
            return "사파리월드";
        }
        else if (lat == 37.291861 && lng == 127.200118) {
            return "스카이 크루즈";
        }
        else if (lat == 37.291187 && lng == 127.202453) {
            return "스카이 웨이";
        }
        else if (lat == 37.289946 && lng == 127.202618) {
            return "T익스프레스";
        }
        else if (lat == 37.293674 && lng == 127.198569) {
            return "썬더폴스";
        }
        else if (lat == 37.290915 && lng == 127.201146) {
            return "레니의 대모험";
        }
        else if (lat == 37.292809 && lng == 127.204969) {
            return "펭귄아일랜드";
        }
        else if (lat == 37.292500 && lng == 127.205028) {
            return "씨라이언 빌리지";
        }
        else if (lat == 37.292152 && lng == 127.203438) {
            return "수퍼 윙스";
        }
        else if (lat == 37.293137 && lng == 127.204481) {
            return "타이거 밸리";
        }
        return "현위치";
    }
}

