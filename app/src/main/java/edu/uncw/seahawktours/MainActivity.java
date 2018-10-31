package edu.uncw.seahawktours;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner buildings = findViewById(R.id.buildings);
        String[] spinnerArray = getResources().getStringArray(R.array.buildings);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buildings.setAdapter(spinnerArrayAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.home);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onClickDisplayBuilding(View view){
        Spinner buildings = findViewById(R.id.buildings);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.whoosh);
        if(!buildings.getSelectedItem().toString().equals(getString(R.string.default_building))) {
            Intent intent = new Intent(MainActivity.this, BuildingActivity.class);
            intent.putExtra("building", String.valueOf(buildings.getSelectedItem()));
            startIntent(String.valueOf(buildings.getSelectedItem()));
            mediaPlayer.start();
        }
    }

    private void startIntent(String building){
        Intent intent = new Intent(MainActivity.this, BuildingActivity.class);
        intent.putExtra("building", building);
        startActivity(intent);
    }
}