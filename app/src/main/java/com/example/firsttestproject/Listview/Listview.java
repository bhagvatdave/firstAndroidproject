package com.example.firsttestproject.Listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.firsttestproject.R;
import com.example.firsttestproject.databinding.ActivityListviewBinding;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {

    private ActivityListviewBinding lbinding;
    private ArrayList<String> list;
    private boolean update = false;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lbinding = ActivityListviewBinding.inflate(getLayoutInflater());
        setContentView(lbinding.getRoot());
        list = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,list);
        lbinding.listViewStudents.setAdapter(adapter);

        lbinding.btnAdd.setOnClickListener(view -> {
            datamanage(lbinding.edtStudentName.getText().toString(),update,position);
            update = false;
            position = 0;
            lbinding.btnAdd.setText("Add");
            adapter.notifyDataSetChanged();
        });
        lbinding.listViewStudents.setOnItemClickListener((adapterView, view, pos, l) -> {
            String data = list.get(pos);

            new AlertDialog.Builder(Listview.this)
                    .setTitle("Choose One")
                    .setPositiveButton("Update",(dialogInterface, i) -> {
                        //update
                        update = true;
                        position = pos;
                        lbinding.edtStudentName.setText(data);
                        lbinding.btnAdd.setText("Update");
                    })
                    .setNeutralButton("Delete",(dialogInterface, i) -> {
                        // delete
                        list.remove(data);
                        adapter.notifyDataSetChanged();
                    }).create().show();
        });
    }
    void datamanage(String name,boolean update, int pos){
        if(update){
            list.set(pos,name);
        }else{
            if(!name.isEmpty() && !list.contains(name)){
                list.add(name);
            }
        }
        lbinding.edtStudentName.setText("");
    }
}