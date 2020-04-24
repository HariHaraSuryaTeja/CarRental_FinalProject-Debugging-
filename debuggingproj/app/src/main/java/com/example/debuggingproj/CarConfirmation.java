package com.example.debuggingproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarConfirmation extends AppCompatActivity {

    ImageView imageView;
    TextView name, price, year, description;
    String carname,carPrice,caryear,cardescription;
    int image;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_confirmation);

        imageView=findViewById(R.id.nimage);
        name=findViewById(R.id.Car_name);
        price=findViewById(R.id.car_price);
        year=findViewById(R.id.Car_year);
        description=findViewById(R.id.Car_description);
        confirm=findViewById(R.id.nextbtn);

        carname=getIntent().getStringExtra("Carname");
        carPrice=getIntent().getStringExtra("Carprice");
        caryear=getIntent().getStringExtra("Caryear");
        cardescription=getIntent().getStringExtra("Cardescription");
        image=getIntent().getIntExtra("Carimage",0);
        name.setText(carname);
        price.setText(carPrice);
        year.setText(caryear);
        description.setText(cardescription);
        imageView.setImageResource(image);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirmation=new Intent(getApplicationContext(),PaymentPage.class);
                startActivity(confirmation);
            }
        });


    }
}
