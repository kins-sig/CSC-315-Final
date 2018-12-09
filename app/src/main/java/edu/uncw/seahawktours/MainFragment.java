package edu.uncw.seahawktours;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import io.objectbox.Box;
import java.util.List;
import edu.uncw.seahawktours.CaptionedImagesAdapter.Listener;



public class MainFragment extends Fragment implements CaptionedImagesAdapter.Listener{

    Box<Building> buildingBox;
    List<Building> buildingList;
    private Listener listener;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    interface Listener {
        void onClick(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView buildingRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_main, container, false);

        buildingBox = ((App) getActivity().getApplication()).getBoxStore().boxFor(Building.class);
        buildingList = buildingBox.getAll();

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(buildingList,getContext());
        buildingRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        buildingRecycler.setLayoutManager(layoutManager);

        adapter.setListener(this);

        return buildingRecycler;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        this.listener = (Listener)context;
        super.onAttach(context);
    }

    @Override
    public void onClick(int position) {
        listener.onClick(position);
    }


}