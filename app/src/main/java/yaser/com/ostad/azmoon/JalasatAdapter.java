package yaser.com.ostad.azmoon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import yaser.com.ostad.R;

public class JalasatAdapter extends RecyclerView.Adapter<JalasatAdapter.ViewHolder> {

    AzmoonActivity context;
    View itemView;
    ArrayList<Integer> arrayList;

    public JalasatAdapter(AzmoonActivity context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.jalasat_listitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.moshahede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.show_azmoon();
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


        public ViewHolder(View view) {
            super(view);
            moshahede = view.findViewById(R.id.moshahede);


        }
    }
}


