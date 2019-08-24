package com.example.cabuserapp;

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

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPageActivity extends AppCompatActivity {

    Firebase mref;
    FirebaseAuth.AuthStateListener mAuthlisner;
    FirebaseAuth Auth;
    Button btn_login;
    TextView link_signup;

    EditText input_email,input_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        FirebaseApp.initializeApp(this);
        mref = new Firebase("https://adminapp-c9ff1.firebaseio.com/");
        btn_login=findViewById(R.id.btn_login);
        link_signup=findViewById(R.id.link_signup);


        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        btn_login = findViewById(R.id.btn_login);
        link_signup = findViewById(R.id.link_signup);

        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginPageActivity.this,RegisterPageActivity.class);
                startActivity(intent);
            }
        });


//        toolbar = findViewById(R.id.toolbarfrontpage);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Auth = FirebaseAuth.getInstance();

        mAuthlisner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(LoginPageActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STARTSIGNIN();


            }
        });

    }

    private void STARTSIGNIN(){

        String Aname=input_email.getText().toString();
        String Apassword=input_password.getText().toString();

        if (TextUtils.isEmpty(Aname) || TextUtils.isEmpty(Apassword)) {

            Toast.makeText(LoginPageActivity.this, "Fields are empty ", Toast.LENGTH_SHORT).show();

        }
        else {
            Auth.signInWithEmailAndPassword(Aname,Apassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()){
                        Toast.makeText(LoginPageActivity.this, "SignIn Problem", Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        Auth.addAuthStateListener(mAuthlisner);
    }



}
