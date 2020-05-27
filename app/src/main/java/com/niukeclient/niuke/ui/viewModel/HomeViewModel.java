package com.niukeclient.niuke.ui.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;


import com.niukeclient.niuke.app.Injection;
import com.niukeclient.niuke.data.repository.DemoRepository;
import com.niukeclient.niuke.data.repository.HomeRepository;
import com.niukeclient.niuke.entity.User;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.RxUtils;


public class HomeViewModel extends BaseViewModel<HomeRepository> {
    //    private static final String MultiRecycleType_Head = "head";
//    private static final String MultiRecycleType_Left = "left";
//    private static final String MultiRecycleType_Right = "right";
    private HomeRepository homeRepository;
    public MutableLiveData<User> user = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application,Injection.provideHomeRepository());

    }

    //文件下载
    public BindingCommand getUser = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            netRequst();
        }
    });

    private void netRequst() {
        model.getUser(1)
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(HomeViewModel.this) //请求与ViewModel周期同步
                .subscribe(new Observer<BaseResponse<User>>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("测试","onSubscribe");
                    }

                    @Override
                    public void onNext(BaseResponse<User> userBaseResponse) {
                        user.setValue(userBaseResponse.getResult());
                        Log.i("测试","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("测试","onError"+e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.i("测试","onComplete");
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
