package edu.uncw.seahawktours;


import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the main data access object
        boxStore = MyObjectBox.builder().androidContext(App.this).build();

        // Get the wrapper (Box) for the Book table that lets us store Book objects
        Box<Building> buildingBox = boxStore.boxFor(Building.class);

        // Initialize with some data
        if (buildingBox.count() == 0) {
            List<Building> initialBuildings = new ArrayList<>();
            initialBuildings.add(new Building(getString(R.string.alderman_building), "alderman_building", getString(R.string.alderman_caption), getString(R.string.alderman_description), getString(R.string.alderman_url), 34.2269,  77.8770));
            initialBuildings.add(new Building(getString(R.string.bear_building), "bear_building", getString(R.string.bear_caption), getString(R.string.bear_description), getString(R.string.bear_url), 34.2285, 77.8728));
            initialBuildings.add(new Building(getString(R.string.belk_building), "belk_building", getString(R.string.belk_caption), getString(R.string.belk_description), getString(R.string.belk_url), 34.2220, 77.8714));
            initialBuildings.add(new Building(getString(R.string.cis_building), "cis_building", getString(R.string.cis_caption), getString(R.string.cis_description), getString(R.string.cis_url), 34.2262, 77.8718));
            initialBuildings.add(new Building(getString(R.string.trask_building), "trask_building", getString(R.string.trask_caption), getString(R.string.trask_description), getString(R.string.trask_url), 34.2250, 77.8783));

            // ObjectBox is smart enough to handle CRUD on Collections of entities
            buildingBox.put(initialBuildings);
        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}