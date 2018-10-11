package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button bGoButton = findViewById(R.id.go_button);

        bGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get a reference to the Spinner
                Spinner buildings = findViewById(R.id.buildings);
                //Get the selected building in the Spinner
                String selectedBuilding = String.valueOf(buildings.getSelectedItem());
                Intent registerIntent = new Intent(MainActivity.this, BuildingActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
    }


}
