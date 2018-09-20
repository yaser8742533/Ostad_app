package yaser.com.ostad.activity.listdaneshjoo;


import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.R;
import yaser.com.ostad.library.RtLizerLibrary.ActionBarRtlizer;
import yaser.com.ostad.library.RtLizerLibrary.RtlizeEverything;

public class DaneshjooyanActivity extends AppCompatActivity {


    public Toolbar toolbar;
    public TextSwitcher toolbar_title;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ImageView bck;
    FragmentManager fm;
    Fragment daneshjoo;
    Button btn1, btn2, btn3, btn_all;
    DaneshjooyanActivity _this = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daneshjoo);
        init();
        createLayout();
        click();
    }

    void init() {

        toolbar = findViewById(R.id.daneshjoo_toolbar);
        bck = findViewById(R.id.bck);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn_all = findViewById(R.id.btn4);
        toolbar_title = findViewById(R.id.title_toolbar);

    }

    void click() {
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_daneshjooyan("one");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_daneshjooyan("one");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_daneshjooyan("one");
            }
        });
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_daneshjooyan("all");
            }
        });
    }

    void show_daneshjooyan(String type) {
        fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        daneshjoo = new DaneshjooyanFragment();
        daneshjoo.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.daneshjooyan_frame, daneshjoo, "daneshjoo");
        fragmentTransaction.addToBackStack("daneshjoo");
        fragmentTransaction.commit();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private void createLayout() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarRtlizer rtlizer = new ActionBarRtlizer(this, String.valueOf(R.id.daneshjoo_toolbar));
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
        toolbar_title.setText("لیست دانشجویان");


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
