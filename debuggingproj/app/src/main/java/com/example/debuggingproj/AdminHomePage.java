package com.example.debuggingproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admins_home_page);
        final EditText etType, etName, etcompany, etyear;
        Button btAdd;
        RecyclerView rvCars;
        final CarAdapter mAdapter;
        RecyclerView.LayoutManager layoutManager;

            rvCars = findViewById(R.id.rvAnimals);
            layoutManager = new LinearLayoutManager(this);
            rvCars.setLayoutManager(layoutManager);

            mAdapter = new CarAdapter(getApplicationContext());
            rvCars.setAdapter(mAdapter);

            final CarRepository repository = CarRepository.getInstance();

            etType = findViewById(R.id.etType);
            etName = findViewById(R.id.etName);
            etcompany = findViewById(R.id.etCompany);
            etyear = findViewById(R.id.etyear);
            btAdd = findViewById(R.id.btAdd);

            btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get field values
                    String type = etType.getText().toString();
                    String name = etName.getText().toString();
                    String company = etcompany.getText().toString();
                    int age = Integer.parseInt(etyear.getText().toString());

                    // create animal
                    Cars car = new Cars();
                    car.type = type;
                    car.name = name;
                    car.company = company;
                    car.year = age;

                    // add animal to repo
                    repository.addAnimal(car);

                    mAdapter.update();

                    // clear the fields
                    etyear.getText().clear();
                    etType.getText().clear();
                    etName.getText().clear();
                    etcompany.getText().clear();
                }
            });
        }
    }

