package com.example.cabuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class BookingHistoryActivity extends AppCompatActivity {

    Toolbar toolbookinghistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);

        toolbookinghistory=findViewById(R.id.toolbookinghistory);

        setSupportActionBar(toolbookinghistory);
        toolbookinghistory.setTitle("Booking History");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
