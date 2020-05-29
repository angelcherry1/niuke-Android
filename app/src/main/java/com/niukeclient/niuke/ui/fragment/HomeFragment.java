package com.niukeclient.niuke.ui.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.niukeclient.niuke.BR;
import com.niukeclient.niuke.R;
import com.niukeclient.niuke.databinding.HomeFragmentBinding;
import com.niukeclient.niuke.ui.viewModel.homeViewModel.HomeViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.base.ViewModelFactory;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class HomeFragment extends BaseFragment<HomeFragmentBinding,HomeViewModel>{



    @Override
    public void initParam() {
        super.initParam();
//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
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
        //给RecyclerView添加Adpter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法，里面有你要的Item对应的binding对象。
        // Adapter属于View层的东西, 不建议定义到ViewModel中绑定，以免内存泄漏
        binding.setAdapter(new BindingRecyclerViewAdapter<MultiItemViewModel>());

    }

    }
