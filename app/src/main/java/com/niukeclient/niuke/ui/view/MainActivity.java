package com.niukeclient.niuke.ui.view;


import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.niukeclient.niuke.BR;
import com.niukeclient.niuke.R;
import com.niukeclient.niuke.databinding.ActivityMainBinding;
import com.niukeclient.niuke.ui.fragment.ClassilyFragment;
import com.niukeclient.niuke.ui.fragment.HomeFragment;
import com.niukeclient.niuke.ui.fragment.UserFragment;
import com.niukeclient.niuke.ui.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private List<Fragment> mFragments;
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.mainViewModel;
    }

    @Override
    public MainViewModel initViewModel() {
        //View持有ViewModel的引用，如果没有特殊业务处理，这个方法可以不重写
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void initData() {
        //初始化Fragment
        initFragment();
        //初始化底部Button
        initBottomTab();
    }
    //初始化底部Button
    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.drawable.vector_drawable_recommend, "推荐")
                .addItem(R.drawable.vector_drawable_classify, "分类")
                .addItem(R.drawable.vector_drawable_user, "用户")
                .setDefaultColor(ContextCompat.getColor(this, R.color.textColorVice))
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frameLayout, mFragments.get(index));
//                transaction.commitAllowingStateLoss();
                commitAllowingStateLoss(index);
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }
    //初始化Fragment
    private List<Fragment> initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ClassilyFragment());
        mFragments.add(new UserFragment());
        commitAllowingStateLoss(0);
        return mFragments;
    }

    private void commitAllowingStateLoss(int position) {
        hideAllFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(position + "");
        if (currentFragment != null) {
            transaction.show(currentFragment);
        } else {
            currentFragment = mFragments.get(position);
            transaction.add(R.id.frameLayout, currentFragment, position + "");
        }
        transaction.commitAllowingStateLoss();
    }
    //隐藏所有Fragment
    private void hideAllFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(i + "");
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
        }
        transaction.commitAllowingStateLoss();
    }
}
