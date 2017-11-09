package com.suwei.androidtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.suwei.androidtest.date_2017_10.Date201710Activity;
import com.suwei.androidtest.date_2017_11.Date201711Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.date_2017_10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Date201710Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.date_2017_11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Date201711Activity.class);
                startActivity(intent);
            }
        });
    }
}
