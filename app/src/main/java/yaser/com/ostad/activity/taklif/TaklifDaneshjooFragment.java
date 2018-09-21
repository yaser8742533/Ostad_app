package yaser.com.ostad.activity.taklif;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yaser.com.ostad.R;

public class TaklifDaneshjooFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_taklif_daneshjoo, container, false);


        return view;
    }


}
