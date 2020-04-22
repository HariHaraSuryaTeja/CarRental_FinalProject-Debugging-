package com.finalproject.carrentalsv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CarSelection  extends AppCompatActivity {
    RecyclerView recyclerView;

    List<CarData> dataofcar;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_selection);
        dataofcar=new ArrayList<>();
        recyclerView=findViewById(R.id.Carlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"Tesla","2020","This is a eco-friendly vehicle as it uses electricity as fule"));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"Honda","2019","This is a petrol varient"));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"Toyota","2020","This is a eco-friendly vehicle as it uses electricity as fule"));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"Toyota","2018","this uses petrol as fuel"));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"Audi A6","2020","This vehicle is for people why prefer to travel in style"));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"BMW","2019","This vehicle is for people who preffer comfort"));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"Lamborgini","2019","This is for people who prefer class"));
        dataofcar.add(new CarData(R.drawable.ic_launcher_background,"Ferari","2019","This is for people who prefer class"));
        adapter=new CarsAdapter(dataofcar,getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}
