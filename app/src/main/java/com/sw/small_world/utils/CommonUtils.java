package com.sw.small_world.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.sw.small_world.application.SWApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CommonUtils {
    /**
     * dip转化成px
     */
    public static int dip2px( float dpValue) {
        final float scale = SWApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转化成dip
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * px转化成sp
     */
    public static int px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转化成px
     */
    public static int sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (spValue * scale + 0.5f);
    }

    /**
     * 在主线程执行任务
     */
    public static void runOnUIThread(Runnable r) {
        SWApplication.getHandler().post(r);
    }

    /**
     * 获取Resource对象
     */
    public static Resources getResources() {
        return SWApplication.getContext().getResources();
    }

    /**
     * 获取Drawable资源
     */
    public static Drawable getDrawable(int resId) {
        return getResources().getDrawable(resId);
    }

    /**
     * 获取字符串资源
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * 获取color资源
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 获取dimens资源
     */
    public static float getDimens(int resId) {
        return getResources().getDimension(resId);
    }

    /**
     * 获取字符串数组资源
     */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 将自己从父容器中移除
     */
    public static void removeSelfFromParent(View child) {
        // 获取父view
        if (child != null) {
            ViewParent parent = child.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                // 将自己移除
                viewGroup.removeView(child);
            }
        }
    }

    public static boolean isCameraCanUse() {
        boolean bool = false;

        PackageManager pm = SWApplication.getContext().getPackageManager();
        bool = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA) || pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);

        return bool;
    }

    /**
     * 验证车牌号码格式是否正确
     *
     * @param plateNumber 车牌号码
     * @return ture正确 falise错误
     */
    public static boolean checkPlateNumber(String plateNumber) {
        String regex = "^[\u4e00-\u9fa5|WJ]{1}[A-Z0-9]{6}$";
        return Pattern.matches(regex, plateNumber);
    }

    /**
     * 验证电话号码的格式是否正确
     *
     * @param mobile
     * @return
     */
    public static boolean checkMobile(String mobile) {
        String regex = "(\\+\\d+)?1[34578]\\d{9}$";
        return Pattern.matches(regex, mobile);
    }

    public static boolean checkIsNum(String string) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(string);
        if (isNum.matches()) {
            return true;
        }
        return false;
    }

    public static boolean isOk(String week, String beginTime, String endTime) {
        final String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String[] weeks = week.split(" ");
        if((getTime(endTime) - getTime(beginTime)>1000*60*24*6)){
          return Arrays.toString(dayNames).equals(Arrays.toString(weeks));
        }
        int startIndex = getWeekIndex(beginTime);
        int endIndex = getWeekIndex(endTime);
        if(startIndex<endIndex){
            for (int i = startIndex; i <= endIndex; i++) {
                for(String s:weeks){
                    if(dayNames[i].equals(s)) return false;
                }
            }
        }else{
            for(int i = startIndex;i<= 6;i++){
                for(String s:weeks){
                    if(dayNames[i].equals(s)) return false;
                }
            }
            for(int i = 0;i<= endIndex;i++){
                for(String s:weeks){
                    if(dayNames[i].equals(s)) return false;
                }
            }
        }

        return true;
    }

    public static int getWeekIndex(String time) {
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try {
            date = sdfInput.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) dayOfWeek = 0;
        return dayOfWeek;
    }
    public static long getTime(String time){
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        try {
            date = sdfInput.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            return mobiles.matches(telRegex);
        }
    }
}


