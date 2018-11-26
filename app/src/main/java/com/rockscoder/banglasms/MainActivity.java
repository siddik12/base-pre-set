package com.rockscoder.banglasms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {
    ArrayList<ListItem> listItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        RecyclerView.Adapter adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }


    public void item(){

        listItems.add(new ListItem("ভালোবাসার এসএমএস পর্ব-১"));
        listItems.add(new ListItem("ভালোবাসার এসএমএস পর্ব-২"));
        listItems.add(new ListItem("ভালোবাসার এসএমএস পর্ব-৩"));
        listItems.add(new ListItem("ভালোবাসার এসএমএস পর্ব-৪"));
        listItems.add(new ListItem("বোকা বানোর এসএমএস পর্ব-১"));
        listItems.add(new ListItem("বোকা বানোর এসএমএস পর্ব-২"));
        listItems.add(new ListItem("বোকা বানোর এসএমএস পর্ব-৩"));
        listItems.add(new ListItem("বোকা বানোর এসএমএস পর্ব-৪"));
        listItems.add(new ListItem("বাংলা হাসির এসএমএস"));
        listItems.add(new ListItem("ইসলামিক বাংলা এসএমএস"));
        listItems.add(new ListItem("মা - বাবার এসএমএস"));
        listItems.add(new ListItem("উপদেশ মুলক এসএমএস"));
        listItems.add(new ListItem("বন্ধুত্বের এসএমএস"));
        listItems.add(new ListItem("কষ্টের এসএমএস"));
    }

    @Override
    public void onItemClick(ListItem listItem) {
        Log.d("ITEM",listItem.getDesc());
        Intent intent = new Intent(MainActivity.this,SMSActivity.class);
        intent.putExtra("ITEM",listItem.getDesc());
        startActivity(intent);
    }
}
