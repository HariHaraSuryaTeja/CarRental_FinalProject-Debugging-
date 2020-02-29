package com.example.debuggingproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class userlogin extends AppCompatActivity {
    EditText userUname, userPass;
    Button register, Login;
    TextView fgtpwd;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        userUname = findViewById(R.id.username);
        userPass = findViewById(R.id.userPass);
        register = findViewById(R.id.register);
        Login = findViewById(R.id.Login);
        fgtpwd = findViewById(R.id.fgtpwd);

        fgtpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(userlogin.this,userforgotpwd.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(userlogin.this,registerpage.class);
                startActivity(i);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                final String mail =userUname.getText().toString();
                String pass = userPass.getText().toString();

                if (TextUtils.isEmpty(mail)){
                    userUname.setError("Enter a valid Email!");
                }

                if (TextUtils.isEmpty(pass)){
                    userPass.setError("Enter a valid Password!");
                }

                if (pass.length()<8){
                    userPass.setError("Password should be >=8");
                }
                firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(userlogin.this,"Loggin Successfull",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(userlogin.this,UserHomePage.class);
                            intent.putExtra("Email",mail);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(userlogin.this,"Login Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}
