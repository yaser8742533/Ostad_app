package yaser.com.ostad.application;

import android.app.Application;
import android.content.Context;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import yaser.com.ostad.R;

public class ApplicationClass extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/IRANSansMobileNumber.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

        context = getApplicationContext();

    }
}
