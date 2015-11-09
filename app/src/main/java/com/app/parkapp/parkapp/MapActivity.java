package com.app.parkapp.parkapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MapActivity extends ActionBarActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Bundle extras = getIntent().getExtras();
        setTitle(extras.getString("nombre"));


        setUpMapIfNeeded();
        mMap.setMyLocationEnabled(true);

        mMap.setPadding(0, 100, 0, 100);

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

            @Override
            public void onMapLongClick(LatLng point) {
                busquedaCecana(point);
            }
        });

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

        // Add a marker in Sydney and move the camera
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(new LatLng(4.69,-74.07), 11);
        mMap.moveCamera(update);
    }

    private void setUpMapIfNeeded() {

        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {


            }
        }
    }

public void busquedaCecana(LatLng point){
    mMap.clear();
    MarkerOptions marker = new MarkerOptions().position(
            new LatLng(point.latitude, point.longitude)).icon(BitmapDescriptorFactory.fromResource(R.drawable.car));

    mMap.addMarker(marker);
    CameraUpdate update = CameraUpdateFactory.newLatLngZoom(new LatLng(point.latitude, point.longitude), 17);
    mMap.animateCamera(update);

                /*
                MarkerOptions m = new MarkerOptions().position(new LatLng(Float.parseFloat(rs.getString(1)), Float.parseFloat(rs.getString(2)))).title("test");
                Log.e("Posicion", Float.parseFloat(rs.getString(2)) + "-" + Float.parseFloat(rs.getString(3)));
                mMap.addMarker(m);
                */
    }



}
