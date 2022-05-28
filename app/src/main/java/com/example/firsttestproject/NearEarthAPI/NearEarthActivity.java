package com.example.firsttestproject.NearEarthAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.firsttestproject.NearEarthAPI.Class.DateViseList;
import com.example.firsttestproject.NearEarthAPI.Class.Nasa;
import com.example.firsttestproject.databinding.ActivityNearEarthBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NearEarthActivity extends AppCompatActivity {
private ActivityNearEarthBinding earthBinding;
private List<DateViseList> list;
public String nasaString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        earthBinding=ActivityNearEarthBinding.inflate(getLayoutInflater());
        setContentView(earthBinding.getRoot());
        list =new ArrayList<>();
        Call<Nasa> call = NearEarthHelper.getApiInstance().getdata("JQaNJZuAktJ9vEfUDA6qLOPIurIhavdxGozX2mbM");

        call.enqueue(new Callback<Nasa>() {
            @Override
            public void onResponse(Call<Nasa> call, Response<Nasa> response) {
                nasaString =response.body().toString();
                Log.i("response",nasaString);
                        Nasa nasa = response.body();

                list= nasa.getNearEarthObjects().getDateViseList();
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       ArrayAdapter<DateViseList> adapter = new ArrayAdapter<>(NearEarthActivity.this, android.R.layout.simple_list_item_1,list);
                   earthBinding.earthrecyclerView.setAdapter(adapter);

                   }
               });
            }

            @Override
            public void onFailure(Call<Nasa> call, Throwable t) {

            }
        });


    }

    private void jsonParsing(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject dataObj = jsonObject.getJSONObject("near_earth_objects");

            Iterator<String> iter = dataObj.keys();

            Log.e("TAG", "jsonParsing: "+iter );

            while (iter.hasNext()) {
                String key = iter.next();
                JSONArray datesArray = dataObj.getJSONArray(key);
                //list = new ArrayList<DateViseList>();
                for (int i = 0; i < datesArray.length(); i++) {
                    JSONObject datesObject = datesArray.getJSONObject(i);

                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}