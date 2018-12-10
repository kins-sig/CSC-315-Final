package edu.uncw.seahawktours;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.Snackbar;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import io.objectbox.Box;


public class MainActivity extends AppCompatActivity implements MainFragment.Listener {

    private FusedLocationProviderClient mFusedLocationClient;
    private int MY_PERMISSIONS_REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(false);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(int position) {
        Intent intent = new Intent(this, BuildingActivity.class);
        intent.putExtra("EXTRA_BUILDING_ID", position);
        startActivity(intent);
    }

    public void recordClick(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "Nearest building...", Toast.LENGTH_SHORT).show();
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double latitude = location.getLatitude();
                                double longitude = location.getLongitude();
                                int position = findNearestBuilding(latitude, longitude);
                                Intent intent = new Intent(getApplicationContext(), BuildingActivity.class);
                                intent.putExtra("EXTRA_BUILDING_ID", position);
                                startActivity(intent);

                            }
                        }
                    });


        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Cannot find nearest building until you grant permission!", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);

        }
    }

    public int findNearestBuilding(double latitude, double longitude) {
        Box<Building> buildingBox = ((App) getApplication()).getBoxStore().boxFor(Building.class);
        List<Building> buildingList = buildingBox.getAll();
        int position=0;
        double minDistance = 999999;
        for (int i = 0; i < buildingList.size(); i++) {
            double buildingLat = buildingList.get(i).getLatitude();
            double buildingLong = buildingList.get(i).getLongitude();
            double distance = Math.sqrt((latitude - buildingLat) * (latitude - buildingLat) + (longitude - buildingLong) * (longitude - buildingLong));

            if (Double.compare(distance,minDistance)<0) {
                minDistance = distance;
                position = i;
            }
        }

        return position;

    }

    public void onClickFindLocation(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double latitude = location.getLatitude();
                                double longitude = location.getLongitude();
                                final Snackbar snackbar = Snackbar.make(findViewById(R.id.top_layout), "Current location: " + latitude +" " + longitude, Snackbar.LENGTH_LONG);

                                Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                                TextView textView = layout.findViewById(android.support.design.R.id.snackbar_text);
                                textView.setTextColor(Color.WHITE);
                                layout.setBackgroundColor(getResources().getColor(R.color.color_primary_dark));

                                snackbar.setActionTextColor(getResources().getColor(R.color.color_primary));
                                snackbar.setAction("Okay", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        snackbar.dismiss();
                                    }
                                });
                                snackbar.show();
                            }
                        }
                    });

        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Cannot detect location until you grant permission!", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);

        }
    }
}