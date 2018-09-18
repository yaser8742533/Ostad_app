package yaser.com.ostad.activity.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import yaser.com.ostad.R;


public class SplashFragment extends Fragment {

    ImageView bg_splash, ic_splash, title_splash;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        bg_splash = view.findViewById(R.id.bg_splash);
        ic_splash = view.findViewById(R.id.ic_splash);
        title_splash = view.findViewById(R.id.title_splash);

        Glide.with(this).load(getImage("bg_splash")).into(bg_splash);
        Glide.with(this).load(getImage("ic_splash")).into(ic_splash);
        Glide.with(this).load(getImage("title_splash")).into(title_splash);

        return view;
    }

    public int getImage(String imageName) {

        int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());

        return drawableResourceId;
    }
}