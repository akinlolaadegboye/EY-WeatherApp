package com.ey.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ey.R;


import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.ConfigurationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static android.Manifest.permission.ACCESS_NETWORK_STATE;

public class AppUtil {
  private static Interpolator fastOutSlowIn;

  public static void setWeatherIcon(Context context, AppCompatImageView imageView, int weatherCode) {
    if (weatherCode / 100 == 2) {
      Glide.with(context).load(R.drawable.ic_storm_weather).into(imageView);
    } else if (weatherCode / 100 == 3) {
      Glide.with(context).load(R.drawable.ic_rainy_weather).into(imageView);
    } else if (weatherCode / 100 == 5) {
      Glide.with(context).load(R.drawable.ic_rainy_weather).into(imageView);
    } else if (weatherCode / 100 == 6) {
      Glide.with(context).load(R.drawable.ic_snow_weather).into(imageView);
    } else if (weatherCode / 100 == 7) {
      Glide.with(context).load(R.drawable.ic_unknown).into(imageView);
    } else if (weatherCode == 800) {
      Glide.with(context).load(R.drawable.ic_clear_day).into(imageView);
    } else if (weatherCode == 801) {
      Glide.with(context).load(R.drawable.ic_few_clouds).into(imageView);
    } else if (weatherCode == 803) {
      Glide.with(context).load(R.drawable.ic_broken_clouds).into(imageView);
    } else if (weatherCode / 100 == 8) {
      Glide.with(context).load(R.drawable.ic_cloudy_weather).into(imageView);
    }
  }

  public static int getWeatherAnimation(int weatherCode) {
    if (weatherCode / 100 == 2) {
      return R.raw.storm_weather;
    } else if (weatherCode / 100 == 3) {
      return R.raw.rainy_weather;
    } else if (weatherCode / 100 == 5) {
      return R.raw.rainy_weather;
    } else if (weatherCode / 100 == 6) {
      return R.raw.snow_weather;
    } else if (weatherCode / 100 == 7) {
      return R.raw.unknown;
    } else if (weatherCode == 800) {
      return R.raw.clear_day;
    } else if (weatherCode == 801) {
      return R.raw.few_clouds;
    } else if (weatherCode == 803) {
      return R.raw.broken_clouds;
    } else if (weatherCode / 100 == 8) {
      return R.raw.cloudy_weather;
    }
    return R.raw.unknown;
  }


  /**
   * Check current direction of application. if is RTL return true
   *
   * @param context instance of {@link Context}
   * @return boolean value
   */
  public static boolean isRTL(Context context) {
    Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
    final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
    return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
        directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
  }

  /**
   * Network status functions.
   */

  @SuppressLint("StaticFieldLeak")
  private static Application sApplication;


  private static void init(final Application app) {
    if (sApplication == null) {
      if (app == null) {
        sApplication = getApplicationByReflect();
      } else {
        sApplication = app;
      }
    } else {
      if (app != null && app.getClass() != sApplication.getClass()) {
        sApplication = app;
      }
    }
  }

  public static Application getApp() {
    if (sApplication != null) return sApplication;
    Application app = getApplicationByReflect();
    init(app);
    return app;
  }

  private static Application getApplicationByReflect() {
    try {
      @SuppressLint("PrivateApi")
      Class<?> activityThread = Class.forName("android.app.ActivityThread");
      Object thread = activityThread.getMethod("currentActivityThread").invoke(null);
      Object app = activityThread.getMethod("getApplication").invoke(thread);
      if (app == null) {
        throw new NullPointerException("u should init first");
      }
      return (Application) app;
    } catch (NoSuchMethodException | IllegalAccessException |
        InvocationTargetException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    throw new NullPointerException("u should init first");
  }

  /**
   * If network connection is connect, return true
   *
   * @return boolean value
   */
  @RequiresPermission(ACCESS_NETWORK_STATE)
  public static boolean isNetworkConnected() {
    NetworkInfo info = getActiveNetworkInfo();
    return info != null && info.isConnected();
  }

  /**
   * Get activity network info instace
   *
   * @return instance of {@link NetworkInfo}
   */

  @RequiresPermission(ACCESS_NETWORK_STATE)
  private static NetworkInfo getActiveNetworkInfo() {
    ConnectivityManager cm =
        (ConnectivityManager) getApp().getSystemService(Context.CONNECTIVITY_SERVICE);
    if (cm == null) return null;
    return cm.getActiveNetworkInfo();
  }
}
