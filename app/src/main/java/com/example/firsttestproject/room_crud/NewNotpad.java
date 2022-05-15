package com.example.firsttestproject.room_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.firsttestproject.databinding.ActivityNewNotpadBinding;

import java.util.List;

public class NewNotpad extends AppCompatActivity {
private ActivityNewNotpadBinding binding;
    private NotesDAO dao;
    private List<Notes> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityNewNotpadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dao = DatabaseHelper.getDatabase(this).getDAO();
        binding.Save1.setOnClickListener(view -> {
            String Titletxt=binding.EDTitletext.getText().toString();
            String Desctxt=binding.EDDescriptiontext.getText().toString();
            if(!Titletxt.isEmpty() ||!Desctxt.isEmpty()) {
                Notes n = new Notes(Titletxt, Desctxt);
                dao.insertData(n);
                list = dao.showData();
                Toast.makeText(this, "Notes Successfully saved", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, NotesAppActivity.class);
                startActivity(i);
            }
        });
        binding.Cancel1.setOnClickListener(view -> {
            binding.EDTitletext.setText("");
            binding.EDDescriptiontext.setText("");
        });
    }
}