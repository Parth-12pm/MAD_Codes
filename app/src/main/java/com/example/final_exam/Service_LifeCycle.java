package com.example.final_exam;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Service_LifeCycle extends Service {

    //git is shit
    public Service_LifeCycle() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}