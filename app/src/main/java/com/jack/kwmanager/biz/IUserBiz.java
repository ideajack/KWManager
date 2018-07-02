package com.jack.kwmanager.biz;

import android.content.Context;

/**
 * Created by idea_jack on 2018/6/6.
 */

public interface IUserBiz {
    public void login(Context context, String username, String pwd, OnLoginListener loginListener);
}
