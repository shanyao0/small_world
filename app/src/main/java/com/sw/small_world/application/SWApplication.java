package com.sw.small_world.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


/**
 * Created by zs on 2016/08/08.
 */
public class SWApplication extends Application {
    private static Context mContext;
    private static Handler mHandler;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        mHandler=new Handler();
    }

    /**
     * 获取全局的context
     */
    public static Context getContext(){
        return mContext;
    }


    /**
     * 获取全局的主线程的handler
     */
    public static Handler getHandler(){
        return mHandler;
    }
}
