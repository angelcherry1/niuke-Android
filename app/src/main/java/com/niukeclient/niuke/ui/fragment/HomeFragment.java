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
import com.niukeclient.niuke.data.source.http.service.HomeApiService;
import com.niukeclient.niuke.databinding.HomeFragmentBinding;
import com.niukeclient.niuke.ui.viewModel.HomeViewModel;
import com.niukeclient.niuke.utils.RetrofitClient;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.ViewModelFactory;

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
//使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        ViewModelFactory factory=ViewModelFactory.getInstance(getActivity().getApplication());
//        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return  ViewModelProviders.of(this,factory).get(HomeViewModel.class);
    }

    @SuppressLint("ResourceType")
    @Override
    public void initData() {
//
//    @Override
//    public void onBannerItemClick(BGABanner banner, SimpleDraweeView itemView, String model, int position) {        binding.setHomeAdapter(new BindingRecyclerViewAdapter());
    }

    }
