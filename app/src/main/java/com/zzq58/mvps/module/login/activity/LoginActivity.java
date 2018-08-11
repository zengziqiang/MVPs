package com.zzq58.mvps.module.login.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zzq58.mvps.R;
import com.zzq58.mvps.base.BaseActivity;
import com.zzq58.mvps.bean.IpBean;
import com.zzq58.mvps.module.login.presenter.LoginPresenter;
import com.zzq58.mvps.module.login.view.LoginView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {


    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_getmsg)
    Button btnGetmsg;
    @BindView(R.id.tv_showmsg)
    TextView tvShowmsg;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginSuccess(String s) {
        tvShowmsg.setText(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            if (jsonObject.getInt("code") == 0) {
                showToast("成功");
            } else {
                loginFail(jsonObject.getString("msg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loginSuccess(IpBean ipBean) {
        tvShowmsg.setText(ipBean.toString());
    }

    @Override
    public void loginFail(String error) {
        showToast(error);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @OnClick({R.id.btn_login, R.id.btn_getmsg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String un = etUsername.getText().toString();
                if (TextUtils.isEmpty(un)) {
                    showToast("用户名不能为空");
                    return;
                }
                String pw = etPassword.getText().toString();
                if (TextUtils.isEmpty(pw)) {
                    showToast("密码不能为空");
                    return;
                }

                Map map = new HashMap();
                map.put("un", un);
                map.put("pw", pw);
                mPresenter.doLogin(map);
                break;
            case R.id.btn_getmsg:
                mPresenter.doWebMsg();
                break;
        }
    }

}
