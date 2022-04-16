package com.example.firsttestproject.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.firsttestproject.databinding.ActivityEmpListBinding;

import java.util.ArrayList;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpListBinding elbinding;
    private ArrayList<Emp> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        elbinding = ActivityEmpListBinding.inflate(getLayoutInflater());
        setContentView(elbinding.getRoot());
        elbinding.recyclerViewEmp.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));

        list = new ArrayList<>();

        EmpAdapter adapter = new EmpAdapter(list);
        elbinding.recyclerViewEmp.setAdapter(adapter);

        elbinding.recyclerViewEmp.setAdapter(adapter);

        elbinding.btnAdd.setOnClickListener(view -> {

            String name= elbinding.edtName.getText().toString();
            String field= elbinding.edtField.getText().toString();
            String address= elbinding.edtAddress.getText().toString();
            String salary= elbinding.edtSalary.getText().toString();

            Emp e = new Emp(name,field,Integer.parseInt(salary),address);

            if(!name.isEmpty() && !list.contains(e)){
                list.add(e);
            }

            adapter.notifyDataSetChanged();

        });
    }
}