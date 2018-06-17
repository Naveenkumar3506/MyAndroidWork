package com.naveen.testapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterListTableView extends RecyclerView.Adapter<AdapterListTableView.MyViewHolder> {

    ArrayList<User> userList;
    Context mContext;

    AdapterListTableView(ArrayList<User> models, Context mContext) {
        this.userList = models;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtNameList.setText(userList.get(position).getName());
        holder.txtPhoneList.setText(userList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtPhoneList, txtNameList;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtPhoneList = itemView.findViewById(R.id.txtPhoneList);
            txtNameList = itemView.findViewById(R.id.txtNameList);

        }
    }
}
