package com.niukeclient.niuke.ui.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.niukeclient.niuke.BR;
import com.niukeclient.niuke.R;
import com.niukeclient.niuke.app.AppViewModelFactory;
import com.niukeclient.niuke.app.Injection;
import com.niukeclient.niuke.data.repository.HomeRepository;
import com.niukeclient.niuke.data.source.http.httpData.HomeDataSource;
import com.niukeclient.niuke.data.source.http.httpData.HomeDataSourceImpl;
import com.niukeclient.niuke.data.source.http.service.HomeApiService;
import com.niukeclient.niuke.data.source.local.LocalHomeDataSource;
import com.niukeclient.niuke.data.source.local.LocalHomeDataSourceImpl;
import com.niukeclient.niuke.databinding.HomeFragmentBinding;
import com.niukeclient.niuke.ui.viewModel.HomeViewModel;
import com.niukeclient.niuke.utils.RetrofitClient;

import me.goldze.mvvmhabit.base.BaseFragment;

public class HomeFragment extends BaseFragment<HomeFragmentBinding,HomeViewModel>{

    private HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void initParam() {
        super.initParam();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.home_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.homeViewModel;
    }

    @Override
    public HomeViewModel initViewModel() {
        Log.i("initViewModel：","apiServicebefore");
        //网络API服务
        try{
            HomeApiService apiService = RetrofitClient.getInstance().create(HomeApiService.class);
        }catch (Exception e){
            e.printStackTrace();
        }
//        网络数据源
        Log.i("initViewModel：","apiServiceafter");
//        HomeDataSource httpDataSource = HomeDataSourceImpl.getInstance(apiService);
////        本地数据源
//        LocalHomeDataSource localDataSource = LocalHomeDataSourceImpl.getInstance();
////        两条分支组成一个数据仓库
//        HomeRepository instance = HomeRepository.getInstance(httpDataSource, localDataSource);

//        Log.i("我获得的数据：",instance.getUserName());
//        AppViewModelFactory   appViewModelFactory = AppViewModelFactory.getInstance(getActivity().getApplication(), Injection.provideHomeRepository());
        return  ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @SuppressLint("ResourceType")
    @Override
    public void initData() {
//
//    @Override
//    public void onBannerItemClick(BGABanner banner, SimpleDraweeView itemView, String model, int position) {        binding.setHomeAdapter(new BindingRecyclerViewAdapter());
    }

    }
