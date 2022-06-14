package com.example.firsttestproject.firebase_realtime;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firsttestproject.databinding.UserRowItemSearchBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> implements Filterable {

    ArrayList<User> list;
    ArrayList<User> copyList;
    ArrayList<User> filteredList=new ArrayList<>();

    UserAdapter(ArrayList<User> list){

        this.list = list;
        copyList = list;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // make individual item layout
        UserRowItemSearchBinding binding = UserRowItemSearchBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        UserAdapter.UserViewHolder holder = new UserAdapter.UserViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {

        // add data inside individual item
        User e = list.get(position);

        holder.binding.setObj(e);


    }

    @Override
    public int getItemCount() {

        // display total item

        return list.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                if(charSequence.toString().equals("")){

                    filteredList = copyList;

                }else{

                    filteredList = new ArrayList<>(); // Userty the filtered list again

                    for(User c : copyList){

                        if(c.Name.toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                                c.Address.toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                                c.Field.toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                                String.valueOf(c.Salary).contains(charSequence.toString())){

                            filteredList.add(c);

                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                list = (ArrayList<User>) filterResults.values;

                notifyDataSetChanged();

            }
        };
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        UserRowItemSearchBinding binding;

        public UserViewHolder(@NonNull UserRowItemSearchBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

