package yaser.com.ostad.application;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import yaser.com.ostad.R;


public class MyGlobals {
    Context mContext;

    // constructor
    public MyGlobals(Context context) {
        this.mContext = context;
    }


    public static void applyFontedTab(Activity activity, ViewPager viewPager, TabLayout tabLayout) {
        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
            TextView tv = (TextView) activity.getLayoutInflater().inflate(R.layout.item_tab, null);
            if (i == viewPager.getCurrentItem()) {
                tv.setSelected(true);
            }
            tv.setText(viewPager.getAdapter().getPageTitle(i));
            tabLayout.getTabAt(i).setCustomView(tv);
        }
    }

}