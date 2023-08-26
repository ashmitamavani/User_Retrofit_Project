package com.example.user_retrofit_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ProductModel> ProductList=new ArrayList<>();
    ArrayList<Model_class>ModeList=new ArrayList<>();
    Recyclerview_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new Recyclerview_Adapter(MainActivity.this,ModeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Instance_class.CallAPI().showProduct().enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                Log.d("AAA", "onResponse: ===="+response.body().get(0).getName().toString());
                ProductList=response.body();
                for (int i=0;i<ProductList.size();i++)
                {
                    String name=response.body().get(i).getName();
                    String username=response.body().get(i).getUsername();
                    String city=response.body().get(i).getAddress().getCity();
                    String lat=response.body().get(i).getAddress().getGeo().getLat();
                    String phone=response.body().get(i).getPhone();
                    String bs=response.body().get(i).getCompany().getBs();
                    Model_class model=new Model_class(name,username,city,lat,phone,bs);
                    ModeList.add(model);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Log.e("AAA", "on Response"+t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}