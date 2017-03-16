package com.sw.small_world.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.sw.small_world.activity.ClickButtonActivity;
import com.sw.small_world.application.SWApplication;



/**
 * Created by zhaoshuo on 2016/3/17.
 */
public class StartUtils {
    public static void startActivityById(Context context, int resId){
        Intent intent = new Intent(SWApplication.getContext(), ClickButtonActivity.class);
        intent.putExtra("resId",resId);
        context.startActivity(intent);
    }
    public static void startActivityByIdForResult(Fragment activity, int resId , int requestCode){
        Intent intent = new Intent(SWApplication.getContext(), ClickButtonActivity.class);
        intent.putExtra("resId",resId);
        activity.startActivityForResult(intent,requestCode);
    }

}
