package com.niukeclient.niuke.data.source.http.service;


import com.niukeclient.niuke.base.BaseApiService;
import com.niukeclient.niuke.entity.CapiCategory;
import com.niukeclient.niuke.entity.CateList;
import com.niukeclient.niuke.entity.Category;
import com.niukeclient.niuke.entity.DemoEntity;
import com.niukeclient.niuke.entity.HomeCarousel;
import com.niukeclient.niuke.entity.HomeCate;
import com.niukeclient.niuke.entity.HomeHotColumn;
import com.niukeclient.niuke.entity.RoomInfo;
import com.niukeclient.niuke.entity.TempLiveVideoInfo;
import com.niukeclient.niuke.entity.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by goldze on 2017/6/15.
 */

public interface HomeApiService {

    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);

    @GET("api/home/getUser")
    Observable<BaseResponse<User>> getUser(@Query("id")int id);
}
