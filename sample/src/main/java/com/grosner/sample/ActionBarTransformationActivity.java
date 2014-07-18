package com.grosner.sample;

import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.grosner.painter.AlphaSlider;
import com.grosner.painter.ColorSlider;
import com.grosner.painter.IconPainter;
import com.grosner.sample.R;

public class ActionBarTransformationActivity extends ActionBarActivity implements DrawerLayout.DrawerListener {

    private ColorSlider mColorSlider;

    private AlphaSlider mAlphaSlider;

    private MenuItem mIcon1, mIcon2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_transformation);

        mColorSlider = new ColorSlider(Color.BLACK, Color.WHITE).with(new IconPainter());

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerLayout.setDrawerListener(this);

        mAlphaSlider = new AlphaSlider(false);
        mAlphaSlider.onSlide(0, getSupportActionBar());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        mIcon1 = menu.add(0, R.id.icon1, 0, "").setIcon(getResources().getDrawable(R.drawable.ic_action_sun));
        MenuItemCompat.setShowAsAction(mIcon1, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);

        mIcon2 = menu.add(0, R.id.icon2, 0, "").setIcon(getResources().getDrawable(R.drawable.ic_action_add));
        MenuItemCompat.setShowAsAction(mIcon2, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public void onDrawerSlide(View view, float v) {
        mColorSlider.onSlide(v, mIcon1, mIcon2);
        mAlphaSlider.onSlide(v, getActionBar());
    }

    @Override
    public void onDrawerOpened(View view) {

    }

    @Override
    public void onDrawerClosed(View view) {

    }

    @Override
    public void onDrawerStateChanged(int i) {

    }
}
