package edu.uncw.seahawktours;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class BuildingDetailFragment extends Fragment {

    public BuildingDetailFragment(){
    }


    private int buildingId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_building_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {

            Building building = Building.buildings[buildingId];

            TextView building_name = view.findViewById(R.id.building_name);
            building_name.setText(building.getName());

            ImageView building_image = view.findViewById(R.id.building_image);
            building_image.setImageResource(building.getImageResourceId());

            TextView building_caption = view.findViewById(R.id.building_caption);
            building_caption.setText(building.getCaption());

            TextView building_description = view.findViewById(R.id.building_description);
            building_description.setText(building.getDescription());

            TextView building_url = view.findViewById(R.id.building_url);
            building_url.setText(building.getUrl());

        }
    }

    public void setBuilding(int id){
        this.buildingId = id;
    }

}
