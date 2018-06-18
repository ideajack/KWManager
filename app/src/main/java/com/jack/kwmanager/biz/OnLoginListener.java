package com.jack.kwmanager.biz;

import com.jack.kwmanager.bean.User;

/**
 * Created by idea_jack on 2018/6/6.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
