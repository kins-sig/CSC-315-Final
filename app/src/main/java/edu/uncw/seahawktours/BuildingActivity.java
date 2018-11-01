package edu.uncw.seahawktours;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildingActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);
        TextView buildingName = findViewById(R.id.building_name);
        ImageView buildingImage = findViewById(R.id.building_image);
        TextView buildingCaption = findViewById(R.id.building_caption);
        TextView buildingDescription = findViewById(R.id.building_description);
        TextView link = findViewById(R.id.building_url);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String url = null;
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String message = bundle.getString("building");
        assert message != null;
        if (message.equals(getString(R.string.cis_building))){
            buildingName.setText(R.string.cis_building);
            buildingImage.setImageResource(R.drawable.cis_building);
            buildingCaption.setText(R.string.cis_caption);
            buildingDescription.setText(R.string.cis_description);
            url = getString(R.string.cis_url);
        }
        else if (message.equals(getString(R.string.trask_building))){
            buildingName.setText(R.string.trask_building);
            buildingImage.setImageResource(R.drawable.trask_building);
            buildingCaption.setText(R.string.trask_caption);
            buildingDescription.setText(R.string.trask_description);
            url = getString(R.string.trask_url);
        }
        else if (message.equals(getString(R.string.bear_building))){
            buildingName.setText(R.string.bear_building);
            buildingImage.setImageResource(R.drawable.bear_building);
            buildingCaption.setText(R.string.bear_caption);
            buildingDescription.setText(R.string.bear_description);
            url = getString(R.string.bear_url);
        }
        else if (message.equals(getString(R.string.alderman_building))) {
            buildingName.setText(R.string.alderman_building);
            buildingImage.setImageResource(R.drawable.alderman_building);
            buildingCaption.setText(R.string.alderman_caption);
            buildingDescription.setText(R.string.alderman_description);
            url = getString(R.string.alderman_url);
        }
        else if (message.equals(getString(R.string.belk_building))) {
            buildingName.setText(R.string.belk_building);
            buildingImage.setImageResource(R.drawable.belk_building);
            buildingCaption.setText(R.string.belk_caption);
            buildingDescription.setText(R.string.belk_description);
            url = getString(R.string.belk_url);
        }

        final String finalUrl = url;
        SpannableString ss = new SpannableString(getString(R.string.learn_more_here));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View textView) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(finalUrl));
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_home:
                startActivity(new Intent(BuildingActivity.this, MainActivity.class));
                return true;
            case R.id.menu_about:
                startActivity(new Intent(BuildingActivity.this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}