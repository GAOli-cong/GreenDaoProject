package com.glc.greendaoproject.utils;

import android.database.sqlite.SQLiteDatabase;

import com.glc.greendaoproject.XlApplication;
import com.glc.greendaoproject.greenDao.gen.DaoMaster;
import com.glc.greendaoproject.greenDao.gen.DaoSession;

/**
 * 数据库处理
 */
public class GreenDaoManager {

    public DaoSession mDaoSession;

    private static class SingletonHolder {
        private static GreenDaoManager instance = new GreenDaoManager();
    }

    public static GreenDaoManager getInstance() {
        return SingletonHolder.instance;
    }

    private GreenDaoManager() {
        init();
    }

    SQLiteOpenHelper openHelper;

    public void init() {
        openHelper = new SQLiteOpenHelper(XlApplication.getInstance(), "test", null);
        openHelper.setWriteAheadLoggingEnabled(true);
        DaoMaster mDaoMaster = new DaoMaster(openHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new SQLiteOpenHelper(XlApplication.getInstance(), "SUBSCREEN", null);
        }
        return openHelper.getWritableDatabase();
    }




}
