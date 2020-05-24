package com.niukeclient.niuke.data.repository;

import android.util.Log;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

import com.niukeclient.niuke.data.source.http.httpData.UserDataSource;
import com.niukeclient.niuke.entity.User;

/**
 * @author:lixiaobiao
 * @date:On 2020/5/24
 * @Desriptiong: 23231
 */
public class UserRepository extends BaseModel implements UserDataSource {
    private volatile static UserRepository INSTANCE = null;
    private final UserDataSource userDataSource;

    public UserRepository(UserDataSource userDataSource) {
        this.userDataSource = userDataSource;
    }


    public static UserRepository getInstance(UserDataSource userDataSource) {
        if (INSTANCE == null) {
            synchronized (UserRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserRepository(userDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Observable<BaseResponse<User>> getUser(int id) {
        Log.i("BaseResponse","获得的id是："+id);
        return userDataSource.getUser(id);
    }
}
