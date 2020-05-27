package com.niukeclient.niuke.data.source.http.httpData.inter;

import com.niukeclient.niuke.entity.User;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * @author:lixiaobiao
 * @date:On 2020/5/24
 * @Desriptiong: 23231
 */
public interface UserDataSource {

    Observable<BaseResponse<User>> getUser(int id);

    Observable<BaseResponse<User>> login(String userName,String passWord);

    Observable<BaseResponse<Object>> registerUser(String userName,String passWord);

}
