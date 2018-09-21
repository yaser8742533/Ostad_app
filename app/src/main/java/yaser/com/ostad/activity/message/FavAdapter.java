package yaser.com.ostad.activity.message;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import yaser.com.ostad.R;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    PayamActivity context;
    View itemView;
    ArrayList<Integer> arrayList;

    public FavAdapter(PayamActivity context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_listitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        Glide.with(context).load(R.drawable.garbage).into(holder.garbage);
        holder.garbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogDeleteClass cdd = new CustomDialogDeleteClass(context);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
        });


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
        ImageView garbage;


        public ViewHolder(View view) {
            super(view);
            moshahede = view.findViewById(R.id.moshahede);
            garbage = view.findViewById(R.id.img_garbage);


        }
    }

}


