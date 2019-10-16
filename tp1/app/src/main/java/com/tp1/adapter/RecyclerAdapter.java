package com.tp1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tp1.R;
import com.tp1.model.User;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    private List<User> usersList ;


    public RecyclerAdapter(List<User> usersList) {
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.first_name.setText(usersList.get(position).getFirst_name());
        holder.last_name.setText(usersList.get(position).getLast_name());
        holder.birth.setText(usersList.get(position).getBirth());
        holder.town.setText(usersList.get(position).getTown());
        holder.phone_number.setText(usersList.get(position).getPhone_number());
        holder.department.setText(usersList.get(position).getDepartment());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView first_name;
        TextView last_name;
        TextView birth;
        TextView town;
        TextView department;
        TextView phone_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.item_first_name);
            last_name = itemView.findViewById(R.id.item_last_name);
            birth = itemView.findViewById(R.id.item_birth);
            town =itemView.findViewById(R.id.item_town);
            phone_number = itemView.findViewById(R.id.item_phone_number);
            department = itemView.findViewById(R.id.item_department);

        }
    }
}
