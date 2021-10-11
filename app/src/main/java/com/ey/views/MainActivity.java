package com.ey.views;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.ey.R;
import com.ey.adapter.CityListAdapter;
import com.ey.service.CityService;

public class MainActivity extends Activity {
    private RecyclerView cityRecyclerView;
    private CityListAdapter cityListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        init();
        displayCityList();
    }
    void init(){
        cityRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
    void displayCityList() {
        cityListAdapter = new CityListAdapter(this, CityService.fetchCityList());
        cityRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        cityRecyclerView.setLayoutManager(mLayoutManager);
        cityRecyclerView.setItemAnimator(new DefaultItemAnimator());
        cityRecyclerView.setAdapter(cityListAdapter);
    }
}