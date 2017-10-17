package com.suwei.androidtest.date_2017_10.test01;

import android.os.Bundle;
import android.util.Log;

import com.suwei.androidtest.R;

public class ThirdActivity extends BaseActivtity {
    private static final String TAG = "ThirdActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date201710_test02_third);
        Log.e(TAG, "Task id is "+ getTaskId());
    }
}
