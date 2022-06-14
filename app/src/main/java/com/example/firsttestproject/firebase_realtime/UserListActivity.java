package com.example.firsttestproject.firebase_realtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.firsttestproject.R;
import com.example.firsttestproject.databinding.ActivityUserListBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
private ActivityUserListBinding Ubinding;
private DatabaseReference Ref;
private ArrayList<User> list;
private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Ubinding =ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(Ubinding.getRoot());
        Ubinding.recyclerViewUser.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        adapter = new UserAdapter(list);
        Ubinding.recyclerViewUser.setAdapter(adapter);
        Ref= FirebaseDatabase.getInstance().getReference("User").child("Userdata");



        Ubinding.btnAdd.setOnClickListener(view -> {
            String name= Ubinding.edtName.getText().toString();
            String field= Ubinding.edtField.getText().toString();
            String address= Ubinding.edtAddress.getText().toString();
            String salary= Ubinding.edtSalary.getText().toString();
            User u = new User(name,field,Integer.parseInt(salary),address);
            if(!name.isEmpty() && !list.contains(u)){
                list.add(u);
                Ref.push().setValue(u).addOnSuccessListener(unused -> {
                    Toast.makeText(UserListActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(e -> {
                    Toast.makeText(UserListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                });
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