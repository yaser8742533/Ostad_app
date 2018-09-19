package yaser.com.ostad.application;

import android.content.Context;


public class MyGlobals {
    Context mContext;

    // constructor
    public MyGlobals(Context context) {
        this.mContext = context;
    }


   /* public static void applyFontedTab(Activity activity, ViewPager viewPager, TabLayout tabLayout) {
        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
            TextView tv = (TextView) activity.getLayoutInflater().inflate(R.layout.item_tab, null);
            if (i == viewPager.getCurrentItem()) {
                tv.setSelected(true);
            }
            tv.setText(viewPager.getAdapter().getPageTitle(i));
            tabLayout.getTabAt(i).setCustomView(tv);
        }
    }*/

}