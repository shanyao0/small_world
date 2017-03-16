package com.sw.small_world.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sw.small_world.application.SWApplication;

import java.util.ArrayList;



public class ShareUtils {

    private static final String NAME = "huaching";
    private static SharedPreferences sp = null;
    private static Context context = SWApplication.getContext();
    /**
     * key值
     */
    // =============登陆=========================
    public static String LOGIN_STATE = "login_state";// 登陆状态
    public static String MY_PHONE_NUM = "my_phone_num";// 我的手机号码
    public static String JSESSIONID = "jsessionid";// 我的手机号码
    // =============找车场=========================
    public static String DATA_MY_CARPORT = "data_my_carport";// 首页我得车位缓存信息
    public static String DATA_ALL_CARPORT = "data_all_carport";// 首页我得车位缓存信息所有的
    public static String DATA_RECORD = "data_record";// 操作记录
    public static String DATA_DEVICES = "data_devices";
    public static String CURRENT_LON = "current_lon";
    public static String UPDATE_ID = "update_id";
    public static String VERSION = "version";

    /**
     * 存布尔值
     */
    public static void putBoolean(String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 去布尔值
     */
    public static boolean getBoolean(String key,
                                     boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    /**
     * 存Strings
     */
    public static void putString(String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    /**
     * 取String
     */
    public static String getString(String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 存int
     */
    public static void putInt(String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 取int
     */
    public static int getInt(String key, int defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

    /**
     * 存Float
     */
    public static void putFloat(String key, Float value) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putFloat(key, value).commit();
    }

    /**
     * 取Float
     */
    public static Float getFloat(String key, Float defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        return sp.getFloat(key, defValue);
    }

    public static void remove(String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().remove(key).commit();
    }

    public static void clear() {
        if (sp == null) {
            sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        }
        sp.edit().clear().commit();
    }
}
