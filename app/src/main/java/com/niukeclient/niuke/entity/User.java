package com.niukeclient.niuke.entity;

import androidx.databinding.Bindable;

/**
 * @author:lixiaobiao
 * @date:On 2020/5/24
 * @Desriptiong: 23231
 */
public class User {
    private int id;
    private String userName;
    private String passWord;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        this.passWord = passWord;
    }
}
