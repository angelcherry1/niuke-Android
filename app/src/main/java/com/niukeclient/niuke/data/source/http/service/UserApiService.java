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
 * @author:lixiaobiao
 * @date:On 2020/5/24
 * @Desriptiong: 23231
 */
public interface UserApiService{
    @GET("api/home/getUser")
    Observable<BaseResponse<User>> getUser(@Query("id") int id);

    @GET("api/user/login")
    Observable<BaseResponse<User>> login(@Query("userName") String userName,@Query("passWord") String passWord);

    @FormUrlEncoded
    @POST("api/home/addUser")
    Observable<BaseResponse<Object>> registerUser(@Query("userName") String userName,@Query("passWord") String passWord);
}
