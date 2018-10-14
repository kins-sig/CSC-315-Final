package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDisplayBuilding(View view) {
        final Resources resources = getResources();
        //Get a reference to the Spinner
        Spinner buildings = findViewById(R.id.buildings);
        //Get the selected building in the Spinner
        String selectedBuilding = String.valueOf(buildings.getSelectedItem());
        String title = null;
        if (selectedBuilding.equals(R.string.cis_building)){
            title = resources.getString(R.string.cis_building);
        }
        else if (selectedBuilding.equals(R.string.trask_coliseum_building)){
            title = resources.getString(R.string.trask_coliseum_building);
        }
        else if (selectedBuilding.equals(R.string.bear_building)){
            title = resources.getString(R.string.bear_building);
        }
        Intent intent = new Intent(MainActivity.this, BuildingActivity.class);
        intent.putExtra("message", title);
        startActivity(intent);
    }
}
