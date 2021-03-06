package yaser.com.ostad.activity.azmoon.viewpager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yaser.com.ostad.R;
import yaser.com.ostad.activity.azmoon.AzmoonActivity;

public class AzmoonNadadeAdapter extends RecyclerView.Adapter<AzmoonNadadeAdapter.ViewHolder> {

    AzmoonActivity context;
    View itemView;
    ArrayList<Integer> arrayList;

    public AzmoonNadadeAdapter(AzmoonActivity context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.azmoon_nadade_listitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {
            super(view);


        }
    }
}


