package com.jack.kwmanager.biz;

import com.jack.kwmanager.bean.User;

/**
 * Created by idea_jack on 2018/6/18.
 * 用户业务类
 */

public class UserBiz implements IUserBiz{

    @Override
    public void login(final String username, final String pwd, final OnLoginListener loginListener) {
        //开启子线程模拟在数据库中查询
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("jack".equals(username) && "123".equals(pwd)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(pwd);
                    loginListener.loginSuccess(user);
                    //todo 将当前用户信息存储在数据库中,可以在presenter中处理

                } else {
                    loginListener.loginFailed();
                }
            }
        }).start();
    }
}
