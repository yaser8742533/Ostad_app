package yaser.com.ostad.activity.taklif;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yaser.com.ostad.R;
import yaser.com.ostad.activity.taklif.viewpager.TaklifViewPagerAdapter;
import yaser.com.ostad.application.MyGlobals;

public class TaklifFragment extends Fragment {

    public ViewPager viewPager;
    TabLayout tabLayout;
    LinearLayoutManager mLayoutManager;
    ArrayList<Integer> detailsList = new ArrayList<>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_azmoon, container, false);

        init();
        viewpager();
        return view;
    }


    void init() {

        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);
        mLayoutManager = new LinearLayoutManager(getActivity());

    }

    void viewpager() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        TaklifViewPagerAdapter viewPagerAdapter = new TaklifViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        MyGlobals.applyFontedTab(getActivity(), viewPager, tabLayout);

        viewPager.setCurrentItem(1);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

}
