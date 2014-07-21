package com.grosner.sample.colorfulgrid;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import com.grosner.sample.R;

/**
 * Created by: andrewgrosner
 * Date: 7/21/14.
 * Contributors: {}
 * Description:
 */
public class ColorfulGridActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorful_grid);


        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ColorfulGridAdapter());

        Drawable drawable = getResources().getDrawable(R.drawable.ic_action_sun);
        int numThatFit = (int) ((float)getResources().getDisplayMetrics().widthPixels/(float)drawable.getIntrinsicWidth());
        gridView.setNumColumns(numThatFit);
    }
}
