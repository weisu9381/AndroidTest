package com.suwei.androidtest.date_2017_11.test01;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.suwei.androidtest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandableListViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day201711_test01_expandable_listview);

        ListView listView = (ListView) findViewById(R.id.list_view);



        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("image",R.drawable.p511483);
        map.put("title","用户1");
        map.put("content","擦擦擦擦擦的CAD擦擦东昌府区额二次启动初期的权威的需求稳定性");
        list.add(map);

        map = new HashMap<>();
        map.put("image",R.drawable.p511487);
        map.put("title","用户2");
        map.put("content","擦擦擦擦擦的CAD擦擦东昌府区额二次启动初期的权威的需求稳定性");
        list.add(map);

        map = new HashMap<>();
        map.put("image",R.drawable.p511468);
        map.put("title","用户3");
        map.put("content","擦擦擦擦擦的CAD擦擦东昌府区额二次启动初期的权威的需求稳定性");
        list.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.listview_layout,
                new String[]{"image","title","content"},
                new int[]{R.id.image, R.id.title, R.id.content});

        listView.setAdapter(adapter);

    }

    ListAdapter adapter = new ListAdapter() {
        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    };
}
