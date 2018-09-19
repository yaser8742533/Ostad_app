package yaser.com.ostad.activity.listdaneshjoo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import yaser.com.ostad.R;

public class DaneshjooyanFragment extends Fragment {

    RecyclerView recyclerView;
    TextView tv_title;
    ArrayList<Integer> detailsList = new ArrayList<>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daneshjooyan, container, false);

        init();
        getdata();
        return view;
    }


    void init() {
        recyclerView = view.findViewById(R.id.rcl_daneshjooyan);
        tv_title = view.findViewById(R.id.tv_title1);
    }

    void getdata() {
        String type = getArguments().getString("type");
        if (type.equals("one")) {
            set_data1();
            tv_title.setText(getResources().getString(R.string.title1));
        } else if (type.equals("all")) {
            set_data2();
            tv_title.setText(getResources().getString(R.string.title2));
        }
    }

    void set_data1() {
        detailsList.clear();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        DaneshjooyanAdapter adapter = new DaneshjooyanAdapter((DaneshjooyanActivity) getActivity(), detailsList);
        recyclerView.setAdapter(adapter);


        for (int i = 0; i < 15; i++) {

            detailsList.add(i);
            adapter.notifyDataSetChanged();

        }
        adapter.notifyDataSetChanged();


    }

    void set_data2() {
        detailsList.clear();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        DaneshjooyanAdapter adapter = new DaneshjooyanAdapter((DaneshjooyanActivity) getActivity(), detailsList);
        recyclerView.setAdapter(adapter);


        for (int i = 0; i < 45; i++) {

            detailsList.add(i);
            adapter.notifyDataSetChanged();

        }
        adapter.notifyDataSetChanged();


    }


}
