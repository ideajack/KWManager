package com.jack.kwmanager.biz;

import android.content.Context;
import android.database.Cursor;

import com.jack.kwmanager.bean.User;
import com.jack.kwmanager.util.db.AccountDao;

/**
 * Created by idea_jack on 2018/6/18.
 * 用户业务类
 */

public class UserBiz implements IUserBiz{

    @Override
    public void login(final Context context, final String username, final String pwd, final OnLoginListener loginListener) {
        //开启子线程模拟在数据库中查询
        new Thread(new Runnable() {
            @Override
            public void run() {
                AccountDao accountDao = new AccountDao(context);
                Cursor userCursor = accountDao.findByName(username);
                if (userCursor.moveToFirst()) {
                    //有此用户，再判断密码是否正确
                    String realPwd = userCursor.getString(userCursor.getColumnIndex("pwd"));
                    if (pwd.equals(realPwd)) {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(pwd);
                        loginListener.loginSuccess(user);
                        //todo 将当前用户信息存储在数据库中,可以在presenter中处理
                    } else {
                        //密码错误
                        loginListener.loginFailed(102);
                    }
                }  else {
                    //没有此用户
                    loginListener.loginFailed(101);
                }
            }
        }).start();
    }
}
