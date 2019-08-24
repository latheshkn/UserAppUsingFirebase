package com.example.cabuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditProfileactivity extends AppCompatActivity {

Toolbar tooleditprofile;

Button btnsave;
Firebase firebase;
EditText edtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profileactivity);
        tooleditprofile=findViewById(R.id.tooleditprofile);
        btnsave=findViewById(R.id.btnsave);

        tooleditprofile.setTitle("Edit profile");

        setSupportActionBar(tooleditprofile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebase=new Firebase("https://adminapp-c9ff1.firebaseio.com/User");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedb();
            }
        });
    }

    public  void savedb(){

        edtname=findViewById(R.id.edtname);
        String uname=edtname.getText().toString();

// get user id in order to write to the specific user
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;


//        Toast.makeText(this, "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();

        String id=currentFirebaseUser.getUid();

        firebase.child(id).child("Name").setValue(uname);



        Intent intent =new Intent(EditProfileactivity.this,ProfileActivity.class);
        startActivity(intent);


        Toast.makeText(this, "Name Changed", Toast.LENGTH_SHORT).show();

    }

}
