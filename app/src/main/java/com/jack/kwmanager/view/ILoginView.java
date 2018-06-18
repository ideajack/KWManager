package com.jack.kwmanager.view;

import com.jack.kwmanager.bean.User;

/**
 * Created by idea_jack on 2018/6/18.
 * presenter与view 交互的interface
 * 根据业务功能来书写
 */

public interface ILoginView {
    //login需要
    String getUserName();
    String getPwd();

    //显示(过程，结果)中需要
    void showLoading();
    void hideLoading();
    void toMenuActivity();
    void showFailedError();
}
