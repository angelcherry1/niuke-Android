package com.niukeclient.niuke.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.niukeclient.niuke.BR;
import com.niukeclient.niuke.R;
import com.niukeclient.niuke.databinding.UserFragmentBinding;
import com.niukeclient.niuke.ui.viewModel.userViewModel.UserViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

public class UserFragment extends BaseFragment<UserFragmentBinding, UserViewModel> {

    private UserViewModel mViewModel;

    public static UserFragment newInstance() {
        return new UserFragment();
    }


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.user_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.userViewModel;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        AppViewModelFactory appViewModelFactory=AppViewModelFactory.getInstance(getActivity().getApplication(), Injection.provideUserRepository());
        mViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

    }

}
