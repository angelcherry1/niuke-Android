package com.niukeclient.niuke.data.source.local.inter;

/**
 * Created by goldze on 2019/3/26.
 */
public interface LocalHomeDataSource {
    /**
     * 保存用户名
     */
    void saveUserName(String userName);

    /**
     * 保存用户密码
     */

    void savePassword(String password);

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 获取用户密码
     */
    String getPassword();
}
