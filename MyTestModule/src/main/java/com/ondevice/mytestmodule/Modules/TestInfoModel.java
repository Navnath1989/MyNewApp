package com.ondevice.mytestmodule.Modules;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.widget.Toast;

import com.ondevice.mytestmodule.Beans.BasicInfoBean;

import java.util.List;

public class TestInfoModel extends ViewModel {

    private String abc = "navanath";
    private MutableLiveData<String> heroList;


    public LiveData<String> getHeroes() {
        //if the list is null

        heroList = new MutableLiveData<String>();
        //heroList.setValue("Nagnath Hadapad" + "Raj");
        heroList.postValue("Name IS");

        //finally we will return the list
        return heroList;
    }

    public LiveData<String> getHeroes1d() {
        //if the list is null

        heroList = new MutableLiveData<String>();
        heroList.setValue("Nagnath Hadapad");
        //heroList.postValue("Name IS");

        //finally we will return the list
        return heroList;
    }

}
