package com.zzwq.coolgo.listener;

import com.zzwq.coolgo.model.BaseModel;
import com.zzwq.coolgo.model.User;

import java.util.List;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by asus on 2016/9/9.
 */
public interface IBmobListener {

    void onMsgSendSuccess();
    void onMsgSendFailure();
    void onLoginSuccess();
    void onLoginFailure();
    void onSignUpSuccess(User user);
    void onSignUpFailure(BmobException e);
    void onQuerySuccess(List<? extends BaseModel> dataList);
    void onQueryFailure(BmobException e);


}
