package com.rockscoder.banglasms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {
    ArrayList<TextSMS> listItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        RecyclerView.Adapter adapter = new ItemAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }


    public void item(){

        listItems.add(new TextSMS("ভালোবাসার এসএমএস পর্ব-১"));
        listItems.add(new TextSMS("ভালোবাসার এসএমএস পর্ব-২"));
        listItems.add(new TextSMS("ভালোবাসার এসএমএস পর্ব-৩"));
        listItems.add(new TextSMS("ভালোবাসার এসএমএস পর্ব-৪"));
        listItems.add(new TextSMS("বোকা বানোর এসএমএস পর্ব-১"));
        listItems.add(new TextSMS("বোকা বানোর এসএমএস পর্ব-২"));
        listItems.add(new TextSMS("বোকা বানোর এসএমএস পর্ব-৩"));
        listItems.add(new TextSMS("বোকা বানোর এসএমএস পর্ব-৪"));
        listItems.add(new TextSMS("বাংলা হাসির এসএমএস"));
        listItems.add(new TextSMS("ইসলামিক বাংলা এসএমএস"));
        listItems.add(new TextSMS("মা - বাবার এসএমএস"));
        listItems.add(new TextSMS("উপদেশ মুলক এসএমএস"));
        listItems.add(new TextSMS("বন্ধুত্বের এসএমএস"));
        listItems.add(new TextSMS("কষ্টের এসএমএস"));
    }

    @Override
    public void onItemClick(TextSMS listItem) {
        Log.d("ITEM",listItem.getDesc());
        Intent intent = new Intent(MainActivity.this,SMSActivity.class);
        intent.putExtra("ITEM",listItem.getDesc());
        startActivity(intent);
    }
}
