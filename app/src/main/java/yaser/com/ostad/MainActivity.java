package yaser.com.ostad;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 1500;
    FragmentManager fm;
    ImageView takalif, azmoon, payam, vaziat, daneshjoo, img_title;
    MainActivity _this = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        show_splash();
        glide();
    }

    void init() {
        takalif = findViewById(R.id.img_takalif);
        azmoon = findViewById(R.id.img_azmoon);
        payam = findViewById(R.id.img_payam);
        vaziat = findViewById(R.id.img_vaziat);
        daneshjoo = findViewById(R.id.img_daneshjoo);
        img_title = findViewById(R.id.img_title_menu);

    }

    void glide() {


        /*Glide.with(_this).load("").apply(new RequestOptions().placeholder(getImage("topright"))).into(takalif);
        Glide.with(_this).load(R.drawable.topleft).into(azmoon);
        Glide.with(_this).load(getImage("center")).into(payam);
        Glide.with(_this).load(getImage("bottomright")).into(vaziat);
        Glide.with(_this).load(getImage("bottomleft")).into(daneshjoo);
        Glide.with(_this).load(getImage("img_viewpager_main")).into(img_title);*/
    }

    void show_splash() {

        setContentView(R.layout.activity_main);
        Fragment splash;
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
        Fragment phone;
        phone = new PhoneFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.enter, R.animator.exit, R.animator.enter, R.animator.exit);
        fragmentTransaction.replace(R.id.frame_main, phone, "phone");
        fragmentTransaction.commit();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public int getImage(String imageName) {
        int drawableResourceId = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
        return drawableResourceId;
    }

}
