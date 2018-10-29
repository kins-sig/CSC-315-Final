package edu.uncw.seahawktours;

import android.content.res.Resources;

public class Building {
    private String buildingName;
    private int buildingImageResourceId;
    private String buildingCaption;
    private String buildingDescription;
    Resources resources;

    final Building[] buildings = {
            new Building(resources.getString(R.string.alderman_building), R.drawable.alderman_building, resources.getString(R.string.alderman_caption), resources.getString(R.string.alderman_description)),
            new Building(resources.getString(R.string.bear_building), R.drawable.bear_building, resources.getString(R.string.bear_caption), resources.getString(R.string.bear_description)),
            new Building(resources.getString(R.string.belk_building), R.drawable.belk_building, resources.getString(R.string.belk_caption), resources.getString(R.string.belk_description)),
            new Building(resources.getString(R.string.cis_building), R.drawable.cis_building, resources.getString(R.string.cis_caption), resources.getString(R.string.cis_description)),
            new Building(resources.getString(R.string.trask_building), R.drawable.trask_building, resources.getString(R.string.trask_caption), resources.getString(R.string.trask_description))
    };

    private Building(String buildingName, int buildingImageResourceId, String buildingCaption, String buildingDescription){
        this.buildingName = buildingName;
        this.buildingImageResourceId = buildingImageResourceId;
        this.buildingCaption = buildingCaption;
        this.buildingDescription = buildingDescription;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getBuildingImageResourceId() {
        return buildingImageResourceId;
    }

    public String getBuildingCaption() {
        return buildingCaption;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }
}
