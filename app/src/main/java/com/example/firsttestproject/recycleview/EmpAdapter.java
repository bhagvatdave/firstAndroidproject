package com.example.firsttestproject.recycleview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firsttestproject.databinding.EmpRowItemBinding;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.EmpViewHolder> {

    ArrayList<Emp> list;

    EmpAdapter(ArrayList<Emp> list){

        this.list = list;
    }

    @NonNull
    @Override
    public EmpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // make individual item layout
        EmpRowItemBinding binding = EmpRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        EmpViewHolder holder = new EmpViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmpViewHolder holder, int position) {

        // add data inside individual item
        Emp e = list.get(position);

        holder.binding.setObj(e);


    }

    @Override
    public int getItemCount() {

        // display total item

        return list.size();
    }

    public class EmpViewHolder extends RecyclerView.ViewHolder {

        EmpRowItemBinding binding;

        public EmpViewHolder(@NonNull EmpRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
