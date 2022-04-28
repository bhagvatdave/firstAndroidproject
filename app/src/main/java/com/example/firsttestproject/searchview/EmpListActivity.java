package com.example.firsttestproject.searchview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.firsttestproject.R;
import com.example.firsttestproject.databinding.ActivityEmpListBinding;

import java.util.ArrayList;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpListBinding elbinding;
    private ArrayList<Emp> list;
    private EmpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        elbinding = ActivityEmpListBinding.inflate(getLayoutInflater());
        setContentView(elbinding.getRoot());
        elbinding.recyclerViewEmp.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));

        list = new ArrayList<>();

        adapter = new EmpAdapter(list);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}