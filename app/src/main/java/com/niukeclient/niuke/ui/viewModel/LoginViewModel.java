package com.niukeclient.niuke.ui.viewModel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;

import com.niukeclient.niuke.entity.User;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:lixiaobiao
 * @date:On 2020/5/25
 * @Desriptiong: 23231
 */
public class LoginViewModel extends BaseViewModel {
    //用户名的绑定
    public ObservableField<String> userName = new ObservableField<>("");  //用户名的绑定
    public ObservableField<String> passWord = new ObservableField<>("");


    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();
    public class UIChangeObservable {
        //密码开关观察者
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
    }
    //用户名清除按钮的显示隐藏绑定
    public ObservableInt clearBtnVisibility = new ObservableInt();

    public LoginViewModel (@NonNull Application application){
        super(application);
        userName.set("");
        passWord.set("");
    }

    //用户注册按钮的点击事件
    public BindingCommand userRegister = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
       //跳转用户注册界面
        }
    });

    //忘记按钮的点击事件
    public BindingCommand forgetPassWord = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
       //跳转用户找回密码界面
        }
    });

    //用户登录按钮的点击事件
    public BindingCommand userLogin = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
       //跳转登录成功执行登录业务
            login();
        }
    });

    //用户账号点击重置事件
    public BindingCommand clearUserNameOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showLong("我清除用户数据！");
            userName.set("");
//            userName.notifyChange();

        }
    });

    //用户密码是否可见事件
    public BindingCommand passWordStatus = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //让观察者的数据改变,逻辑从ViewModel层转到View层，在View层的监听则会被调用
            uc.pSwitchEvent.setValue(uc.pSwitchEvent.getValue() == null || !uc.pSwitchEvent.getValue());
        }
    });

    //用户名输入框焦点改变的回调事件
    public BindingCommand<Boolean> onFocusChangeCommand = new BindingCommand<>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean hasFocus) {
            if (hasFocus) {
                clearBtnVisibility.set(View.VISIBLE);
            } else {
                clearBtnVisibility.set(View.INVISIBLE);
            }
        }
    });

    //执行登录业务
    private void login() {
        ToastUtils.showLong("我执行行了登录的任务:"+userName.get()+"  "+passWord.get());
    }

}
