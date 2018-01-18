package com.ptp.phamtanphat.quanlyhocsinh3110;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvhocsinh;
    HocsinhAdapter hocsinhAdapter;
    ArrayList<Hocsinh> manghocsinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lvhocsinh = findViewById(R.id.listviewhocsinh);
        manghocsinh = new ArrayList<>();
        hocsinhAdapter = new HocsinhAdapter(this,R.layout.dong_item_hocsinh,manghocsinh);
        lvhocsinh.setAdapter(hocsinhAdapter);
        GetData();
    }

    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://10.0.2.11/Quanlyhocsinh/getdata.php";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length();i++){
                    try {
                        JSONObject jsonObjecthocsinh = response.getJSONObject(i);

                        int id = jsonObjecthocsinh.getInt("Id");
                        String ten = jsonObjecthocsinh.getString("Ten");
                        String namsinh = jsonObjecthocsinh.getString("Namsinh");
                        String diachi = jsonObjecthocsinh.getString("Diachi");

                        manghocsinh.add(new Hocsinh(id,ten,namsinh,diachi));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                hocsinhAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_them,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuthem :
                Intent intent = new Intent()
        }
        return super.onOptionsItemSelected(item);
    }
}
