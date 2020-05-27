package com.niukeclient.niuke.ui.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;


import com.niukeclient.niuke.app.Injection;
import com.niukeclient.niuke.data.repository.DemoRepository;
import com.niukeclient.niuke.data.repository.HomeRepository;
import com.niukeclient.niuke.entity.User;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;


public class HomeViewModel extends BaseViewModel<HomeRepository> {
    //    private static final String MultiRecycleType_Head = "head";
//    private static final String MultiRecycleType_Left = "left";
//    private static final String MultiRecycleType_Right = "right";
    private HomeRepository homeRepository;
    public MutableLiveData<User> user = new MutableLiveData<>();
    public ObservableField<String> adduserName = new ObservableField<>();
    public ObservableField<String> adduserPass = new ObservableField<>();
    public HomeViewModel(@NonNull Application application) {
        super(application,Injection.provideHomeRepository());
        user.setValue(new User());
        adduserName.set("");
        adduserPass.set("");
    }

    //文件下载
    public BindingCommand getUser = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            netRequst();
        }
    });

    //文件下载
    public BindingCommand btnAddUser = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
//            addnetRequst();
            user.getValue().setUserName(adduserName.get());
            user.getValue().setPassWord(adduserPass.get());
            user.setValue(user.getValue());
            ToastUtils.showShort("获得的数据是："+adduserName.get());
        }
    });

//    private void addnetRequst() {
//        model.addUser(adduser.getValue().getUserName(),adduser.getValue().getPassWord())
//                .compose(RxUtils.schedulersTransformer())
//                .doOnSubscribe(HomeViewModel.this)
//                .subscribe(new Consumer<BaseResponse<Object>>() {
//                    @Override
//                    public void accept(BaseResponse<Object> baseResponse) throws Exception {
//                        if(baseResponse.getCode()==1){
//                            ToastUtils.showShort("添加成功！");
//                        }
//                    }
//                });
//    }

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
