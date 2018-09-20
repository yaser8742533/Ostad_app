package yaser.com.ostad.activity.taklif;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yaser.com.ostad.R;

public class DoreHaTaklifFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Integer> detailsList = new ArrayList<>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dore_ha, container, false);

        init();
        set_data();
        return view;
    }


    void init() {
        recyclerView = view.findViewById(R.id.rcl_dore_ha);
    }

    void set_data() {
        detailsList.clear();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        DoreHaTaklifAdapter adapter = new DoreHaTaklifAdapter((TaklifActivity) getActivity(), detailsList);
        recyclerView.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {

            detailsList.add(i);
            adapter.notifyDataSetChanged();

        }
        adapter.notifyDataSetChanged();


    }


}
