package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Spinner buildings = findViewById(R.id.buildings);


    public void onClickDisplayBuilding(View view) {
        //Get a reference to the Spinner
        Spinner buildings = findViewById(R.id.buildings);
        //Get the selected building in the Spinner
        String selectedBuilding = String.valueOf(buildings.getSelectedItem());
        String building;
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.whoosh);








        //        if (selectedBuilding.equals(getString(R.string.cis_building))){
//            building = getString(R.string.cis_building);
//            startIntent(building);
//            mediaPlayer.start();
//        }
//        else if (selectedBuilding.equals(getString(R.string.trask_building))){
//            building = getString(R.string.trask_building);
//            startIntent(building);
//            mediaPlayer.start();
//        }
//        else if (selectedBuilding.equals(getString(R.string.bear_building))){
//            building = getString(R.string.bear_building);
//            startIntent(building);
//            mediaPlayer.start();
//        }
//        else if (selectedBuilding.equals(getString(R.string.alderman_building))){
//            building = getString(R.string.alderman_building);
//            startIntent(building);
//            mediaPlayer.start();
//        }
//        else if (selectedBuilding.equals(getString(R.string.belk_building))){
//            building = getString(R.string.belk_building);
//            startIntent(building);
//            mediaPlayer.start();
//        }
    }
    private void startIntent(String building){
        Intent intent = new Intent(MainActivity.this, BuildingActivity.class);
        intent.putExtra("building", building);
        startActivity(intent);
    }
}