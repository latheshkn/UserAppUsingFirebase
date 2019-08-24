package com.example.cabuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearprofile,linearvechilelist,linearbookinghistory,linearabout,linearoffers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearprofile=findViewById(R.id.linearprofile);
        linearvechilelist=findViewById(R.id.linearvechilelist);
        linearbookinghistory=findViewById(R.id.linearbookinghistory);
        linearabout=findViewById(R.id.linearabout);
        linearoffers=findViewById(R.id.linearoffers);

        linearvechilelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,VehicleListActivty.class);
                startActivity(intent);
            }
        });

        linearprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);

            }
        });

        linearbookinghistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,BookingHistoryActivity.class);
                startActivity(intent);

            }
        });

        linearabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AboutPageActivity.class);
                startActivity(intent);
            }
        });

        linearoffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ImageDownloadActivity.class);
                startActivity(intent);
            }
        });

    }
}
