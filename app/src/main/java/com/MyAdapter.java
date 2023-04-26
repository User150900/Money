package com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.data.Dept;
import com.example.money.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter> {
    List<Dept> data;

    @NonNull
    @Override
    public MyAdapter (List<Dept> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {
        holder.name.setText(data.get(position).name);
        holder.money.setText(data.get(position).money);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView money;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            name = itemView.findViewById(R.id.money);
        }
    }
}
