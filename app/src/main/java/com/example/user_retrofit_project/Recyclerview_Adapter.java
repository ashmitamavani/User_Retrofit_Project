package com.example.user_retrofit_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {
    MainActivity mainActivity;
    ArrayList<Model_class> modeList;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Model_class> modeList) {
        this.mainActivity=mainActivity;
        this.modeList=modeList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item_file,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(""+modeList.get(position).getName());
        holder.username.setText(""+modeList.get(position).getUsername());
        holder.city.setText(""+modeList.get(position).getAddress());
        holder.lat.setText(""+modeList.get(position).getLat());
        holder.phone.setText(""+modeList.get(position).getPhone());
        holder.bs.setText(""+modeList.get(position).getBs());

    }

    @Override
    public int getItemCount() {
        return modeList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView name,username,city,lat,phone,bs;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            username=itemView.findViewById(R.id.username);
            city=itemView.findViewById(R.id.city);
            lat=itemView.findViewById(R.id.lat);
            phone=itemView.findViewById(R.id.phone);
            bs=itemView.findViewById(R.id.bs);
        }
    }
}
