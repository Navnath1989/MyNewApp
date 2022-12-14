package com.ondevice.mytestmodule.Config;

import com.ondevice.mytestmodule.Beans.BasicInfoBean;

import java.util.List;

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

    @GET("getownerslist/2021-01-16/payments/owner")
        //Call<Object> getGenralInfo();
    Call<List<BasicInfoBean>> getExamplUrl();

    //Naganath Hadapad

    //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

    //fjdaljljfdlsjfljfdsfsdffsadfdfhahkhakdhkhakdkhdfhk
}
