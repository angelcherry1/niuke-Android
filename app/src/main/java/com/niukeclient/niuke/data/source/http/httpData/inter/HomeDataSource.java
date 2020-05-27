package com.niukeclient.niuke.data.source.http.httpData.inter;

import com.niukeclient.niuke.entity.DemoEntity;
import com.niukeclient.niuke.entity.RoomInfo;
import com.niukeclient.niuke.entity.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * @creaty by :lixiaobiao
 * @date:on 2020/5/21 0021
 * @Describe :xxxxx
 */
public interface HomeDataSource {
    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);

    Observable<BaseResponse<User>> getUser(int id);
}
