package com.example.sunlight1.http;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.login.LoginException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private android.widget.TextView textView;
    private android.widget.Button button;
    RecyclerView recyclerView;
    private List<Teacherslist> list = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Teacherslist>> call = apiService.getTeacherList();
        call.enqueue(new Callback<List<Teacherslist>>() {
            @Override
            public void onResponse(Call<List<Teacherslist>> call, Response<List<Teacherslist>> response) {

                list = response.body();
                recyclerAdapter= new RecyclerAdapter(getApplicationContext(),list);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<Teacherslist>> call, Throwable t) {


            }
        });
    }}

