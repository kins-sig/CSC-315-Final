package edu.uncw.seahawktours;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BuildingFragment extends Fragment {
    public static String url = null;


    public BuildingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_building, container, false);
        TextView buildingName = v.findViewById(R.id.building_name);
        ImageView buildingImage = v.findViewById(R.id.building_image);
        TextView buildingCaption = v.findViewById(R.id.building_caption);
        TextView buildingDescription = v.findViewById(R.id.building_description);
        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            assert bundle != null;
            String message = bundle.getString("building");
            assert message != null;
            if (message.equals(getString(R.string.cis_building))) {
                buildingName.setText(R.string.cis_building);
                buildingImage.setImageResource(R.drawable.cis_building);
                buildingCaption.setText(R.string.cis_caption);
                buildingDescription.setText(R.string.cis_description);
                setUrl(getString(R.string.cis_url));

            } else if (message.equals(getString(R.string.trask_building))) {
                buildingName.setText(R.string.trask_building);
                buildingImage.setImageResource(R.drawable.trask_building);
                buildingCaption.setText(R.string.trask_caption);
                buildingDescription.setText(R.string.trask_description);
                setUrl(getString(R.string.trask_url));
            } else if (message.equals(getString(R.string.bear_building))) {
                buildingName.setText(R.string.bear_building);
                buildingImage.setImageResource(R.drawable.bear_building);
                buildingCaption.setText(R.string.bear_caption);
                buildingDescription.setText(R.string.bear_description);
                setUrl(getString(R.string.bear_url));
            } else if (message.equals(getString(R.string.alderman_building))) {
                buildingName.setText(R.string.alderman_building);
                buildingImage.setImageResource(R.drawable.alderman_building);
                buildingCaption.setText(R.string.alderman_caption);
                buildingDescription.setText(R.string.alderman_description);
                setUrl(getString(R.string.alderman_url));
            } else if (message.equals(getString(R.string.belk_building))) {
                buildingName.setText(R.string.belk_building);
                buildingImage.setImageResource(R.drawable.belk_building);
                buildingCaption.setText(R.string.belk_caption);
                buildingDescription.setText(R.string.belk_description);
                setUrl(getString(R.string.alderman_url));
            }

            TextView link = v.findViewById(R.id.building_url);
            SpannableString ss = new SpannableString(getString(R.string.learn_more_here));
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(@NonNull View textView) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }

                @Override
                public void updateDrawState(@NonNull TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    ds.setColor(getResources().getColor(R.color.uncw_yellow));
                }
            };
            ss.setSpan(clickableSpan, 21, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            link.setText(ss);
            link.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return v;
    }

    public void setUrl(String url) {
        this.url = url;

    }
}