package com.example.log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{
    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
holder.dname.setText(dataholder.get(position).getName());
        holder.daddress.setText(dataholder.get(position).getAddress());
        holder.ddate.setText(dataholder.get(position).getDate());
        holder.dtype.setText(dataholder.get(position).getType());
        holder.dcmp.setText(dataholder.get(position).getComp());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
    TextView dname,daddress,ddate,dtype,dcmp;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dname=(TextView)itemView.findViewById(R.id.displayname);
            daddress=(TextView)itemView.findViewById(R.id.displayaddress);
            ddate=(TextView)itemView.findViewById(R.id.displaydate);
            dtype=(TextView)itemView.findViewById(R.id.displaytype);
            dcmp=(TextView)itemView.findViewById(R.id.displaycmp);
        }
    }

}
