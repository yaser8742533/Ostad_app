package yaser.com.ostad;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.azmoon.AzmoonActivity;

public class MainActivity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 1500;
    ConstraintLayout container;
    FragmentManager fm;
    ImageView takalif, azmoon, payam, vaziat, daneshjoo, img_title;
    MainActivity _this = this;
    Fragment splash, phone, login;
    Boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        show_splash();
        glide();
        click();
    }

    void init() {
        takalif = findViewById(R.id.img_takalif);
        azmoon = findViewById(R.id.img_azmoon);
        payam = findViewById(R.id.img_payam);
        vaziat = findViewById(R.id.img_vaziat);
        daneshjoo = findViewById(R.id.img_daneshjoo);
        img_title = findViewById(R.id.img_title_menu);
        container = findViewById(R.id.frame_main);

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
    }

    void click() {
        azmoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(_this, AzmoonActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {

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

    }
}
