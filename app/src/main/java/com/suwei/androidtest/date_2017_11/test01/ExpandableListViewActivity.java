package com.suwei.androidtest.date_2017_11.test01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ExpandableListViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_day201711_test01_expandable_listview);
        setContentView(new BitmapView(this));
    }
}
