package com.niukeclient.niuke.data.source.http.service;

import com.niukeclient.niuke.base.BaseApiService;
import com.niukeclient.niuke.entity.User;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author:lixiaobiao
 * @date:On 2020/5/24
 * @Desriptiong: 23231
 */
public interface UserApiService{
    @GET("getUser")
    Observable<BaseResponse<User>> getUser(@Query("id") int id);
}
