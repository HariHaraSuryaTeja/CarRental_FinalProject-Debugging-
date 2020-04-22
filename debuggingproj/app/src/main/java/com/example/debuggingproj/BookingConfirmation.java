package com.finalproject.carrentalsv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookingConfirmation extends AppCompatActivity {

    TextView Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        Home=findViewById(R.id.Home);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(),CarSelection.class);
                startActivity(home);
            }
        });
    }
}
