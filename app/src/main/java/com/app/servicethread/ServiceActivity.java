package com.app.servicethread;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.R;

public class ServiceActivity extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
