package com.niukeclient.niuke.app;


import com.niukeclient.niuke.data.repository.HomeRepository;
import com.niukeclient.niuke.data.repository.UserRepository;
import com.niukeclient.niuke.data.source.http.httpData.HomeDataSource;
import com.niukeclient.niuke.data.source.http.httpData.HomeDataSourceImpl;
import com.niukeclient.niuke.data.source.http.httpData.UserDataSource;
import com.niukeclient.niuke.data.source.http.httpData.UserDataSourceImpl;
import com.niukeclient.niuke.data.source.http.service.HomeApiService;
import com.niukeclient.niuke.data.source.http.service.UserApiService;
import com.niukeclient.niuke.data.source.local.LocalHomeDataSource;
import com.niukeclient.niuke.data.source.local.LocalHomeDataSourceImpl;
import com.niukeclient.niuke.utils.RetrofitClient;

/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 * Created by goldze on 2019/3/26.
 */
public class Injection {
    public static HomeRepository provideHomeRepository() {
        //网络API服务
        HomeApiService apiService = RetrofitClient.getInstance().create(HomeApiService.class);
        //网络数据源
        HomeDataSource httpDataSource = HomeDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalHomeDataSource localDataSource = LocalHomeDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return HomeRepository.getInstance(httpDataSource, localDataSource);
    }
    public static UserRepository provideUserRepository() {
        //网络API服务
        UserApiService apiService = RetrofitClient.getInstance().create(UserApiService.class);
        //网络数据源
        UserDataSource userDataSource = UserDataSourceImpl.getInstance(apiService);
//        //本地数据源
//        LocalHomeDataSource localDataSource = LocalHomeDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return UserRepository.getInstance(userDataSource);
    }
}
