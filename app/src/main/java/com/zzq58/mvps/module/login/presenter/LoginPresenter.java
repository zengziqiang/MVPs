package com.zzq58.mvps.module.login.presenter;

import com.zzq58.mvps.api.PersionApi;
import com.zzq58.mvps.base.BasePresenter;
import com.zzq58.mvps.bean.IpBean;
import com.zzq58.mvps.module.login.view.LoginView;
import com.zzq58.mvps.network.RetrofitManager;
import com.zzq58.mvps.network.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginView> {

    private PersionApi persionApi = RetrofitManager.getInstance().create(PersionApi.class);
    private PersionApi persionApiBean = RetrofitUtil.getInstance().create(PersionApi.class);

    public LoginPresenter(LoginView loginView) {
        super(loginView);
    }

    public void doLogin(Map map) {
        addSubscription(
                persionApi.doLogin(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        mView.loginSuccess(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.loginFail("网络出错");
                        throwable.printStackTrace();
                    }
                })
        );
    }

    public void doWebMsg() {
        addSubscription(persionApiBean.doWebMsg().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<IpBean>() {
            @Override
            public void accept(IpBean ipBean) throws Exception {
                mView.loginSuccess(ipBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.loginFail("网络出错");
                throwable.printStackTrace();
            }
        }));
    }

}
