package com.example.firsttestproject.regestration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.example.firsttestproject.databinding.ActivityLoginPageBinding;
import com.google.android.material.snackbar.Snackbar;

public class LoginPage extends AppCompatActivity {
    private ActivityLoginPageBinding loginbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginbinding=ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(loginbinding.getRoot());

        loginbinding.newuser1.setOnClickListener(view -> {
            Intent i = new Intent(this, newuser.class);
            startActivity(i);
        });

        loginbinding.Login1.setOnClickListener(view -> {
            Intent i =getIntent();
            Userdata UD1 = (Userdata) i.getSerializableExtra("Object");
            String loginusernamestr = loginbinding.edituserName.getText().toString();
            String loginpasswordstr = loginbinding.editPassword.getText().toString();

            if (loginusernamestr.equals("")) {
                Snackbar.make(view, "Please Enter User Name", Snackbar.LENGTH_SHORT).show();
            } else if (loginpasswordstr.equals("")) {
                Snackbar.make(view, "Please Enter Password", Snackbar.LENGTH_SHORT).show();
            }else {
                if(UD1.username.equals(loginusernamestr) && UD1.password.equals(loginpasswordstr)) {
                    Toast.makeText(LoginPage.this,"Login Success",Toast.LENGTH_LONG).show();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent ii = new Intent(this, Dashbord.class);
                    ii.putExtra("Object1",UD1);
                    startActivity(ii);
                } else {
                    loginbinding.edituserName.setText("");
                    loginbinding.editPassword.setText("");
                }
            }

        });


    }
}