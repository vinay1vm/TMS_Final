package com.example.tms_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<VModel> arrayList;
    Context context;

    public Adapter(ArrayList<VModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.visitorlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VModel model=arrayList.get(position);

        holder.id.setText(model.getVisitor_Id());
        holder.name.setText(model.getGuest_full_name());
        holder.time.setText(model.getGuest_Time());
        holder.date.setText(model.getGuest_Date());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView id,name,date,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.txtid);
            name=itemView.findViewById(R.id.txtname);
            date=itemView.findViewById(R.id.txtdate);
            time=itemView.findViewById(R.id.txttime);

        }
    }
}
