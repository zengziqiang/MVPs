package com.zzq58.mvps.module.login.view;

import com.zzq58.mvps.base.MvpView;
import com.zzq58.mvps.bean.IpBean;

public interface LoginView extends MvpView {


    void loginSuccess(String s);

    void loginSuccess(IpBean ipBean);

    void loginFail(String error);


}
