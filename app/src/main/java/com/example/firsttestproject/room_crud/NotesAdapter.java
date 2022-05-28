package com.example.firsttestproject.room_crud;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.firsttestproject.databinding.NotesRowItemBinding;
import com.example.firsttestproject.room_crud.Notes;
import com.example.firsttestproject.room_crud.NotesAdapter;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>{
    ArrayList<Notes> list;
    Context context;

    NotesAdapter(ArrayList<Notes> list){

        this.list = list;
    }
    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        NotesRowItemBinding binding = NotesRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new NotesAdapter.NotesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Notes n = list.get(position);

        holder.binding.setObject(n);

        holder.itemView.setOnClickListener(view -> {

            new AlertDialog.Builder(context);

        });

    }

    @Override
    public int getItemCount() { return list.size(); }

    public class NotesViewHolder extends RecyclerView.ViewHolder {

        NotesRowItemBinding binding;

        public NotesViewHolder(@NonNull NotesRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
