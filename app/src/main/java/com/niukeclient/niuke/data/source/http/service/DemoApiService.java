package com.niukeclient.niuke.data.source.http.service;

import com.niukeclient.niuke.base.BaseApiService;
import com.niukeclient.niuke.entity.DemoEntity;
import com.niukeclient.niuke.entity.User;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by goldze on 2017/6/15.
 */

public interface DemoApiService  {
    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);

    @GET("api/home/getUser")
    Observable<BaseResponse<User>> getUser(@Query("id")int id);
}
