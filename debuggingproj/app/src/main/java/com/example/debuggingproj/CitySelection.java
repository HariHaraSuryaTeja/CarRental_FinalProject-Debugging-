package com.example.debuggingproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class CitySelection extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Button next;
    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_selection);

        username = getIntent().getStringExtra("userData");

        next = findViewById(R.id.next);

        String[] cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, cities);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CitySelection.this, PickupAndDropOff.class);
                intent.putExtra("userData", username);
                startActivity(intent);
            }
        });
    }
}
