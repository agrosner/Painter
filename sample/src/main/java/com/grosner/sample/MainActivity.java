package com.grosner.sample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.grosner.sample.changingactionbar.ChangingActionBarActivity;
import com.grosner.sample.colorfulgrid.ColorfulGridActivity;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{
                "Palette", "ActionBar Transformation Example", "Colorful Grid!", "Changing Color ActionBar Activity"
        }));
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0){
            startActivity(new Intent(this, PaletteActivity.class));
        } else if(position==1){
            startActivity(new Intent(this, ActionBarTransformationActivity.class));
        } else if(position==2){
            startActivity(new Intent(this, ColorfulGridActivity.class));
        } else if(position==3){
            startActivity(new Intent(this, ChangingActionBarActivity.class));
        }
    }
}
