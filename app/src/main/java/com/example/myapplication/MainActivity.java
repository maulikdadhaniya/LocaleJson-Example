package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    DetailsListPojo storesListProjo;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.stores_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        storesListProjo = new Gson().fromJson(parseJSONData(), DetailsListPojo.class);
        adapter = new DetailsListAdapter(storesListProjo.getDetailList(), this);



        recyclerView.setAdapter(adapter);

    }

    public String parseJSONData() {
        String JSONString = null;
        JSONObject JSONObject = null;
        try {

            InputStream inputStream = getAssets().open("userDetail.json");

            int sizeOfJSONFile = inputStream.available();

            byte[] bytes = new byte[sizeOfJSONFile];

            inputStream.read(bytes);

            inputStream.close();

            JSONString = new String(bytes, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return JSONString;
    }
}
