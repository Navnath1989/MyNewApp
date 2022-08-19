package com.ondevice.mynewapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ondevice.mynewapp.Adapters.BasicInfoAdapter;
import com.ondevice.mytestmodule.Beans.BasicInfoBean;
import com.ondevice.mytestmodule.Modules.HeroViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvBasicInfo;
    List<BasicInfoBean> BasicInfoList;
    BasicInfoAdapter basicInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBasicInfo = findViewById(R.id.rvBasicInfo);
        rvBasicInfo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        HeroViewModel model = ViewModelProviders.of(this).get(HeroViewModel.class);
        model.getHeroes().observe(this, new Observer<List<BasicInfoBean>>() {
            @Override
            public void onChanged(@Nullable List<BasicInfoBean> heroList) {
                basicInfoAdapter = new BasicInfoAdapter(MainActivity.this, heroList);
                rvBasicInfo.setAdapter(basicInfoAdapter);
            }
        });


    }
}