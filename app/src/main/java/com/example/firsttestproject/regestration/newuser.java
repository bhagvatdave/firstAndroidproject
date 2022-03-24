package com.example.firsttestproject.regestration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.firsttestproject.R;
import com.example.firsttestproject.databinding.ActivityLoginPageBinding;
import com.example.firsttestproject.databinding.ActivityNewuserBinding;
import com.google.android.material.snackbar.Snackbar;

public class newuser extends AppCompatActivity {
    private ActivityNewuserBinding newuserbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newuserbinding= ActivityNewuserBinding.inflate(getLayoutInflater());
        setContentView(newuserbinding.getRoot());

        newuserbinding.Register1.setOnClickListener(view -> {
            String UsernameStr = newuserbinding.editnewuserName.getText().toString();
            String EmailAddressStr = newuserbinding.editEmailAddress.getText().toString();
            long Phone1Str = Long.parseLong(newuserbinding.editPhone1.getText().toString());
            String Password1Str = newuserbinding.editPassword1.getText().toString();
            String repitPassword1Str = newuserbinding.editrepitPassword1.getText().toString();
            if (UsernameStr.isEmpty()) {
                Snackbar.make(view, "Please Enter User Name", Snackbar.LENGTH_SHORT).show();
            } else if (EmailAddressStr.isEmpty()) {
                Snackbar.make(view, "Please Enter Email Address", Snackbar.LENGTH_SHORT).show();
            } else if (Phone1Str == 0) {
                Snackbar.make(view, "Please Enter Phone Number", Snackbar.LENGTH_SHORT).show();
            } else if (Password1Str.isEmpty()) {
                Snackbar.make(view, "Please Enter Password", Snackbar.LENGTH_SHORT).show();
            } else if (repitPassword1Str.isEmpty()) {
                Snackbar.make(view, "Please Re-Enter Password", Snackbar.LENGTH_SHORT).show();
            } else if (!Password1Str.equals(repitPassword1Str)) {
                Snackbar.make(view, "Please Enter Password Again", Snackbar.LENGTH_SHORT).show();
                newuserbinding.editPassword1.setText("");
                newuserbinding.editrepitPassword1.setText("");
            } else {
                Userdata UD = new Userdata(UsernameStr, EmailAddressStr, Password1Str, Phone1Str);
                Toast.makeText(newuser.this,"Regstration Success",Toast.LENGTH_LONG).show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(this, LoginPage.class);
                i.putExtra("Object",UD);
                startActivity(i);
            }
        });
    }
}