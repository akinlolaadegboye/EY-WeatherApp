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

//import com.github.bkhezry.weather.R;
//import com.github.bkhezry.weather.listener.OnSetApiKeyEventListener;
//import com.github.pwittchen.prefser.library.rx2.Prefser;

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
//
//
//  /**
//   * Set text of textView with html format of html parameter
//   *
//   * @param textView instance {@link TextView}
//   * @param html     String
//   */
//  @SuppressLint("ClickableViewAccessibility")
//  public static void setTextWithLinks(TextView textView, CharSequence html) {
//    textView.setText(html);
//    textView.setOnTouchListener(new View.OnTouchListener() {
//      @Override
//      public boolean onTouch(View v, MotionEvent event) {
//        int action = event.getAction();
//        if (action == MotionEvent.ACTION_UP ||
//            action == MotionEvent.ACTION_DOWN) {
//          int x = (int) event.getX();
//          int y = (int) event.getY();
//
//          TextView widget = (TextView) v;
//          x -= widget.getTotalPaddingLeft();
//          y -= widget.getTotalPaddingTop();
//
//          x += widget.getScrollX();
//          y += widget.getScrollY();
//
//          Layout layout = widget.getLayout();
//          int line = layout.getLineForVertical(y);
//          int off = layout.getOffsetForHorizontal(line, x);
//
//          ClickableSpan[] link = Spannable.Factory.getInstance()
//              .newSpannable(widget.getText())
//              .getSpans(off, off, ClickableSpan.class);
//
//          if (link.length != 0) {
//            if (action == MotionEvent.ACTION_UP) {
//              link[0].onClick(widget);
//            }
//            return true;
//          }
//        }
//        return false;
//      }
//    });
//  }
//
//  /**
//   * Change string to html format
//   *
//   * @param htmlText String text
//   * @return String text
//   */
//  public static CharSequence fromHtml(String htmlText) {
//    if (TextUtils.isEmpty(htmlText)) {
//      return null;
//    }
//    CharSequence spanned;
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//      spanned = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY);
//    } else {
//      spanned = Html.fromHtml(htmlText);
//    }
//    return trim(spanned);
//  }
//
//  /**
//   * Trim string text
//   *
//   * @param charSequence String text
//   * @return String text
//   */
//
//  private static CharSequence trim(CharSequence charSequence) {
//    if (TextUtils.isEmpty(charSequence)) {
//      return charSequence;
//    }
//    int end = charSequence.length() - 1;
//    while (Character.isWhitespace(charSequence.charAt(end))) {
//      end--;
//    }
//    return charSequence.subSequence(0, end + 1);
//  }
//
//  /**
//   * Check version of SDK
//   *
//   * @param version int SDK version
//   * @return boolean value
//   */
//  static boolean isAtLeastVersion(int version) {
//    return Build.VERSION.SDK_INT >= version;
//  }

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

//  /**
//   * Determine if the navigation bar will be on the bottom of the screen, based on logic in
//   * PhoneWindowManager.
//   */
//  static boolean isNavBarOnBottom(@NonNull Context context) {
//    final Resources res = context.getResources();
//    final Configuration cfg = context.getResources().getConfiguration();
//    final DisplayMetrics dm = res.getDisplayMetrics();
//    boolean canMove = (dm.widthPixels != dm.heightPixels &&
//        cfg.smallestScreenWidthDp < 600);
//    return (!canMove || dm.widthPixels < dm.heightPixels);
//  }
//
//  static Interpolator getFastOutSlowInInterpolator(Context context) {
//    if (fastOutSlowIn == null) {
//      fastOutSlowIn = AnimationUtils.loadInterpolator(context,
//          android.R.interpolator.fast_out_slow_in);
//    }
//    return fastOutSlowIn;
//  }
//
//  /**
//   * Set the alpha component of {@code color} to be {@code alpha}.
//   */
//  static @CheckResult
//  @ColorInt
//  int modifyAlpha(@ColorInt int color,
//                  @IntRange(from = 0, to = 255) int alpha) {
//    return (color & 0x00ffffff) | (alpha << 24);
//  }
//
//  /**
//   * Set the alpha component of {@code color} to be {@code alpha}.
//   */
//  public static @CheckResult
//  @ColorInt
//  int modifyAlpha(@ColorInt int color,
//                  @FloatRange(from = 0f, to = 1f) float alpha) {
//    return modifyAlpha(color, (int) (255f * alpha));
//  }
}
