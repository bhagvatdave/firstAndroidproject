package com.example.firsttestproject.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firsttestproject.R;
import com.example.firsttestproject.databinding.ActivityNewuserBinding;
import com.example.firsttestproject.databinding.FragmentRegBinding;
import com.example.firsttestproject.regestration.LoginPage;
import com.example.firsttestproject.regestration.Userdata;
import com.example.firsttestproject.regestration.newuser;
import com.google.android.material.snackbar.Snackbar;


public class RegFragment extends Fragment {
    private FragmentRegBinding newuserbinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        newuserbinding=FragmentRegBinding.inflate(getLayoutInflater());
        return newuserbinding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
newuserbinding.btnReg.setOnClickListener(view1 -> {
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
        com.example.firsttestproject.regestration.Userdata UD = new Userdata(UsernameStr, EmailAddressStr, Password1Str, Phone1Str);
        //Toast.makeText(newuser.this,"Regstration Success",Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      /*  Intent i = new Intent(this, LoginPage.class);
        i.putExtra("Object",UD);
        startActivity(i);

       */
    }
});
    }

}