package yaser.com.ostad.activity.main;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.R;
import yaser.com.ostad.activity.azmoon.AzmoonActivity;
import yaser.com.ostad.activity.listdaneshjoo.DaneshjooyanActivity;
import yaser.com.ostad.activity.message.MessageActivity;
import yaser.com.ostad.activity.profile.ProfileActivity;
import yaser.com.ostad.library.RtLizerLibrary.ActionBarRtlizer;
import yaser.com.ostad.library.RtLizerLibrary.RtlizeEverything;

public class MainActivity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 1500;
    ConstraintLayout container;
    FragmentManager fm;
    ImageView takalif, azmoon, payam, vaziat, daneshjoo, img_title;
    MainActivity _this = this;
    Fragment splash, phone, login;
    Boolean doubleBackToExitPressedOnce = false;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    TextView tv_profile, tv_payam, tv_takalif, tv_azmoon, tv_daneshjoo, tv_share, tv_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        show_splash();
        glide();
        createLayout();
        click();
        drawer_click();
    }

    void init() {
        takalif = findViewById(R.id.img_takalif);
        azmoon = findViewById(R.id.img_azmoon);
        payam = findViewById(R.id.img_payam);
        vaziat = findViewById(R.id.img_vaziat);
        daneshjoo = findViewById(R.id.img_daneshjoo);
        img_title = findViewById(R.id.img_title_menu);
        container = findViewById(R.id.frame_main);
        toolbar = findViewById(R.id.main_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        ///drawer
        tv_profile = findViewById(R.id.tv_profile);
        tv_payam = findViewById(R.id.tv_payam);
        tv_takalif = findViewById(R.id.tv_takalif);
        tv_azmoon = findViewById(R.id.tv_azmoonha);
        tv_daneshjoo = findViewById(R.id.tv_daneshjooyan);
        tv_share = findViewById(R.id.tv_share);
        tv_about = findViewById(R.id.tv_about);

    }

    void glide() {


        Glide.with(_this).load(R.drawable.topright).into(takalif);
        Glide.with(_this).load(R.drawable.topleft).into(azmoon);
        Glide.with(_this).load(R.drawable.center).into(payam);
        Glide.with(_this).load(R.drawable.bottomright).into(vaziat);
        Glide.with(_this).load(R.drawable.bottomleft).into(daneshjoo);
        Glide.with(_this).load(R.drawable.img_viewpager_main).into(img_title);
    }

    void show_splash() {

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        splash = new SplashFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.frame_main, splash);
        fragmentTransaction.commit();

        runOnUiThread(new Runnable() {
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        show_phone();
                    }
                }, SPLASH_DISPLAY_LENGTH);
            }
        });
    }

    void show_phone() {
        phone = new PhoneFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit, R.animator.enter, R.animator.exit);
        fragmentTransaction.replace(R.id.frame_main, phone, "phone");
        fragmentTransaction.commit();
    }


    public void show_login() {
        login = new LoginFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit, R.animator.enter, R.animator.exit);
        fragmentTransaction.replace(R.id.frame_main, login, "login");
        fragmentTransaction.commit();
    }

    public void close_login() {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.remove(login);
        fragmentTransaction.commit();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    void click() {
        azmoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(_this, AzmoonActivity.class);
                startActivity(myIntent);
            }
        });

        daneshjoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(_this, DaneshjooyanActivity.class);
                startActivity(myIntent);
            }
        });

        payam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(_this, MessageActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    private void createLayout() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarRtlizer rtlizer = new ActionBarRtlizer(this, String.valueOf(R.id.main_toolbar));
        ViewGroup homeView = (ViewGroup) rtlizer.getHomeView();
        RtlizeEverything.rtlize(rtlizer.getActionBarView());
        if (rtlizer.getHomeViewContainer() instanceof ViewGroup) {
            RtlizeEverything.rtlize((ViewGroup) rtlizer.getHomeViewContainer());
        }
        RtlizeEverything.rtlize(homeView);

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

    }

    void drawer_click() {
        tv_azmoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
                Intent myIntent = new Intent(_this, AzmoonActivity.class);
                startActivity(myIntent);
            }
        });

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

    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            if (count == 0) {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                }
                doubleBackToExitPressedOnce = true;
                Snackbar snackbar = Snackbar.make(container, "برای خروج از برنامه ، دوباره کلیک کنید", Snackbar.LENGTH_SHORT);
                snackbar.show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);

            } else {
                getSupportFragmentManager().popBackStack();
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }
        }
    }
}
