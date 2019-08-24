package com.example.cabuserapp;

import android.app.Application;


import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
