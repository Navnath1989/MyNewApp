package com.ondevice.mynewapp.Config;

import com.ondevice.mynewapp.Beans.BasicInfoBean;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<Object> getNewsApi(@Query("country") String strCount,
                            @Query("apiKey") String strKey);

    @GET("demos/marvel")
    //Call<Object> getGenralInfo();
    Call<List<BasicInfoBean>> getHeroes();

    //Naganath Hadapad

    //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

    // nagnnannahhh dhhd
}
