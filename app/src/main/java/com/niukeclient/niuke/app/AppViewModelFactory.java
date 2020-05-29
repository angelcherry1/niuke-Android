package com.niukeclient.niuke.app;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.niukeclient.niuke.ui.viewModel.homeViewModel.HomeViewModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
//    private final DemoRepository mRepository;

    public static AppViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application) {
        this.mApplication = application;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(mApplication);
        }//反射动态实例化ViewModel
        try {
            String className = modelClass.getCanonicalName();
            Class<?> classViewModel = Class.forName(className);
            Constructor<?> cons = classViewModel.getConstructor(Application.class);
            ViewModel viewModel = (ViewModel) cons.newInstance(mApplication);
            return (T) viewModel;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        }
    }
}
