package com.niukeclient.niuke.data.source.http.httpData.inter;

import com.niukeclient.niuke.entity.DemoEntity;
import com.niukeclient.niuke.entity.User;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {
    //模拟登录
    Observable<Object> login();

    //模拟上拉加载
    Observable<DemoEntity> loadMore();

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);

    Observable<BaseResponse<User>> getUser(int id);

}
