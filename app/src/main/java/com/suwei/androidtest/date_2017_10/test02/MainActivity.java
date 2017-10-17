package com.suwei.androidtest.date_2017_10.test02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.suwei.androidtest.R;

/**
 * 学习总结：
 *   1.如果DialogActivity是继承Activity,那么在AndroidManifest.xml中设置theme为@android:style/Theme.Dialog是可以的，
 *     如果是继承AppcompatActivity，那么就要使用 @style/Theme.Appcomat.Dialog
 *   2. 首次进入 MainActivity:
 *       MainActivity ---- onCreate
 *       MainActivity ----- onStart
 *       MainActivity ----- onResume
 *     开启DialogActivity 对话框:
 *       MainActivity ---- onPause
 *       DialogActivity ---- onCreate
 *       DialogActivity ---- onStart
 *       DialogActivity --- onResume
 *     点击返回到MainActivity:
 *       DialgoActivity ---- onPause
 *       MainActivity ---- onResume
 *       DialogActivity ---- onStop
 *       DialogActivity ---- onDestory
 *      开启 NormalActivity:
 *        MainActivity --- onPause
 *        NormalActivity  --- onCreate
 *        NormalActivity --- onStart
 *        NormalActivity --- onResume
 *        MainActivity ---- onStop
 *      返回到MainActivity:
 *        NormalActivity --- onPause
 *        MainActivity --- onRestart  （此时从onStop先变成onRestart在onStart)
 *        MainActivity --- onStart
 *        MainActivity --- onResume
 *        NormalActivity --- onStop
 *        NormalActivity --- onDestory
 *      退出MainActivity:
 *        MainActivity ---- onPause
 *        MainActivity --- onStop
 *        MainActivity --- onDestory
 *     3.此时MainActivity由onCreate --- onStart ---- onResume
 *        点击home键： onPause --- onStop
 *        返回到程序： onRestart -- onStart --- onResume
 *     4.假如 MainActivity处于onStop状态时由于系统内存不足被回收了，再返回时就执行onCreate重新创建，会导致临时数据丢失。
 *      故使用 onSaveInstanceState(Bundle outState)方法来保存:
 *           public void onSaveInstanceState(Bundle outState){
 *                 super.onSaveInstanceState(outState);
 *                 String tempData = "something you just typed";
 *                 outState.putString("data_key", tempData);
 *           }
 *      在onCreate中先判断if(saveInstanceState != null){ String tempData = saveInstanceState.getString("data_key")}
 *
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = com.suwei.androidtest.MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date201710_test02_main);
        if(savedInstanceState != null){
            String tempData = savedInstanceState.getString("data_key");
            Log.e(TAG, tempData);
        }

        Log.e(TAG, "onCreate");
        findViewById(R.id.date_2017_10_test02_start_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.date_2017_10_test02_start_noraml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "something you just typed";
        outState.putString("data_key", tempData);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestory");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }
}
