package com.example.firsttestproject.searchview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firsttestproject.databinding.EmpRowItemSearchBinding;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.EmpViewHolder> implements Filterable {

    ArrayList<Emp> list;
    ArrayList<Emp> copyList;
    ArrayList<Emp> filteredList=new ArrayList<>();

    EmpAdapter(ArrayList<Emp> list){

        this.list = list;
        copyList = list;
    }

    @NonNull
    @Override
    public EmpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // make individual item layout
        EmpRowItemSearchBinding binding = EmpRowItemSearchBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                if(charSequence.toString().equals("")){

                    filteredList = copyList;

                }else{

                    filteredList = new ArrayList<>(); // empty the filtered list again

                    for(Emp c : copyList){

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

                list = (ArrayList<Emp>) filterResults.values;

                notifyDataSetChanged();

            }
        };
    }

    public class EmpViewHolder extends RecyclerView.ViewHolder {

        EmpRowItemSearchBinding binding;

        public EmpViewHolder(@NonNull EmpRowItemSearchBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
