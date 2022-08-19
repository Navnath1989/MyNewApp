package com.ondevice.mytestmodule.Modules;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ondevice.mytestmodule.Beans.BasicInfoBean;
import com.ondevice.mytestmodule.Config.Api;
import com.ondevice.mytestmodule.Config.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroViewModel extends ViewModel {

    private MutableLiveData<List<BasicInfoBean>> heroList;

    private MutableLiveData<String> NameToastInfo;
    private MutableLiveData<String> NameToastNm;

    //we will call this method to get the data
    public LiveData<List<BasicInfoBean>> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<BasicInfoBean>>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return heroList;
    }

    public LiveData<String> getToastInfo() {
        //if the list is null

        NameToastInfo = new MutableLiveData<String>();
        NameToastInfo.setValue("Nagnath Hadapad");
        //NameToastInfo.postValue("Name IS");


        //finally we will return the list
        return NameToastInfo;
    }

    //This method is using Retrofit to get the JSON data from URL
    public void loadHeroes() {

        ApiInterface api = Api.getClient().create(ApiInterface.class);
        //Call<Object> call = api.getHeroes();
        Call<List<BasicInfoBean>> call = api.getHeroes();

        call.enqueue(new Callback<List<BasicInfoBean>>() {
            @Override
            public void onResponse(Call<List<BasicInfoBean>> call, Response<List<BasicInfoBean>> response) {
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<BasicInfoBean>> call, Throwable t) {

                System.out.println("Data Not Valid!"+ t.toString());
            }
        });

    }
}
