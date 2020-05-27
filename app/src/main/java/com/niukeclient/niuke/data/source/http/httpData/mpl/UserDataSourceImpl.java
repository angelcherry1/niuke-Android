package com.niukeclient.niuke.data.source.http.httpData.mpl;

import android.util.Log;

import com.niukeclient.niuke.data.source.http.httpData.inter.UserDataSource;
import com.niukeclient.niuke.data.source.http.service.UserApiService;
import com.niukeclient.niuke.entity.User;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * @author:lixiaobiao
 * @date:On 2020/5/24
 * @Desriptiong: 23231
 */
public class UserDataSourceImpl implements UserDataSource {


    private UserApiService userApiService;
    private volatile static UserDataSourceImpl INSTANCE = null;

    public static UserDataSourceImpl getInstance(UserApiService apiService) {
        if (INSTANCE == null) {
            synchronized (HomeDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private UserDataSourceImpl(UserApiService apiService) {
        this.userApiService = apiService;
    }
    @Override
    public Observable<BaseResponse<User>> getUser(int id) {
        Log.i("UserDataSourceImpl","获得的id是："+id);
        return userApiService.getUser(id);
    }

    @Override
    public Observable<BaseResponse<User>> login(String userName, String passWord) {
        return userApiService.login(userName,passWord);
    }

    @Override
    public Observable<BaseResponse<Object>> registerUser(String userName, String passWord) {
        return userApiService.registerUser(userName,passWord);
    }

}
