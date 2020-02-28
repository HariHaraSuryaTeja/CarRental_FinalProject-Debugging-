package com.example.debuggingproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class registerpage extends AppCompatActivity {
    EditText Email, Username, Password, Firstname, Lastname, Mobile;
    Button Submit;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        Firstname = findViewById(R.id.firstnameR);
        Lastname = findViewById(R.id.lastnameR);
        Email = findViewById(R.id.emailr);
        Username = findViewById(R.id.usernameR);
        Password = findViewById(R.id.passwordR);
        Mobile = findViewById(R.id.mobile);
        Submit = findViewById(R.id.submit);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                final String mail = Email.getText().toString();
                String pass = Password.getText().toString();
                String uname = Username.getText().toString();
                String fname = Firstname.getText().toString();
                String lname = Lastname.getText().toString();
                String mobile = Mobile.getText().toString();

                if (TextUtils.isEmpty(mail)){
                    Email.setError("Enter a Valid Email");
                    return;
                }

                if (TextUtils.isEmpty(pass)){
                    Password.setError("Enter a valid Password");
                    return;
                }

                if (pass.length()>=8){
                    Password.setError("Password should be <=8");
                    return;
                }

                if (TextUtils.isEmpty(uname)){
                    Username.setError("Enter a valid Username");
                    return;
                }

                if (TextUtils.isEmpty(mobile)){
                    Mobile.setError("Enter a Valid name");
                    return;
                }
                if (TextUtils.isEmpty(fname)){
                    Firstname.setError("Enter a Valid name");
                    return;
                }

                if (TextUtils.isEmpty(lname)){
                    Lastname.setError("Enter a Valid name");
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(registerpage.this,"User Created",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(registerpage.this,userlogin.class);
                            //intent.putExtra("uname",mail);
                            startActivity(intent);
                        }

                        else {
                            Toast.makeText(registerpage.this,"Registration Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });



    }
}
