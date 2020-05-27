package com.niukeclient.niuke.data.repository;

import androidx.annotation.NonNull;

import com.niukeclient.niuke.data.source.http.httpData.inter.HomeDataSource;
import com.niukeclient.niuke.data.source.local.inter.LocalHomeDataSource;
import com.niukeclient.niuke.entity.DemoEntity;
import com.niukeclient.niuke.entity.User;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * @creaty by :lixiaobiao
 * @date:on 2020/5/21 0021
 * @Describe :xxxxx
 */
public class HomeRepository extends BaseModel implements HomeDataSource, LocalHomeDataSource {
    private volatile static HomeRepository INSTANCE = null;
    private final HomeDataSource homeDataSource;

    private final LocalHomeDataSource localHomeDataSource;


    private HomeRepository(@NonNull LocalHomeDataSource localDataSource, @NonNull HomeDataSource homeDataSource) {
        this.homeDataSource = homeDataSource;
        this.localHomeDataSource = localDataSource;
    }

    public static HomeRepository getInstance(HomeDataSource homeDataSource,
                                             LocalHomeDataSource localHomeDataSource) {
        if (INSTANCE == null) {
            synchronized (HomeRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HomeRepository(localHomeDataSource, homeDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void saveUserName(String userName) {
        localHomeDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        localHomeDataSource.savePassword(password);
    }

    @Override
    public String getUserName() {
        return localHomeDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return localHomeDataSource.getPassword();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return homeDataSource.demoGet();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return homeDataSource.demoPost(catalog);
    }

    @Override
    public Observable<BaseResponse<User>> getUser(int id) {
        return homeDataSource.getUser(id);
    }

    @Override
    public Observable<BaseResponse<Object>> addUser(String userName, String passWord) {
        return homeDataSource.addUser(userName,passWord);
    }

}
