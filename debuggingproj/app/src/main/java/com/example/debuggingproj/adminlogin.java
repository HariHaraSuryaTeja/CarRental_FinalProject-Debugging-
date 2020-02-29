package com.example.debuggingproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class adminlogin extends AppCompatActivity {

    EditText adminLogin, adminPass;
    Button Login;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        adminLogin = findViewById(R.id.adminUname);
        adminPass = findViewById(R.id.adminPass);
        Login = findViewById(R.id.adminLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                //final String adminMail = adminlogin.getText()
            }
        });
    }
}
