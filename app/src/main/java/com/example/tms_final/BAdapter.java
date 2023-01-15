package com.example.tms_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BAdapter  extends RecyclerView.Adapter<BAdapter.ViewHolder> {

    ArrayList<Bmodel> arrayList;
    Context context;

    public BAdapter(ArrayList<Bmodel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.blist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bmodel bmodel=arrayList.get(position);
        holder.bamotnt.setText(bmodel.getAmount());
        holder.bdescription.setText(bmodel.getB_description());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView bamotnt, bdescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bamotnt = itemView.findViewById(R.id.bamt);
            bdescription = itemView.findViewById(R.id.bdesc);
          //  itemView.setOnClickListener(this);
        }
    }
}


