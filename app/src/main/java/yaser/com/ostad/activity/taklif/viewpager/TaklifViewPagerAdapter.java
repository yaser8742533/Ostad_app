package yaser.com.ostad.activity.taklif.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TaklifViewPagerAdapter extends FragmentStatePagerAdapter {

    public TaklifViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new TaklifNadadeFragment();
        } else if (position == 1) {
            fragment = new TaklifDadeFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "تکلیف انجام نداده ها";
        } else if (position == 1) {
            title = "تکلیف انجام داده ها";
        }
        return title;
    }
}
