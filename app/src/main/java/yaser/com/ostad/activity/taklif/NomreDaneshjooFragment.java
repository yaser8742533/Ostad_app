package yaser.com.ostad.activity.taklif;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import yaser.com.ostad.R;

public class NomreDaneshjooFragment extends Fragment {

    View view;
    LinearLayout ll1, ll2;
    Button moshahede;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nomre_daneshjoo, container, false);

        ll1 = view.findViewById(R.id.ll_tashih);
        ll2 = view.findViewById(R.id.ll_tashih2);
        moshahede = view.findViewById(R.id.moshahede);
        moshahede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogMessageClass cdd = new CustomDialogMessageClass(getActivity());
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
        });

        String type = getArguments().getString("type");
        if (type.equals("two")) {
            ll2.setVisibility(View.VISIBLE);

        } else if (type.equals("three")) {
            ll1.setVisibility(View.VISIBLE);
        }
        return view;
    }


}
