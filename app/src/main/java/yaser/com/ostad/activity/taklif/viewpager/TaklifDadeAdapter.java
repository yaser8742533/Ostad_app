package yaser.com.ostad.activity.taklif.viewpager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import yaser.com.ostad.R;
import yaser.com.ostad.activity.taklif.TaklifActivity;

public class TaklifDadeAdapter extends RecyclerView.Adapter<TaklifDadeAdapter.ViewHolder> {

    TaklifActivity context;
    View itemView;
    ArrayList<Integer> arrayList;

    public TaklifDadeAdapter(TaklifActivity context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.taklif_dade_listitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (position >= 5) {
            holder.moshahede.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryLight));
            holder.moshahede.setText("مشاهده نمره");
        } else {
            holder.moshahede.setText("مشاهده پاسخ");
            holder.moshahede.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }
        if (position >= 9) {
            holder.alert.setVisibility(View.VISIBLE);
        }

        holder.moshahede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


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

        Button moshahede;
        ImageView alert;


        public ViewHolder(View view) {
            super(view);
            moshahede = view.findViewById(R.id.moshahede);
            alert = view.findViewById(R.id.img_alert);


        }
    }
}


