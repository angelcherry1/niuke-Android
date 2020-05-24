package com.niukeclient.niuke.data.source.http.httpData;

import com.niukeclient.niuke.data.source.http.service.HomeApiService;
import com.niukeclient.niuke.entity.DemoEntity;
import com.niukeclient.niuke.entity.RoomInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * Created by goldze on 2019/3/26.
 */
public class HomeDataSourceImpl implements HomeDataSource {
    private HomeApiService apiService;
    private volatile static HomeDataSourceImpl INSTANCE = null;

    public static HomeDataSourceImpl getInstance(HomeApiService apiService) {
        if (INSTANCE == null) {
            synchronized (HomeDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HomeDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HomeDataSourceImpl(HomeApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return apiService.demoGet();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return apiService.demoPost(catalog);
    }
}
