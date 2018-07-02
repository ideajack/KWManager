package com.jack.kwmanager.presenter;

import android.os.Handler;

import com.jack.kwmanager.bean.User;
import com.jack.kwmanager.biz.IUserBiz;
import com.jack.kwmanager.biz.OnLoginListener;
import com.jack.kwmanager.biz.UserBiz;
import com.jack.kwmanager.view.ILoginView;


/**
 * Created by idea_jack on 2018/6/18.
 * Model和View之间交互的桥梁
 */

public class LoginPresenter {
    private IUserBiz userBiz;
    private ILoginView loginView;
    private Handler mHandler = new Handler();

    public LoginPresenter (ILoginView loginView) {
        this.loginView = loginView;
        this.userBiz = new UserBiz();
    }

    public void login () {
        loginView.showLoading();
        userBiz.login(loginView.getContext(), loginView.getUserName(), loginView.getPwd(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                //此时非UI线程

                saveUserData(user);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMenuActivity();
                        loginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed(final int code) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError(code);
                        loginView.hideLoading();
                    }
                });
            }
        });
    }

    /**
     * 将当前用户数据存储在数据库中
     * @param user
     */
    private void saveUserData(User user) {

    }

}
