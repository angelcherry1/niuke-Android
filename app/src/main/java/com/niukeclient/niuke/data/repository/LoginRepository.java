package com.niukeclient.niuke.data.repository;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.niukeclient.niuke.data.source.http.httpData.inter.HttpDataSource;
import com.niukeclient.niuke.data.source.http.httpData.inter.UserDataSource;
import com.niukeclient.niuke.data.source.local.inter.LocalDataSource;
import com.niukeclient.niuke.entity.DemoEntity;
import com.niukeclient.niuke.entity.User;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * Created by goldze on 2019/3/26.
 */
public class LoginRepository extends BaseModel implements UserDataSource, LocalDataSource {
    private volatile static LoginRepository INSTANCE = null;
    private final UserDataSource userDataSource;

    private final LocalDataSource mLocalDataSource;

    private LoginRepository(@NonNull UserDataSource userDataSource,
                            @NonNull LocalDataSource localDataSource) {
        this.userDataSource = userDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static LoginRepository getInstance(UserDataSource userDataSource,
                                              LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (LoginRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LoginRepository(userDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }
    //网络数据处理
    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<BaseResponse<User>> getUser(int id) {
        return userDataSource.getUser(id);
    }

    @Override
    public Observable<BaseResponse<User>> login(String userName, String passWord) {
        return userDataSource.login(userName,passWord);
    }

    @Override
    public Observable<BaseResponse<Object>> registerUser(String userName, String passWord) {
        return userDataSource.registerUser(userName,passWord);
    }


    //以下是本地数据处理
    @Override
    public void saveUserId(String id) {
        mLocalDataSource.saveUserId(id);
    }

    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        mLocalDataSource.savePassword(password);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return mLocalDataSource.getPassword();
    }

    @Override
    public String getUserId() {
        return mLocalDataSource.getUserId();
    }


}
