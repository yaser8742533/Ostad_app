package yaser.com.ostad.activity.message;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import yaser.com.ostad.R;

public class PayamAdapter extends RecyclerView.Adapter<PayamAdapter.ViewHolder> {

    PayamActivity context;
    View itemView;
    ArrayList<Integer> arrayList;

    public PayamAdapter(PayamActivity context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.payam_listitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        if (position == 0) {
            holder.rl_title.setBackgroundColor(context.getResources().getColor(R.color.red));
            holder.title.append(" - جدید");
        }

        holder.moshahede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, MessageActivity.class);
                context.startActivity(myIntent);
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
        TextView title;
        RelativeLayout rl_title;


        public ViewHolder(View view) {
            super(view);
            moshahede = view.findViewById(R.id.moshahede);
            title = view.findViewById(R.id.tv_title_payam);
            rl_title = view.findViewById(R.id.rl_title_payam);


        }
    }
}


