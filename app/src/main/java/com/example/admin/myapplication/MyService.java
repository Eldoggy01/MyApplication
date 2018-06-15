package com.example.admin.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public static final int MSG_SET_VALUE = 11;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,MyService.class);
        return intent;
    }
}
