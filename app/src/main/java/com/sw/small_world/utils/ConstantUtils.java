package com.sw.small_world.utils;

public interface ConstantUtils {
    /**
     * 加载界面的三种状态
     */
    String STATE_LOADING = "hxkj";
    String STATE_SUCCESSED = "shanyao";
    String STATE_FAILED = null;

    int CAROUSE_TIME = 5000;// 首页轮播的时间间隔
    int TIME_REMOVE_ALL = 25000;// 移除所有操作的时间

    /**
     * 界面中的一些常亮id
     */
    int RES_ID_ADD_CARPORT = 1;
    /**
     * 界面中的一些常亮
     */
    int MAX_ITEM_LOAD_MORE = 20;// 当首次请求数据超过条后开启加载更多功能
    int DEFAUL_TIME = 10;// 默认查询的时间间隔（天）
    int PAGER_ROWS = 20;// 每一页的数据
    int EMPTY_LIMIT = 20;// 低于这个为红色
    String EXIT_APP = "exit_app";// 退出登陆
    String REFRESH_MAIN = "refresh_main";// 刷新主页
    /**
     * 启动Activity的请求码常亮
     */
    // 请求码
    int CODE_PERMISSION = 100;
    int CODE_ADD_CARPORT = 101;
    int CODE_MORE_CARPORT = 102;
    int CODE_SCAN = 103;
    int CODE_ADD_CARPORT_M = 104;
    int CODE_OPEN_BLUE = 105;
}
