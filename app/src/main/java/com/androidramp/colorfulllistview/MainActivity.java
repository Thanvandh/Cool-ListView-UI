package com.androidramp.colorfulllistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<StockList> actorsList;
    StockListAdapter adapter;

    String[] title = new String[]{
            "People",
            "Calls",
            "Music",
            "Apps",
            "Share",
            "Alarm",
            "Add More",
    };

    int[] imageId = new int[]{
            R.drawable.icon_people,
            R.drawable.icon_calls,
            R.drawable.icon_musiq,
            R.drawable.icon_apps,
            R.drawable.icon_share,
            R.drawable.icon_alarm,
            R.drawable.icon_add,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // custom list
        ListView listView = (ListView) findViewById(R.id.stock_list);
        actorsList = new ArrayList<>();
        adapter = new StockListAdapter(getApplicationContext(), R.layout.list_item, actorsList);

        listView.setDividerHeight(1);
        listView.setAdapter(adapter);

        for (int i = 0; i < title.length; i++) {

            StockList adpacksList = new StockList();
            adpacksList.setImageId(imageId[i]);
            adpacksList.setName(title[i]);
            actorsList.add(adpacksList);

        }
        adapter.notifyDataSetChanged();
    }

}

