package com.example.firsttestproject.Firebase_login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firsttestproject.databinding.ActivityLoginPageBinding;
import com.example.firsttestproject.Firebase_login.Userdata;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    private ActivityLoginPageBinding loginbinding;
    private FirebaseAuth FAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginbinding=ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(loginbinding.getRoot());

        loginbinding.newuser1.setOnClickListener(view -> {
            Intent i = new Intent(this, newuser.class);
            startActivity(i);
        });
        FAuth = FirebaseAuth.getInstance();

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
                FAuth.signInWithEmailAndPassword(loginusernamestr, loginpasswordstr)
                        .addOnSuccessListener(authResult -> {
                            Toast.makeText(LoginPage.this,"Login Success",Toast.LENGTH_LONG).show();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            Intent ii = new Intent(this, Dashbord.class);
                            ii.putExtra("Object1",UD1);
                            startActivity(ii);
                        }).addOnFailureListener(e -> {
                            Toast.makeText(LoginPage.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            loginbinding.edituserName.setText("");
                            loginbinding.editPassword.setText("");
                        });
            }

        });


    }
}