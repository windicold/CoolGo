package com.zzwq.coolgo.model;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by asus on 2016/9/9.
 */
public class User extends BmobUser {
    private BmobFile headIcon;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String sex;
    private float balance;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BmobFile getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(BmobFile headIcon) {
        this.headIcon = headIcon;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
