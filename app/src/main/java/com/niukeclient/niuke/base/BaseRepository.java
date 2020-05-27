package com.niukeclient.niuke.base;

import com.niukeclient.niuke.data.repository.DemoRepository;
import com.niukeclient.niuke.data.source.http.httpData.inter.HttpDataSource;
import com.niukeclient.niuke.data.source.http.httpData.mpl.HttpDataSourceImpl;
import com.niukeclient.niuke.data.source.http.service.DemoApiService;
import com.niukeclient.niuke.data.source.local.inter.LocalDataSource;
import com.niukeclient.niuke.data.source.local.mpl.LocalDataSourceImpl;
import com.niukeclient.niuke.utils.RetrofitClient;

import me.goldze.mvvmhabit.base.BaseModel;

/**
 * @creaty by :lixiaobiao
 * @date:on 2020/5/26 0026
 * @Describe :xxxxx
 */
public abstract class  BaseRepository<T extends BaseApiService> extends BaseModel {


    public static DemoRepository provideDemoRepository() {
        //网络API服务
        DemoApiService apiService = RetrofitClient.getInstance().create(DemoApiService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return DemoRepository.getInstance(httpDataSource, localDataSource);
    }
}
