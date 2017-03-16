package com.sw.small_world.utils;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sw.small_world.R;
import com.sw.small_world.application.SWApplication;



public class ToastUtil {
	private static Toast toast = null;
	public static void show(String msg) {
		try {
			if (TextUtils.isEmpty(msg)) {
				return;
			}
			initToast( msg);
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void show(String msg, int time) {
		try {
			if (TextUtils.isEmpty(msg)) {
				return;
			}
			initToast( msg, time);
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void show(int resId) {

		try {
			if (TextUtils.isEmpty(CommonUtils.getString(resId))) {
				return;
			}
			initToast(resId);
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showAtCenter( int resId) {
		try {
			if (TextUtils.isEmpty(CommonUtils.getString(resId))) {
				return;
			}
			initToast( resId);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void showAtCenter(String msg) {

		try {
			if (TextUtils.isEmpty(msg)) {
				return;
			}
			initToast(msg);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param msgRes
	 */
	private static void initToast(int msgRes) {
		initToast(CommonUtils.getString(msgRes));
	}

	/**
	 * 初始化自定义Toast
	 *
	 * @param msg
	 */
	private static void initToast(String msg) {
		if (null != toast) {
			toast.cancel();
		}
		View toastRoot = LayoutInflater.from(SWApplication.getContext()).inflate(R.layout.view_layout_toast, null);
		toast = new Toast(SWApplication.getContext());
		toast.setView(toastRoot);
		toast.setGravity(Gravity.BOTTOM, 0, 100);
		toast.setDuration(Toast.LENGTH_SHORT);
		TextView tv_message = (TextView) toast.getView().findViewById(R.id.message);
		tv_message.setText(msg);
	}

	/**
	 * 初始化自定义Toast
	 *
	 * @param msg
	 * @param time
	 */
	private static void initToast(String msg, int time) {
		if (null != toast) {
			toast.cancel();
		}
		View toastRoot = LayoutInflater.from(SWApplication.getContext()).inflate(R.layout.view_layout_toast, null);
		toast = new Toast(SWApplication.getContext());
		toast.setView(toastRoot);
		toast.setGravity(Gravity.BOTTOM, 0, 100);
		toast.setDuration(time);
		TextView tv_message = (TextView) toast.getView().findViewById(R.id.message);
		tv_message.setText(msg);
	}
}
