package com.example.firsttestproject.Firebase_login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firsttestproject.databinding.ActivityNewuserBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class newuser extends AppCompatActivity {
    private ActivityNewuserBinding newuserbinding;
    private FirebaseAuth FAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newuserbinding= ActivityNewuserBinding.inflate(getLayoutInflater());
        setContentView(newuserbinding.getRoot());
        FAuth = FirebaseAuth.getInstance();
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
                FAuth.createUserWithEmailAndPassword(EmailAddressStr, Password1Str)
                        .addOnSuccessListener(authResult -> {
                            Userdata UD = new Userdata(UsernameStr, EmailAddressStr, Password1Str, Phone1Str);
                            Toast.makeText(newuser.this,"Regstration Success",Toast.LENGTH_LONG).show();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            Intent i = new Intent(newuser.this, LoginPage.class);
                            i.putExtra("Object",UD);
                            startActivity(i);
                        }).addOnFailureListener(e -> {
                            Toast.makeText(newuser.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        });
            }
        });
    }
}