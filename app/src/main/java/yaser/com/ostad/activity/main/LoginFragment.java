package yaser.com.ostad.activity.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import yaser.com.ostad.R;


public class LoginFragment extends Fragment {

    ImageView bg_login;
    Button confirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        bg_login = view.findViewById(R.id.bg_login);
        confirm = view.findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).close_login();
            }
        });

        Glide.with(this).load(R.drawable.bg_login).into(bg_login);

        return view;
    }

}