package com.jack.kwmanager.util.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by idea_jack on 2018/6/26.
 * 封装数据操作方法
 */

public class AccountDao {
    private SQLiteDatabase db;

    public AccountDao (Context context) {
        db = DBUtil.getInstance(context);
    }

    /**
     * 根据用户名查询数据
     * @param name 用户名
     * @return Cursor
     */
    public Cursor findByName (String name) {
        Cursor cursor = db.rawQuery("select * from account where name = ?", new String[]{ name });
        return cursor;
    }

    //todo 修改密码
    public void updatePwd () {

    }

}
