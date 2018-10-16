package edu.uncw.seahawktours;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildingActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);
        TextView buildingName = findViewById(R.id.building_name);
        ImageView buildingImage = findViewById(R.id.building_image);
        TextView buildingCaption = findViewById(R.id.building_caption);
        TextView buildingDescription = findViewById(R.id.building_description);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String message = bundle.getString("building");
        assert message != null;
        if (message.equals(getString(R.string.cis_building))){
            buildingName.setText(R.string.cis_building);
            buildingImage.setImageResource(R.drawable.cis_building);
            buildingCaption.setText(R.string.cis_caption);
            buildingDescription.setText(R.string.cis_description);
        }
        else if (message.equals(getString(R.string.trask_building))){
            buildingName.setText(R.string.trask_building);
            buildingImage.setImageResource(R.drawable.trask_building);
            buildingCaption.setText(R.string.trask_caption);
            buildingDescription.setText(R.string.trask_description);
        }
        else if (message.equals(getString(R.string.bear_building))){
            buildingName.setText(R.string.bear_building);
            buildingImage.setImageResource(R.drawable.bear_building);
            buildingCaption.setText(R.string.bear_caption);
            buildingDescription.setText(R.string.bear_description);
        }
    }

    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

    }
}