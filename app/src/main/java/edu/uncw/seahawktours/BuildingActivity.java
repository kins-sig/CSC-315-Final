package edu.uncw.seahawktours;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
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

import java.util.List;

import io.objectbox.Box;

public class BuildingActivity extends AppCompatActivity {

    public static final String EXTRA_BUILDING_ID="buildingId";
    public static String url = null;
    Box<Building> buildingBox;
    List<Building> buildingList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int buildingId = intent.getIntExtra("EXTRA_BUILDING_ID",-1);

        buildingBox = ((App) getApplication()).getBoxStore().boxFor(Building.class);
        buildingList = buildingBox.getAll();

        String buildingName=buildingList.get(buildingId).getName();
        TextView textView = findViewById(R.id.building_name);
        textView.setText(buildingName);

        TextView caption = findViewById(R.id.building_caption);
        caption.setText(buildingList.get(buildingId).getCaption());

        int buildingImage = getResources().getIdentifier(buildingList.get(buildingId).getImageResourceString(), "drawable",getPackageName());
        ImageView imageView = findViewById(R.id.building_image);
        imageView.setImageResource(buildingImage);


        TextView body = findViewById(R.id.building_description);
        body.setText(buildingList.get(buildingId).getDescription());


        TextView link = findViewById(R.id.building_url);
        link.setText(buildingList.get(buildingId).getUrl());
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

    private ShareActionProvider shareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        TextView buildingName = findViewById(R.id.building_name);
        getMenuInflater().inflate(R.menu.toolbar_menu_share, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent(getText(R.string.check_out_building) + buildingName.getText().toString() + "\n\n" + url);
        return true;
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(BuildingActivity.this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}