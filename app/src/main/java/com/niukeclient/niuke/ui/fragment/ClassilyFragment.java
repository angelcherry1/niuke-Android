package com.niukeclient.niuke.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;


import com.niukeclient.niuke.BR;
import com.niukeclient.niuke.R;
import com.niukeclient.niuke.databinding.ClassilyFragmentBinding;
import com.niukeclient.niuke.ui.viewModel.ClassilyViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

public class ClassilyFragment extends BaseFragment<ClassilyFragmentBinding,ClassilyViewModel> {

    private ClassilyViewModel mViewModel;

    public static ClassilyFragment newInstance() {
        return new ClassilyFragment();
    }


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.classily_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.classilyViewModel;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ClassilyViewModel.class);
        // TODO: Use the ViewModel
    }

}
