package com.rockscoder.banglasms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SMSActivity extends AppCompatActivity {
    ArrayList<TextSMS> listItems = new ArrayList<>();
    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            newString = extras.getString("ITEM");
            loadData(newString);
        } else {
            sms();
        }


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SMSAdapter adapter = new SMSAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("ITEM", newString);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        loadData(savedInstanceState.getString("ITEM"));
    }

    public void loadData(String data) {
        listItems.clear();
        if(data.equals("ভালোবাসার এসএমএস পর্ব-১"))
        {
            love1();
        }

        if(data.equals("ভালোবাসার এসএমএস পর্ব-২"))
        {
            love2();
        }

        if(data.equals("ভালোবাসার এসএমএস পর্ব-৩"))
        {
            love3();
        }

        if(data.equals("ভালোবাসার এসএমএস পর্ব-৪"))
        {
            love4();
        }


    }

    public void love1() {
        listItems.add(new TextSMS("আমার চোখে জল আর তোমার ঠোটে হাসি,, তারপরও আমি তোমাকেই ভালবাসি..!!"));
    }
    public void love2() {
        listItems.add(new TextSMS("যদি বলো তোমার কথা মনে পড়ে কতবার?? আমি বলব চোখের পাতা নড়ে যতবার.. যদি বলো তোমায় ভালবাসি কত?? আমি বলব আকাশে তারা আছে যত..!!"));
    }

    public void love3() {
        listItems.add(new TextSMS("তুমি রাজি থাকলে প্রেম করবো, কাজী এনে বিয়া করব, রাগ করলে কিস করবো, দূরে গেলে মিস করবো, পাশে থাকলে আদর করবো, আর ভুলে গেলে খুব কষ্ট পাবো...!!"));
    }

    public void love4() {
        listItems.add(new TextSMS("কেউ কেউ লাভ করে ,,,,,,,,,,, আবার কেউ করে ইনজয় ,,,,,,,,,, কেউ খাঁয় ছেকা,,,,,,,,, কেউ হয় একা,,,,,,,,, কেউ বলে জান,,,, কেউ করে বিষ পান.........., কারো মুখা হাসি............ । আবার কারো গলায় ফাঁসি । LOVE NOT FAN, So সাবধান, এখনকার মেয়েরা হয় বেইমান সার্থপর ।।। "));

    }
    public void sms() {
        listItems.add(new TextSMS(""));
    }
}
