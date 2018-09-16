package com.nancyngo.meatupsfinal;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MarkerOptions options = new MarkerOptions();
    private ArrayList<LatLng> latlngs = new ArrayList<>();
    private ArrayList<String> restaurants = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng lazeez = new LatLng(43.4722317,-80.5386187);
        LatLng mozys = new LatLng(43.474146,-80.532228);
        LatLng shawarma_plus_express = new LatLng(43.4720279, -80.5371931);
        LatLng phillips_shawarma = new LatLng(43.484255,-80.5406845);
        LatLng saj_time = new LatLng(43.4774736, -80.5192342);

        latlngs.add(lazeez);
        latlngs.add(mozys);
        latlngs.add(shawarma_plus_express);
        latlngs.add(phillips_shawarma);
        latlngs.add(saj_time);

        restaurants.add("Lazeez Shawarma");
        restaurants.add("Mozy's Shawarma");
        restaurants.add("Shawarma Plus Express");
        restaurants.add("Phillip's Shawarma");
        restaurants.add("Saj Time");

        for(int i = 0; i < latlngs.size(); i++){
            options.position(latlngs.get(i));
            options.title(restaurants.get(i));
            mMap.addMarker(options);
        }

        //mMap.addMarker(new MarkerOptions().position(lazeez).title("Lazeez Shawarma"));
        // Add a marker in Sydney and move the camera
        LatLng waterloo = new LatLng(43.4732756, -80.5419243);
        //mMap.addMarker(new MarkerOptions().position(waterloo).title("Marker in Waterloo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(waterloo, 14));
        mMap.addCircle(new CircleOptions().center(waterloo).radius(1000).strokeColor(Color.BLUE));



    }


    private Button btnClick;

    public void onClick (View v){
        btnClick = findViewById(R.id.button) ;

        if(v == btnClick){
            Intent match = new Intent (MapsActivity.this, MatchActivity.class);
            MapsActivity.this.startActivity(match);
            finish();
        }
    }



    public StringBuilder sbMethod() {

        //use your current location here
        double mLatitude = 43;
        double mLongitude = -80;

        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        sb.append("location=" + mLatitude + "," + mLongitude);
        sb.append("&radius=5000");
        sb.append("&types=" + "restaurant");
        sb.append("&sensor=true");
        sb.append("&key=AIzaSyBY7e-2DB7j-BlRpnZzPuuWxFqt6N-ZYjw");

        Log.d("Map", "api: " + sb.toString());

        return sb;
    }


}
