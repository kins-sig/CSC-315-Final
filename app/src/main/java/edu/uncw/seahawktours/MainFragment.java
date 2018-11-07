package edu.uncw.seahawktours;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Objects;


public class MainFragment extends Fragment {

    Button btnGo;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Spinner buildings = v.findViewById(R.id.buildings);
        ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()).getBaseContext(),
                R.array.buildings, android.R.layout.simple_spinner_item);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buildings.setAdapter(spinnerArrayAdapter);
        btnGo = v.findViewById(R.id.go_button);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDisplayBuilding();
            }
        });
        return v;
    }

    public void onClickDisplayBuilding() {
        Spinner buildings = Objects.requireNonNull(getActivity()).findViewById(R.id.buildings);
        final MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.whoosh);
        if (!buildings.getSelectedItem().toString().equals(getString(R.string.default_building))) {
            Intent intent = new Intent(getActivity(), BuildingActivity.class);
            intent.putExtra("building", String.valueOf(buildings.getSelectedItem()));
            startActivity(intent);
            mediaPlayer.start();
        }
    }
}