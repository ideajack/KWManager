package com.jack.kwmanager.biz;

/**
 * Created by idea_jack on 2018/6/6.
 */

public interface IUserBiz {
    public void login(String username, String pwd, OnLoginListener loginListener);
}
