package com.niukeclient.niuke.app;

import com.niukeclient.niuke.R;
import com.niukeclient.niuke.ui.view.MainActivity;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * @creaty by :lixiaobiao
 * @date:on 2020/5/21 0021
 * @Describe :xxxxx
 */
public class CherryBaseApplication extends BaseApplication {

    public static CherryBaseApplication mInstance;
    public CherryBaseApplication() {
        super();

    }
    public static synchronized CherryBaseApplication getInstance() {
        return mInstance;
    }

    public static CherryBaseApplication getApplication() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //是否开启日志打印
        KLog.init(true);
        intCrash();
    }
//    //内存泄漏检测
//        if (!LeakCanary.isInAnalyzerProcess(this)) {
//        LeakCanary.install(this);
//    }
private void  intCrash(){
    //配置全局异常崩溃操作
    CaocConfig.Builder.create()
            .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
            .enabled(true) //是否启动全局异常捕获
            .showErrorDetails(true) //是否显示错误详细信息
            .showRestartButton(false) //是否显示重启按钮
            .trackActivities(true) //是否跟踪Activity
            .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
            .errorDrawable(R.mipmap.ic_launcher) //错误图标
            .restartActivity(MainActivity.class) //重新启动后的activity
            //.errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
            //.eventListener(new YourCustomEventListener()) //崩溃后的错误监听
            .apply();
}
}
