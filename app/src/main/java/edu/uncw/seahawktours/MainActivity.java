package edu.uncw.seahawktours;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFindBuilding(View view){
        //Get a reference to the Spinner
        Spinner buildings = findViewById(R.id.buildings);
        //Get the selected item in the Spinner
        String building = String.valueOf(buildings.getSelectedItem());
    }
}
