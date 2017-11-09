package com.suwei.androidtest.date_2017_11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.suwei.androidtest.R;
import com.suwei.androidtest.date_2017_11.test01.ExpandableListViewActivity;

public class Date201711Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date201711);
        findViewById(R.id.date_2017_11_test01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Date201711Activity.this, ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
