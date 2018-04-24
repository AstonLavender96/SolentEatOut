package com.example.a2lavea02.solenteatout;

/**
 * Created by 2lavea02 on 23/04/2018.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.MenuInflater;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class addrestaurant extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_restaurant);

    }
    public void onClick(View view){


        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        EditText restname = (EditText)findViewById(R.id.sl1);
        EditText restaddress = (EditText)findViewById(R.id.sl2);
        EditText restcuisine = (EditText)findViewById(R.id.sl3);
        EditText restrating = (EditText)findViewById(R.id.sl4);

        String stringrestname = restname.getText().toString();
        String stringrestadd = restaddress.getText().toString();
        String stringcuisine = restcuisine.getText().toString();
        String stringrating = restrating.getText().toString();

        bundle.putString("com.example.a2lavea02.solenteatout.RestName", stringrestname);
        bundle.putString("com.example.a2lavea02.solenteatout.RestAdd", stringrestadd);
        bundle.putString("com.example.a2lavea02.solenteatout.RestCuisine", stringcuisine);
        bundle.putString("com.example.a2lavea02.solenteatout.RestRating", stringrating);
        // create an onactivityresult within the main activity.
    }


}
