package edu.uncw.seahawktours;

import android.content.res.Resources;

public class Building {
    private String name;
    private int imageResourceId;
    private String caption;
    private String description;
    private String url;
    private static Resources res;

    //drinks is an array of Drinks
    public static final Building[] buildings = {
            new Building(res.getString(R.string.alderman_building), R.drawable.alderman_building, res.getString(R.string.alderman_caption), res.getString(R.string.alderman_description), res.getString(R.string.alderman_url)),
            new Building(res.getString(R.string.bear_building), R.drawable.bear_building, res.getString(R.string.bear_caption), res.getString(R.string.bear_description), res.getString(R.string.bear_url)),
            new Building(res.getString(R.string.belk_building), R.drawable.belk_building, res.getString(R.string.belk_caption), res.getString(R.string.belk_description), res.getString(R.string.belk_url)),
            new Building(res.getString(R.string.cis_building), R.drawable.cis_building, res.getString(R.string.cis_caption), res.getString(R.string.cis_description), res.getString(R.string.cis_url)),
            new Building(res.getString(R.string.trask_building), R.drawable.trask_building, res.getString(R.string.trask_caption), res.getString(R.string.trask_description), res.getString(R.string.trask_url))
    };

    private Building(String name, int imageResourceId, String caption, String description, String url) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.caption = caption;
        this.description = description;
        this.url = url;
    }

    public static void setRes(Resources res) {
        Building.res = res;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}