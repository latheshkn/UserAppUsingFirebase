package com.example.cabuserapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;

public class GettingDeviceTokenServices extends FirebaseMessagingService {

    @Override
    public void onNewToken(String s) {
       String DeviceToken= FirebaseInstanceId.getInstance().getToken();

       Log.d("DEVICE TOCKEN",DeviceToken);

    }
}
