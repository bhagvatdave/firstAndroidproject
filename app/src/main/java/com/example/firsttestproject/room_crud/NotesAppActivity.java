package com.example.firsttestproject.room_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.firsttestproject.databinding.ActivityNotesAppBinding;
import com.example.firsttestproject.gallery_recyclerView.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotesAppActivity extends AppCompatActivity {
    private ActivityNotesAppBinding Nbinding;
    private NotesDAO dao;
    private List<Notes> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Nbinding = ActivityNotesAppBinding.inflate(getLayoutInflater());
        setContentView(Nbinding.getRoot());
        Nbinding.notesrecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        dao = DatabaseHelper.getDatabase(this).getDAO();
        list = new ArrayList<>();
        getData();


    Nbinding.AddnoteFAB.setOnClickListener(view -> {
    Intent i = new Intent(this,NewNotpad.class);
    startActivity(i);

    });

    }

    private void getData() {

        list = dao.showData();

        NotesAdapter adapter = new NotesAdapter((ArrayList<Notes>) list);

        Nbinding.notesrecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }
}


