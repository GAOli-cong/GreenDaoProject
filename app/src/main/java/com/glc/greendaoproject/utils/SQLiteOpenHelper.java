package com.glc.greendaoproject.utils;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.glc.greendaoproject.greenDao.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;

public class SQLiteOpenHelper extends DaoMaster.OpenHelper {
    public SQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //删旧表
        DaoMaster.dropAllTables(db, true);
        //创新表
        onCreate(db);
    }
}