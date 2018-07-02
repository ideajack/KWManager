package com.jack.kwmanager.util;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jack.kwmanager.util.db.DBUtil;

/**
 * Created by idea_jack on 2018/7/3.
 */

public class MyApplication extends Application {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        DBUtil.getInstance(mContext);
    }
}
