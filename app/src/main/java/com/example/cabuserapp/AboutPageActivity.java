package com.example.cabuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class AboutPageActivity extends AppCompatActivity {

Toolbar toolabout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        toolabout=findViewById(R.id.toolabout);

        toolabout.setTitle("About Page");

        setSupportActionBar(toolabout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
