package com.example.debuggingproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class PostLoginActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    Button next;
    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);

        username = getIntent().getStringExtra("userData");
        next = findViewById(R.id.next);

        //String[] cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, cities);
        autoCompleteTextView = findViewById(R.id.cityAcTv);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostLoginActivity.this, CarSelectActivity.class);
                intent.putExtra("userData", username);
                //intent.putExtra("vehicleArray", vehicles);
                startActivity(intent);
            }
        });
    }
}
