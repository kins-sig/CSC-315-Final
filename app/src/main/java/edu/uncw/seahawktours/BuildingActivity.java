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
            String[] buildingInfo = getResources().getStringArray(R.array.cis_building);
            buildingName.setText(buildingInfo[0]);
            buildingCaption.setText(buildingInfo[1]);
            buildingDescription.setText(buildingInfo[2]);
            buildingImage.setImageResource(R.drawable.cis_building);
        }
        else if (message.equals(getString(R.string.trask_building))){
            String[] buildingInfo = getResources().getStringArray(R.array.trask_building);
            buildingName.setText(buildingInfo[0]);
            buildingCaption.setText(buildingInfo[1]);
            buildingDescription.setText(buildingInfo[2]);
            buildingImage.setImageResource(R.drawable.trask_building);
        }
        else if (message.equals(getString(R.string.bear_building))){
            String[] buildingInfo = getResources().getStringArray(R.array.bear_building);
            buildingName.setText(buildingInfo[0]);
            buildingCaption.setText(buildingInfo[1]);
            buildingDescription.setText(buildingInfo[2]);
            buildingImage.setImageResource(R.drawable.bear_building);
        }
    }

}