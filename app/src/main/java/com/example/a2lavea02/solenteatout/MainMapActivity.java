package com.example.a2lavea02.solenteatout;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.MenuInflater;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainMapActivity extends AppCompatActivity implements LocationListener {

    ItemizedIconOverlay<OverlayItem> items;
    ItemizedIconOverlay.OnItemGestureListener<OverlayItem> markerGestureListener;
    double lon = 50.9097;
    double lat = 1.4044;
    MapView mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);

        mv = (MapView) findViewById(R.id.map1);
        mv.setBuiltInZoomControls(true);

        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(51.8361, -0.4577));

        LocationManager mgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        markerGestureListener = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            public boolean onItemLongPress(int i, OverlayItem item) {
                Toast.makeText(MainMapActivity.this, item.getSnippet(), Toast.LENGTH_SHORT).show();
                return true;
            }

            public boolean onItemSingleTapUp(int i, OverlayItem item) {
                Toast.makeText(MainMapActivity.this, item.getSnippet(), Toast.LENGTH_SHORT).show();
                return true;
            }
        };
        items = new ItemizedIconOverlay<OverlayItem>(this, new ArrayList<OverlayItem>(), markerGestureListener);
    }

    public void onLocationChanged(Location newLoc) {
        mv.getController().setCenter(new GeoPoint(newLoc.getLatitude(), newLoc.getLongitude()));
    }

    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Provider" + provider + " disabled", Toast.LENGTH_SHORT).show();
    }

    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Provider" + provider + " enabled", Toast.LENGTH_SHORT).show();
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(this, "Status Changed: " + status, Toast.LENGTH_SHORT).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mainactivity) {
            // react to the menu being selected.
            Intent intent = new Intent(this, MainMapActivity.class);
            startActivityForResult(intent, 0);
            return true;
        }
            if (item.getItemId() == R.id.addrestaurant) {
                // react to the menu being selected.
                Intent intent = new Intent(this, Addrestaurant.class);
                startActivityForResult(intent, 0);
                return true;
            }
            return false;
        // save menu item that saves all markers...
        // load menu item to load all markers....
        }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == 0){
            if(resultCode == RESULT_OK) {
                Bundle extras = intent.getExtras();

                String stringrestname = extras.getString("com.example.a2lavea02.solenteatout.RestName");
                String stringrestadd = extras.getString("com.example.a2lavea02.solenteatout.RestAdd");
                String stringcuisine = extras.getString("com.example.a2lavea02.solenteatout.RestCuisine");
                String stringrating = extras.getString("com.example.a2lavea02.solenteatout.RestRating");


                OverlayItem addnewRestaurant = new OverlayItem(stringrestname, stringrestadd, new GeoPoint(lat, lon));
                items.addItem(addnewRestaurant);
                mv.getOverlays().add(items);
            }

        }
    }
    }
