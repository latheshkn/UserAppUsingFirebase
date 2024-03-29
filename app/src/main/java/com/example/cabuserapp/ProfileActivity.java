package com.example.cabuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cabuserapp.Model.UserDatails;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    Button btnedt;
    Toolbar toolprofile;
    TextView tvName,Emaildisplay;
    DatabaseReference databaseReference;
    Firebase mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnedt=findViewById(R.id.btnedt);
        toolprofile=findViewById(R.id.toolprofile);
        toolprofile.setTitle("Profile");
        setSupportActionBar(toolprofile);
        tvName=findViewById(R.id.namedisplay);
        Emaildisplay=findViewById(R.id.Emaildisplay);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

           databaseReference=FirebaseDatabase.getInstance().getReference().child("Admin");
//

        btnedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(ProfileActivity.this,LoginPageActivity.class);
                startActivity(intent);
                finish();

            }
        });

        showname();


    }

    public  void showname(){

        SharedPreferences sharedPreferences =getSharedPreferences("MY_PREF",MODE_PRIVATE);

        String NA =sharedPreferences.getString("NAME","name");

        String EM=sharedPreferences.getString("Email","email");



        tvName.setText(NA);

        Emaildisplay.setText(EM);



    }


}
