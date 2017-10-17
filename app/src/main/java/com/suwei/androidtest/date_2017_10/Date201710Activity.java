package com.suwei.androidtest.date_2017_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.suwei.androidtest.R;
import com.suwei.androidtest.date_2017_10.test01.FirstActivity;
import com.suwei.androidtest.date_2017_10.test02.MainActivity;

public class Date201710Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date201710);
        findViewById(R.id.date_2017_10_test01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Date201710Activity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.date_2017_10_test02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Date201710Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
