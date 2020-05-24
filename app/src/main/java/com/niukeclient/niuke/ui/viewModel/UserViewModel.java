package com.niukeclient.niuke.ui.viewModel;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.niukeclient.niuke.data.repository.UserRepository;
import com.niukeclient.niuke.entity.User;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class UserViewModel extends BaseViewModel<UserRepository> {
    public UserViewModel(@NonNull Application application,UserRepository userRepository) {
        super(application,userRepository);
        requestNetWork();
    }
    public MutableLiveData<User> user;


    @SuppressLint("CheckResult")
    public void requestNetWork() {
        //可以调用addSubscribe()添加Disposable，请求与View周期同步
        model.getUser(1)
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .compose(RxUtils.exceptionTransformer()) // 网络错误的异常转换, 这里可以换成自己的ExceptionHandle
                .doOnSubscribe(this)//请求与ViewModel周期同步
                .subscribe(new Consumer<BaseResponse<User>>() {
                    @Override
                    public void accept(BaseResponse<User> response) throws Exception {


                        //请求成功
                        if (response.getCode() == 1) {
                            user.setValue(response.getResult());
                        } else {
                            //code错误时也可以定义Observable回调到View层去处理
                            ToastUtils.showShort("数据错误");
                        }
                    }
                });
    }

    // TODO: Implement the ViewModel
}
