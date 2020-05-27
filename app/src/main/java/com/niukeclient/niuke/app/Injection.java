package com.niukeclient.niuke.app;


import com.niukeclient.niuke.data.repository.DemoRepository;
import com.niukeclient.niuke.data.repository.HomeRepository;
import com.niukeclient.niuke.data.repository.LoginRepository;
import com.niukeclient.niuke.data.repository.UserRepository;
import com.niukeclient.niuke.data.source.http.httpData.inter.HomeDataSource;
import com.niukeclient.niuke.data.source.http.httpData.inter.HttpDataSource;
import com.niukeclient.niuke.data.source.http.httpData.mpl.HomeDataSourceImpl;
import com.niukeclient.niuke.data.source.http.httpData.inter.UserDataSource;
import com.niukeclient.niuke.data.source.http.httpData.mpl.HttpDataSourceImpl;
import com.niukeclient.niuke.data.source.http.httpData.mpl.UserDataSourceImpl;
import com.niukeclient.niuke.data.source.http.service.DemoApiService;
import com.niukeclient.niuke.data.source.http.service.HomeApiService;
import com.niukeclient.niuke.data.source.http.service.UserApiService;
import com.niukeclient.niuke.data.source.local.inter.LocalDataSource;
import com.niukeclient.niuke.data.source.local.inter.LocalHomeDataSource;
import com.niukeclient.niuke.data.source.local.mpl.LocalDataSourceImpl;
import com.niukeclient.niuke.data.source.local.mpl.LocalHomeDataSourceImpl;
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

    public static  DemoRepository provideDemoRepository()  {
        //网络API服务
        DemoApiService apiService = RetrofitClient.getInstance().create(DemoApiService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return DemoRepository.getInstance(httpDataSource, localDataSource);
    }

    public static LoginRepository provideLoginRepository()  {
        //网络API服务
        UserApiService apiService = RetrofitClient.getInstance().create(UserApiService.class);
        //网络数据源
        UserDataSource userDataSource = UserDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return LoginRepository.getInstance(userDataSource, localDataSource);
    }

    public static void  onDestroy(){

    }
}
