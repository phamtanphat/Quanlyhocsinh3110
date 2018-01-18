package com.ptp.phamtanphat.quanlyhocsinh3110;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ThemdulieuActivity extends AppCompatActivity {

    Button btnthem,btnhuy;
    EditText edtten,edtnamsinh,edtdiachi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themdulieu);

        btnhuy = findViewById(R.id.buttonhuy);
        btnthem = findViewById(R.id.buttonthem);
        edtten = findViewById(R.id.edittextten);
        edtdiachi = findViewById(R.id.edittextdiachi);
        edtnamsinh = findViewById(R.id.edittextnamsinh);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ten = edtten.getText().toString();
                final String namsinh = edtnamsinh.getText().toString().trim();
                final String diachi = edtdiachi.getText().toString();

                if (ten.length() >0 && namsinh.length()>0 && diachi.length() > 0){
                    RequestQueue requestQueue = Volley.newRequestQueue(ThemdulieuActivity.this);
                    String url = "http://10.0.2.11/Quanlyhocsinh/insert.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("success")){
                                Intent intent = new Intent(ThemdulieuActivity.this,MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(ThemdulieuActivity.this, "Khong them duoc du lieu", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(ThemdulieuActivity.this, "Co loi xay ra", Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            //Gui chi mot du lieu cho tu khoa thi dung hashmap
                            //Gui nhieu du lieu thi se gui 1 json

                            HashMap<String,String> insertdatatoserver = new HashMap<String,String>();

                            insertdatatoserver.put("Tenhocsinh",ten);
                            insertdatatoserver.put("Namsinh",namsinh);
                            insertdatatoserver.put("Diachi",diachi);

                            return insertdatatoserver;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else{

                 }
            }
        });
    }
}
