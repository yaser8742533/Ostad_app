package yaser.com.ostad.activity.azmoon;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.R;
import yaser.com.ostad.activity.listdaneshjoo.DaneshjooyanActivity;
import yaser.com.ostad.activity.message.PayamActivity;
import yaser.com.ostad.activity.profile.ProfileActivity;
import yaser.com.ostad.activity.taklif.TaklifActivity;
import yaser.com.ostad.library.RtLizerLibrary.ActionBarRtlizer;
import yaser.com.ostad.library.RtLizerLibrary.RtlizeEverything;

public class AzmoonActivity extends AppCompatActivity {


    public Toolbar toolbar;
    public TextSwitcher toolbar_title;
    FragmentManager fm;
    AzmoonActivity _this = this;
    Fragment dore_ha, jalasat, azmoon, daneshjoo;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ImageView bck, img1;
    TextView tv_profile, tv_payam, tv_takalif, tv_azmoon, tv_daneshjoo, tv_share, tv_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azmoon);
        init();
        createLayout();
        show_dore_ha();
        drawer_click();
        click();
    }

    void init() {

        toolbar = findViewById(R.id.azmoon_toolbar);
        toolbar_title = findViewById(R.id.title_toolbar);
        bck = findViewById(R.id.bck);

        ///drawer
        tv_profile = findViewById(R.id.tv_profile);
        tv_payam = findViewById(R.id.tv_payam);
        tv_takalif = findViewById(R.id.tv_takalif);
        tv_azmoon = findViewById(R.id.tv_azmoonha);
        tv_daneshjoo = findViewById(R.id.tv_daneshjooyan);
        tv_share = findViewById(R.id.tv_share);
        tv_about = findViewById(R.id.tv_about);
        img1 = findViewById(R.id.img1);
    }

    void click() {
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    void show_dore_ha() {

        dore_ha = new DoreHaFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.frame_azmoon, dore_ha);
        fragmentTransaction.commit();

    }

    void show_jalasat() {
        jalasat = new JalasatFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.frame_azmoon, jalasat, "jalasat");
        fragmentTransaction.addToBackStack("jalasat");
        fragmentTransaction.commit();
    }

    public void show_azmoon() {
        azmoon = new AzmoonFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.frame_azmoon, azmoon, "azmoon");
        fragmentTransaction.addToBackStack("azmoon");
        fragmentTransaction.commit();
    }

    public void show_daneshjoo() {

        toolbar_title.setText("نام دانشجو");
        daneshjoo = new AzmoonDaneshjooFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.frame_azmoon, daneshjoo, "daneshjoo");
        fragmentTransaction.addToBackStack("daneshjoo");
        fragmentTransaction.commit();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    void drawer_click() {

        Glide.with(_this).load(R.drawable.man).into(img1);

        tv_azmoon.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
        tv_azmoon.setEnabled(false);

        tv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
                Intent myIntent = new Intent(_this, ProfileActivity.class);
                startActivity(myIntent);
            }
        });

        tv_daneshjoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
                Intent myIntent = new Intent(_this, DaneshjooyanActivity.class);
                startActivity(myIntent);
            }
        });
        tv_payam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
                Intent myIntent = new Intent(_this, PayamActivity.class);
                startActivity(myIntent);
            }
        });
        tv_takalif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
                Intent myIntent = new Intent(_this, TaklifActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void createLayout() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarRtlizer rtlizer = new ActionBarRtlizer(this, String.valueOf(R.id.azmoon_toolbar));
        ViewGroup homeView = (ViewGroup) rtlizer.getHomeView();
        RtlizeEverything.rtlize(rtlizer.getActionBarView());
        if (rtlizer.getHomeViewContainer() instanceof ViewGroup) {
            RtlizeEverything.rtlize((ViewGroup) rtlizer.getHomeViewContainer());
        }
        RtlizeEverything.rtlize(homeView);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @SuppressLint("RtlHardcoded")
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                return false;
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        toolbar_title.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(_this);
                TextView textView = (TextView) inflater.inflate(R.layout.textswitcher_textview, null);
                return textView;
            }
        });

        Animation inAnim = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation outAnim = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        inAnim.setDuration(500);
        outAnim.setDuration(500);
        toolbar_title.setInAnimation(inAnim);
        toolbar_title.setOutAnimation(outAnim);
        toolbar_title.setText("آزمون ها");
    }


    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            if (count == 0) {
                super.onBackPressed();
            } else {
                if (count == 3) {
                    toolbar_title.setText("آزمون ها");
                }
                getSupportFragmentManager().popBackStack();
            }
        }
    }
}
