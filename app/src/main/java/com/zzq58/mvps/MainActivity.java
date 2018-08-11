package com.zzq58.mvps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zzq58.mvps.base.BaseActivity;
import com.zzq58.mvps.base.BasePresenter;
import com.zzq58.mvps.module.login.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_images)
    Button btnImages;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_login, R.id.btn_images})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.btn_images:
                break;
        }
    }
}