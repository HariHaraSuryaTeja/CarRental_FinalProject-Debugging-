package com.example.debuggingproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class UserHomePage extends AppCompatActivity {

    TextView textView;
    Button Signout;
    AutoCompleteTextView autoCompleteTextView;
    Button next;
    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        Signout = findViewById(R.id.Signout);
        textView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Email");
        textView.setText(str);

        username = getIntent().getStringExtra("userData");
        //next = findViewById(R.id.next);

        //String[] cities = getResources().getStringArray(R.array.cities);
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, cities);
        //autoCompleteTextView = findViewById(R.id.cityAcTv);
        autoCompleteTextView.setThreshold(1);
        //autoCompleteTextView.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(userHomePage.this, CarSelectActivity.class);
                //intent.putExtra("userData", username);
                //intent.putExtra("vehicleArray", vehicles);
                //startActivity(intent);
            }
        });

        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),startscreen.class));
            }
        });
    }
}
