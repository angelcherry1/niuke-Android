package com.niukeclient.niuke.app;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.niukeclient.niuke.data.repository.HomeRepository;
import com.niukeclient.niuke.ui.viewModel.HomeViewModel;
import com.niukeclient.niuke.ui.viewModel.UserViewModel;

/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final HomeRepository mRepository;
//    private final UserRepository uRepository;

    public static AppViewModelFactory getInstance(Application application,HomeRepository mRepository) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application, mRepository);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application, HomeRepository mRepository) {
        this.mApplication = application;
        this.mRepository = mRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(mApplication);
        }else if(modelClass.isAssignableFrom(UserViewModel.class)){
//            return (T) new UserViewModel(mApplication, uRepository);
        }
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());


    }
}
