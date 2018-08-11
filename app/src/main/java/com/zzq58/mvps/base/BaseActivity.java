package com.zzq58.mvps.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends Activity {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingBeforeContentView();

        setContentView(getContentView());

        ButterKnife.bind(this);

        mPresenter = createPresenter();

        initView();

        initData();

    }

    /**
     * 在添加布局之前的一些设置项目
     */
    private void settingBeforeContentView() {
    }


    /**
     * 得到当前界面的布局文件id(由子类实现)
     *
     * @return
     */
    protected abstract int getContentView();


    /**
     * 用于创建Presenter和判断是否使用MVP模式(由子类实现)
     *
     * @return
     */
    protected abstract T createPresenter();

    /**
     * 初始化布局
     */
    protected abstract void initView();

    /**
     * 初始化一些数据
     */
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("在BaseActivity中进行销毁");
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    public void showToast(String showmsg) {
        Toast.makeText(this, showmsg, Toast.LENGTH_LONG).show();
    }

    public void showToast(int showmsgId) {
        Toast.makeText(this, showmsgId, Toast.LENGTH_LONG).show();
    }

}
