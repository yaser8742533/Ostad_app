package yaser.com.ostad.activity.main;


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
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.glide.slider.library.Animations.DescriptionAnimation;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.SliderTypes.TextSliderView;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.R;
import yaser.com.ostad.activity.azmoon.AzmoonActivity;
import yaser.com.ostad.activity.listdaneshjoo.DaneshjooyanActivity;
import yaser.com.ostad.activity.message.PayamActivity;
import yaser.com.ostad.activity.profile.ProfileActivity;
import yaser.com.ostad.activity.taklif.TaklifActivity;
import yaser.com.ostad.activity.vaziat.VaziatActivity;

public class MainActivity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 1500;
    ConstraintLayout container;
    FragmentManager fm;
    ImageView takalif, azmoon, payam, vaziat, daneshjoo, img1;
    MainActivity _this = this;
    Fragment splash, phone, login;
    Boolean doubleBackToExitPressedOnce = false;
    DrawerLayout drawerLayout;
    TextView tv_profile, tv_payam, tv_takalif, tv_azmoon, tv_daneshjoo, tv_share, tv_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        show_splash();
        glide();
        sliderinit();
        click();
        drawer_click();
    }

    void init() {
        takalif = findViewById(R.id.img_takalif);
        azmoon = findViewById(R.id.img_azmoon);
        payam = findViewById(R.id.img_payam);
        vaziat = findViewById(R.id.img_vaziat);
        daneshjoo = findViewById(R.id.img_daneshjoo);
        container = findViewById(R.id.frame_main);
        drawerLayout = findViewById(R.id.drawer_layout);

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

    void glide() {


        Glide.with(_this).load(R.drawable.topright).into(takalif);
        Glide.with(_this).load(R.drawable.topleft).into(azmoon);
        Glide.with(_this).load(R.drawable.center).into(payam);
        Glide.with(_this).load(R.drawable.bottomright).into(vaziat);
        Glide.with(_this).load(R.drawable.bottomleft).into(daneshjoo);
        Glide.with(_this).load(R.drawable.man).into(img1);
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
                Intent myIntent = new Intent(_this, PayamActivity.class);
                startActivity(myIntent);
            }
        });
        vaziat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(_this, VaziatActivity.class);
                startActivity(myIntent);
            }
        });
        takalif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(_this, TaklifActivity.class);
                startActivity(myIntent);
            }
        });
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
    void sliderinit() {
        SliderLayout sliderLayout = findViewById(R.id.slider);

        TextSliderView sliderView = new TextSliderView(this);

        // initialize SliderLayout
        sliderView
                .image(R.drawable.img_viewpager_main)
                .description("متن تست")
                .setBackgroundColor(getResources().getColor(R.color.colorPrimary))
                .setProgressBarVisible(true);

        //add your extra information
        sliderView.bundle(new Bundle());
        sliderView.getBundle().putString("extra", "متن ساختگی میباشد");
        sliderLayout.addSlider(sliderView);

        TextSliderView sliderView2 = new TextSliderView(this);

        // initialize SliderLayout
        sliderView2
                .image(R.drawable.no_title)
                .setBackgroundColor(getResources().getColor(R.color.colorPrimary))
                .description("متن تست")
                .setProgressBarVisible(true);

        //add your extra information
        sliderView2.bundle(new Bundle());
        sliderView2.getBundle().putString("extra", "متن ساختگی میباشد");
        sliderLayout.addSlider(sliderView2);

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Fade);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
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
