package com.glc.greendaoproject;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;


import com.glc.greendaoproject.utils.GreenDaoManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: Application
 * @date: 2023/2/8 15:48
 * @author: gaolicong
 * @email: gaolicong6@gmail.com
 */
public class XlApplication extends Application {

    private static final String TAG = "XlApplication";
    private static  XlApplication xlApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        xlApplication = this;

        GreenDaoManager.getInstance().init();
    }

    public static XlApplication getInstance(){
        if(xlApplication==null){
            synchronized (XlApplication.class){
                if(xlApplication==null){
                    xlApplication=new XlApplication();
                }
            }
        }
        return xlApplication;
    }
}
