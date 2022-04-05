package com.example.firsttestproject.Dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firsttestproject.databinding.ActivityCdialogBinding;
import com.example.firsttestproject.databinding.ActivityDialogBinding;
import com.example.firsttestproject.Menu.MenuActivity;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DialogActivity extends AppCompatActivity {
    private ActivityDialogBinding dbinding;
private ActivityCdialogBinding cdbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbinding = ActivityDialogBinding.inflate(getLayoutInflater());
        setContentView(dbinding.getRoot());

        String[] items = {"USS Enterprise","USS Stargazer","Millennium Falcon","Razor Crest","Waverider","The TARDIS"};
        ArrayList<String> vehicles = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        dbinding.btnAlert.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Activity Switch");
            builder.setMessage("Want To Go Another Activity");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                Toast.makeText(this, "Going To Another Activity", Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(this, MenuActivity.class);
                startActivity(ii);
            });
builder.setNegativeButton("No",(dialogInterface, i) -> {
    Toast.makeText(this, "Not Going", Toast.LENGTH_SHORT).show();
});
            builder.setNeutralButton("Cancel",(dialogInterface, i) -> {

                dialogInterface.dismiss();

            });

            builder.show();
        });
        dbinding.btnAlert1.setOnClickListener(view -> {
            cdbinding = ActivityCdialogBinding.inflate(getLayoutInflater());

            new AlertDialog.Builder(this)
                    .setTitle("Username")
                    .setView(cdbinding.getRoot())
                    .setPositiveButton("OK",(dialogInterface, i) -> {

                        String str = cdbinding.edtDialog.getText().toString();

                        Snackbar.make(dbinding.getRoot(), "Your User Name is " + str, Snackbar.LENGTH_SHORT).show();

                    }).create().show();

        });
        dbinding.btnProgress.setOnClickListener(view -> {
            ProgressDialog dialog = new ProgressDialog(this);
            dialog.setTitle("Loading");
            dialog.setMessage("Downloading your file");
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"Cancel",(dialogInterface, i) -> {

            });

            dialog.show();

        });

        dbinding.btnProgress1.setOnClickListener(view -> {
            ProgressDialog dialog = new ProgressDialog(this);
            dialog.setTitle("Downloading");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(100);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<=100;i++){
                        dialog.setProgress(i);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(i==dialog.getMax()){
                            dialog.dismiss();
                        }
                    }
                }
            }).start();

            dialog.show();
        });

        dbinding.btnTime.setOnClickListener(view -> {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minuet = calendar.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(this,(timePicker, i, i1) -> {
//                binding.btnTime.setText(i+":"+i1);  // 24 hrs
                String hr24 = i+":"+i1;
                SimpleDateFormat format24 = new SimpleDateFormat("HH:mm");
                SimpleDateFormat format12 = new SimpleDateFormat("hh:mm a");
                String hr12 = null;
                try {
                    hr12 = format12.format(format24.parse(hr24));
                    Snackbar.make(dbinding.getRoot(),"Your Selected Time is " + hr12 ,Snackbar.LENGTH_SHORT).show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            },hour,minuet,false);
            dialog.show();

        });
        dbinding.btnDate.setOnClickListener(view -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(this,(datePicker, i, i1, i2) -> {
                Snackbar.make(dbinding.getRoot(),"Your Selected Date is " + i2+"/"+(i1+1)+"/"+i ,Snackbar.LENGTH_SHORT).show();
            },year,month,day);
            dialog.show();
        });

        dbinding.btnFullScreen.setOnClickListener(view -> {
            cdbinding = ActivityCdialogBinding.inflate(getLayoutInflater());
            Dialog dialog = new Dialog(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
            dialog.setContentView(cdbinding.getRoot());
            dialog.show();
        });

        dbinding.btnMultiChoiceDialog.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMultiChoiceItems(items,null,(dialogInterface, i, b) -> {
                if(b){
                    vehicles.add(items[i]);
                }else{
                    vehicles.remove(items[i]);
                }
                Toast.makeText(DialogActivity.this, vehicles.toString(), Toast.LENGTH_SHORT).show();
            });
            builder.show();
        });
        dbinding.btnSingleChoice.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setSingleChoiceItems(items,0,(dialogInterface, i) -> {
                Toast.makeText(this, items[i], Toast.LENGTH_SHORT).show();
            });
            builder.show();
        });
    }
}