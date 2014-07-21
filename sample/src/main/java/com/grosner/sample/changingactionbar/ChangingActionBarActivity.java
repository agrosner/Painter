package com.grosner.sample.changingactionbar;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.grosner.painter.actionbar.ActionBarColorSlider;
import com.grosner.sample.R;


public class ChangingActionBarActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener {

    private ChangingActionBarAdapter mAdapter;

    private ActionBarColorSlider mActionbarColorSlider;

    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changing_action_bar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(mAdapter = new ChangingActionBarAdapter());
        viewPager.setOnPageChangeListener(this);

        mActionbarColorSlider = new ActionBarColorSlider(getSupportActionBar(), mAdapter.getColor(0), mAdapter.getColor(1));
    }


    @Override
    public void onPageScrolled(int position, float slideOffset, int i2) {
        if(mPosition!=position){
            int prevPosition = mPosition;
            mPosition = position;

            int change = ((prevPosition>mPosition) ? -1:1);

            if(change<-1){
                mActionbarColorSlider.setStartColor(getSupportActionBar(), mAdapter.getColor(position-1));
                mActionbarColorSlider.setEndColor(mAdapter.getColor(position));
            } else {
                mActionbarColorSlider.setStartColor(getSupportActionBar(), mAdapter.getColor(position));
                mActionbarColorSlider.setEndColor(mAdapter.getColor(position + 1));
            }
        }
        mActionbarColorSlider.onSlide(slideOffset);
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
