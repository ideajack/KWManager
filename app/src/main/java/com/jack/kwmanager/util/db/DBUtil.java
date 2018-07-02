package com.jack.kwmanager.util.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by idea_jack on 2018/6/25.
 */

public class DBUtil extends SQLiteOpenHelper{

    public static final String CREATE_ACCOUNT = "create table account(id integer primary key autoincrement, name text, pwd text)";

    private static DBUtil mDBUtil;

    private DBUtil(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized SQLiteDatabase getInstance (Context context) {
        //加synchronized 避免多线程问题，会影响性能
        if (mDBUtil == null) {
            //延迟加载
            mDBUtil = new DBUtil(context, "KWManager", null, 1);
        }
        return mDBUtil.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ACCOUNT);
        insertData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL(CREATE_ACCOUNT);
                break;
        }
    }

    private void insertData(SQLiteDatabase db) {
        db.execSQL("insert into account(name, pwd) values(?, ?)", new String[] {"admin", "admin"});
        db.execSQL("insert into account(name, pwd) values(?, ?)", new String[] {"zhangxiaojun", "521"});
    }
}
