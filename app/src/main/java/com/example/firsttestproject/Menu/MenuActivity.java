package com.example.firsttestproject.Menu;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.firsttestproject.R;
import com.example.firsttestproject.Widget_Component.WidgetButton;
import com.example.firsttestproject.databinding.ActivityMenuBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;
import java.util.stream.IntStream;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding Mbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mbinding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(Mbinding.getRoot());

        registerForContextMenu(Mbinding.btnContext);

        Mbinding.btnPopup.setOnClickListener(view -> {
            PopupMenu pop = new PopupMenu(this,view);
            pop.getMenuInflater().inflate(R.menu.my_menu,pop.getMenu());

            pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    itemClick(menuItem);
                    return false;
                }
            });
            pop.show();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        itemClick(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        itemClick(item);
        return super.onContextItemSelected(item);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    void itemClick(MenuItem item){

            switch (item.getItemId()){

                case R.id.AnotherActivity:
                    Intent i = new Intent(this, WidgetButton.class);
                    startActivity(i);
                    //Snackbar.make(Mbinding.getRoot(),"item1",Snackbar.LENGTH_SHORT).show();
                    break;
                case R.id.Colorchange:
                    int red = randomno();
                    int blue = randomno();
                    int green = randomno();

                    Mbinding.getRoot().setBackgroundColor(Color.rgb(red,green,blue));
                    Snackbar.make(Mbinding.getRoot(),"Current Color Code is " + String.format("#%02x%02x%02x", red, green,blue),Snackbar.LENGTH_SHORT).show();
                    Mbinding.btnPopup.setVisibility(View.INVISIBLE);
                    Mbinding.btnContext.setVisibility(View.INVISIBLE);
                        runonthreading();
                    break;
                case R.id.Loadimage:
                    Mbinding.getRoot().setBackgroundResource(R.drawable._435045);
                    Mbinding.btnPopup.setVisibility(View.INVISIBLE);
                    Mbinding.btnContext.setVisibility(View.INVISIBLE);
                    runonthreading();
                    //Snackbar.make(Mbinding.getRoot(),"item3",Snackbar.LENGTH_SHORT).show();
                    break;
                case R.id.AnotherMenu:
                    Snackbar.make(Mbinding.getRoot(),"AnotherMenu",Snackbar.LENGTH_SHORT).show();
                    break;
                case R.id.SubMenu1:
                    Snackbar.make(Mbinding.getRoot(),"SubMenu1",Snackbar.LENGTH_SHORT).show();
                    break;
                case R.id.SubMenu2:
                    Snackbar.make(Mbinding.getRoot(),"SubMenu2",Snackbar.LENGTH_SHORT).show();
                    break;
            }

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    int randomno() {

        Random rand = new Random();
        return rand.nextInt(266);
    }
    void runonthreading(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Mbinding.getRoot().setBackgroundColor(Color.WHITE);
                            Mbinding.btnPopup.setVisibility(View.VISIBLE);
                            Mbinding.btnContext.setVisibility(View.VISIBLE);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
