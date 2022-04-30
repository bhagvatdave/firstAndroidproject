package com.example.firsttestproject.internal_external;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.firsttestproject.databinding.ActivityInternalExternalBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.firsttestproject.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InternalExternalActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityInternalExternalBinding iebinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iebinding = ActivityInternalExternalBinding.inflate(getLayoutInflater());
        setContentView(iebinding.getRoot());

        iebinding.btnInternalStore.setOnClickListener(view -> {

            String data = iebinding.edtStore.getText().toString();

            try {

                FileOutputStream fos = openFileOutput("data.txt",MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "Data Write in Internal Storage", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        iebinding.btnFetchInternal.setOnClickListener(view -> {

            try {

                FileInputStream fis = openFileInput("data.txt");
                byte arr[] = new byte[fis.available()];
                fis.read(arr);

                String data = new String(arr);

                iebinding.tvInternal.setText(data);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        iebinding.btnStoreExternal.setOnClickListener(view -> {

            checkPermission();

            File externalFolder = Environment.getExternalStorageDirectory();

            File file = new File(externalFolder,"data.txt");

            try {

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(iebinding.edtStore.getText().toString().getBytes());
                fos.close();

                Toast.makeText(this, "File Write External", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        iebinding.btnFetchExternal.setOnClickListener(view -> {

            checkPermission();

            File externalFolder = Environment.getExternalStorageDirectory();

            File file = new File(externalFolder,"data.txt");

            try {

                FileInputStream fis = new FileInputStream(file);

                byte arr[] = new byte[fis.available()];

                fis.read(arr);

                String data = new String(arr);

                iebinding.tvExternal.setText(data);


            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    void checkPermission(){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},101);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},101);
            }
        }

    }

}