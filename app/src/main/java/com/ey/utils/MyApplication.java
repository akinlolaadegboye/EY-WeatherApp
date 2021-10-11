package com.ey.utils;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import com.ey.R;

public class MyApplication extends Application {
  @Override
  public void onCreate() {
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    super.onCreate();
    ViewPump.init(ViewPump.builder()
        .addInterceptor(new CalligraphyInterceptor(
            new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Vazir.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()))
        .build());
  }
}
