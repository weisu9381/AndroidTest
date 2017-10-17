package com.suwei.androidtest.date_2017_10.test01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.suwei.androidtest.R;

/**
 * 学习总结：
 *  1. 当你使用 startActivityForResult方法来启动的时候，启动模式设置为singTop或者singTask会失效
 *  2.模式使用singInstance会创建一个新的返回栈，要等其它的栈都没有Activity的时候，该栈的Activity才可以退出。
 *  3. 创建一个类BaseActivity(无需在AndroidManifest.xml中注册)，继承AppCompatActivity,然后其它Activity继承BaseActivity
 *  4. 添加一个类 ActivityCollector:
 *     在 BaseActivity的onCreate方法中使用 ActivityCollector.add(activity);
 *     在 BaseActivity的onDestory方法中使用 ActivityCollector.remove(activity);
 *     如果想要在任何时候退出程序的话，只需执行 ActivityCollector.finishAll();
 *  5. 开启另一个Activity时使用 startActivityForResult(intent, 1);
 *     在打开的Activity中重写 onBackPress():
 *         Intent intent = new Intent();
 *         intent.putExtra("extra_data", "数据");
 *         setResult(RESULT_OK. intent);
 *     在原Activity中重写 onActivityResult(int requestCode, int resultCode, Intent intent); 获得返回数据
 *        switch(requestCode){
 *            case 1:
 *                if(resultCode == Result_OK){
 *                    String returnData = intent.getStringExtra("extra_data");
 *                }
 *        }
 *   6.启动Activiy的最佳方法：假如启动SecondActiviy需要传入两个参数：
 *     在SecondActivity中添加方法:
 *        public static void actionStart(Context context, String data1, String data2){
 *            Intent intent = new Intent(context, SecondActivity.class);
 *            intent.putExtra("param1", data1);
 *            intent.putExtra("param2", data2);
 *            context.startActivity(intent);
 *        }
 *      开启SecondActiviy:
 *        SecondActivity.actionActivity(FirstActivity.this, "data1","data2");
 */

public class FirstActivity extends BaseActivtity {
    private static final String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date201710_test01_first_layout);
        Log.e(TAG, "Task id is "+ getTaskId());
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("extra_return");
                    Toast.makeText(FirstActivity.this, "FirstActivity, extra_return: " + returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "you click Add menu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "you click Remove menu", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
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
