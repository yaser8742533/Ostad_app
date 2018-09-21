package yaser.com.ostad.activity.taklif;


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
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.R;
import yaser.com.ostad.library.RtLizerLibrary.ActionBarRtlizer;
import yaser.com.ostad.library.RtLizerLibrary.RtlizeEverything;

public class TaklifActivity extends AppCompatActivity {


    public Toolbar toolbar;
    public TextSwitcher toolbar_title;
    FragmentManager fm;
    TaklifActivity _this = this;
    Fragment dore_ha, jalasat, taklif, daneshjoo1, daneshjoo2;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ImageView bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taklif);
        init();
        createLayout();
        show_dore_ha();
        click();
    }

    void init() {

        toolbar = findViewById(R.id.taklif_toolbar);
        toolbar_title = findViewById(R.id.title_toolbar);
        bck = findViewById(R.id.bck);

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

        dore_ha = new DoreHaTaklifFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.frame_taklif, dore_ha);
        fragmentTransaction.commit();

    }

    void show_jalasat() {
        jalasat = new JalasatTaklifFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.frame_taklif, jalasat, "jalasat");
        fragmentTransaction.addToBackStack("jalasat");
        fragmentTransaction.commit();
    }

    public void show_taklif() {
        taklif = new TaklifFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.frame_taklif, taklif, "taklif");
        fragmentTransaction.addToBackStack("taklif");
        fragmentTransaction.commit();
    }

    public void show_daneshjoo1() {
        toolbar_title.setText("نام دانشجو");
        daneshjoo1 = new TaklifDaneshjooFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.frame_taklif, daneshjoo1, "daneshjoo1");
        fragmentTransaction.addToBackStack("daneshjoo1");
        fragmentTransaction.commit();
    }

    public void show_daneshjoo2(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        toolbar_title.setText("نام دانشجو");
        daneshjoo2 = new NomreDaneshjooFragment();
        daneshjoo2.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
        fragmentTransaction.add(R.id.frame_taklif, daneshjoo2, "daneshjoo2");
        fragmentTransaction.addToBackStack("daneshjoo2");
        fragmentTransaction.commit();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private void createLayout() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarRtlizer rtlizer = new ActionBarRtlizer(this, String.valueOf(R.id.taklif_toolbar));
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
        toolbar_title.setText("تکالیف");
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
                    toolbar_title.setText("تکالیف");
                }
                getSupportFragmentManager().popBackStack();
            }
        }
    }
}
