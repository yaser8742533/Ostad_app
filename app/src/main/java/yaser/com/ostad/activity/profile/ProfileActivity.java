package yaser.com.ostad.activity.profile;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.R;
import yaser.com.ostad.activity.azmoon.AzmoonActivity;
import yaser.com.ostad.activity.listdaneshjoo.DaneshjooyanActivity;
import yaser.com.ostad.activity.message.PayamActivity;
import yaser.com.ostad.activity.taklif.TaklifActivity;
import yaser.com.ostad.library.RtLizerLibrary.ActionBarRtlizer;
import yaser.com.ostad.library.RtLizerLibrary.RtlizeEverything;

public class ProfileActivity extends AppCompatActivity {


    public Toolbar toolbar;
    TextSwitcher toolbar_title;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ImageView bck, img1;
    ProfileActivity _this = this;
    Button all;
    TextView tv_profile, tv_payam, tv_takalif, tv_azmoon, tv_daneshjoo, tv_share, tv_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
        createLayout();
        drawer_click();
        click();
    }

    void init() {

        toolbar = findViewById(R.id.profile_toolbar);
        toolbar_title = findViewById(R.id.title_toolbar);
        bck = findViewById(R.id.bck);
        all = findViewById(R.id.see_all);
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

    void drawer_click() {

        Glide.with(_this).load(R.drawable.man).into(img1);

        tv_profile.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
        tv_profile.setEnabled(false);

        tv_azmoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
                Intent myIntent = new Intent(_this, AzmoonActivity.class);
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

    void click() {
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(_this, DaneshjooyanActivity.class);
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

        ActionBarRtlizer rtlizer = new ActionBarRtlizer(this, String.valueOf(R.id.profile_toolbar));
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
        toolbar_title.setText("پروفایل من");

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
                getSupportFragmentManager().popBackStack();
            }
        }
    }
}
