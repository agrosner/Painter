package com.grosner.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.grosner.painter.BackgroundPainter;
import com.grosner.painter.IconPainter;
import com.larswerkman.holocolorpicker.ColorPicker;

public class PaletteActivity extends ActionBarActivity implements ColorPicker.OnColorChangedListener {

    private ImageView mImage;

    private View background;

    private IconPainter mIconPainter;

    private BackgroundPainter mBackgroundPainter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_palette);

        ColorPicker picker = ((ColorPicker) findViewById(R.id.picker));
        picker.setOnColorChangedListener(this);

        mImage = (ImageView) findViewById(R.id.palette);
        mIconPainter = new IconPainter(picker.getColor());
        mIconPainter.paint(mImage);

        background = findViewById(R.id.background);
        mBackgroundPainter = new BackgroundPainter(picker.getColor());
        mBackgroundPainter.paint(background);
    }


    @Override
    public void onColorChanged(int i) {
        mIconPainter.paintColor(i, mImage);
        mBackgroundPainter.paintColor(i, background, getSupportActionBar());
    }
}
