package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner buildings = findViewById(R.id.buildings);
        String[] spinnerArray = getResources().getStringArray(R.array.buildings);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buildings.setAdapter(spinnerArrayAdapter);
    }

    public void onClickDisplayBuilding(View view){
        Spinner buildings = findViewById(R.id.buildings);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.whoosh);
        Intent intent = new Intent(MainActivity.this, BuildingActivity.class);
        intent.putExtra("building", String.valueOf(buildings.getSelectedItem()));
        startIntent(String.valueOf(buildings.getSelectedItem()));
        mediaPlayer.start();
    }

    private void startIntent(String building){
        Intent intent = new Intent(MainActivity.this, BuildingActivity.class);
        intent.putExtra("building", building);
        startActivity(intent);
    }
}