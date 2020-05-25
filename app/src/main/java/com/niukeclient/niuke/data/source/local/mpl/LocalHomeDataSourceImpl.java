package com.niukeclient.niuke.data.source.local.mpl;

import com.niukeclient.niuke.data.source.local.inter.LocalHomeDataSource;

import me.goldze.mvvmhabit.utils.SPUtils;

/**
 * 本地数据源，可配合Room框架使用
 * Created by goldze on 2019/3/26.
 */
public class LocalHomeDataSourceImpl implements LocalHomeDataSource {
    private volatile static LocalHomeDataSourceImpl INSTANCE = null;

    public static LocalHomeDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalHomeDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalHomeDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalHomeDataSourceImpl() {
        //数据库Helper构建
    }

    @Override
    public void saveUserName(String userName) {
        SPUtils.getInstance().put("UserName", userName);
    }

    @Override
    public void savePassword(String password) {
        SPUtils.getInstance().put("password", password);
    }

    @Override
    public String getUserName() {
        return SPUtils.getInstance().getString("UserName");
    }

    @Override
    public String getPassword() {
        return SPUtils.getInstance().getString("password");
    }
}
