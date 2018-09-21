package yaser.com.ostad.activity.message;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import yaser.com.ostad.R;
import yaser.com.ostad.library.RtLizerLibrary.ActionBarRtlizer;
import yaser.com.ostad.library.RtLizerLibrary.RtlizeEverything;

public class PayamActivity extends AppCompatActivity {


    public Toolbar toolbar;
    public TextSwitcher toolbar_title;
    FragmentManager fm;
    ArrayList<Integer> detailsList = new ArrayList<>();
    PayamActivity _this = this;
    Fragment list, fav;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    RecyclerView recyclerView;
    ImageView bck;
    TextView fav_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payam);
        init();
        createLayout();
        set_data();
        click();
    }

    void init() {

        toolbar = findViewById(R.id.payam_toolbar);
        toolbar_title = findViewById(R.id.title_toolbar);
        bck = findViewById(R.id.bck);
        recyclerView = findViewById(R.id.rcl_payam);
        fav_tv = findViewById(R.id.fav_tv);

    }

    void click() {
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        fav_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar_title.setText("پیام های انتخاب شده");
                fm = getSupportFragmentManager();
                Fragment fav = new FavFragment();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit_to_right, R.animator.enter, R.animator.exit_to_right);
                fragmentTransaction.add(R.id.frame_payam, fav, "fav");
                fragmentTransaction.addToBackStack("fav");
                fragmentTransaction.commit();
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

        ActionBarRtlizer rtlizer = new ActionBarRtlizer(this, String.valueOf(R.id.payam_toolbar));
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
        toolbar_title.setText("پیام ها");
    }

    void set_data() {
        detailsList.clear();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(_this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        PayamAdapter adapter = new PayamAdapter(_this, detailsList);
        recyclerView.setAdapter(adapter);


        for (int i = 0; i < 3; i++) {

            detailsList.add(i);
            adapter.notifyDataSetChanged();

        }
        adapter.notifyDataSetChanged();


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
                if (count == 1) {
                    toolbar_title.setText("پیام ها");
                }
                getSupportFragmentManager().popBackStack();
            }
        }
    }
}
