package com.jack.kwmanager.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jack.kwmanager.R;
import com.jack.kwmanager.bean.User;
import com.jack.kwmanager.presenter.LoginPresenter;

/**
 * 登录页面
 */
public class LoginActivity extends Activity implements ILoginView{

    private EditText mUserNameEt;
    private EditText mPwdEt;
    private Button mComfirmBtn;
    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mUserNameEt = (EditText) findViewById(R.id.username_et);
        mPwdEt = (EditText) findViewById(R.id.pwd_et);
        mComfirmBtn = (Button) findViewById(R.id.comfirm_btn);

        mComfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用presenter 中的方法
                loginPresenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return mUserNameEt.getText().toString();
    }

    @Override
    public String getPwd() {
        return mPwdEt.getText().toString();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMenuActivity() {
        startActivity(new Intent(this, MenuActivity.class));
    }

    @Override
    public void showFailedError(int code) {
        if (code == 101) {
            Toast.makeText(getContext(), "用户名错误", Toast.LENGTH_SHORT).show();
        } else if (code == 102) {
            Toast.makeText(getContext(), "密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
