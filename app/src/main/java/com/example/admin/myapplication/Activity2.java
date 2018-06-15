package com.example.admin.myapplication;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView textView;
    private Messenger mService;
    final Messenger mMessenger = new Messenger(new Handler());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ServiceConnection sConn = new ServiceConnection() {

            public void onServiceConnected(ComponentName name, IBinder binder) {
                mService = new Messenger(binder);
                Message msg = Message.obtain(null,MyService.MSG_SET_VALUE);
                msg.replyTo = mMessenger;
                msg.obj = "GG";

                try{
                    mService.send(msg);
                }
                catch(RemoteException e ){
                    e.printStackTrace();
                }
            }

            public void onServiceDisconnected(ComponentName name) {

            }
        };

        bindService(MyService.newIntent(this), );
    }

    public void init() {
        textView = findViewById(R.id.textView2);
    }
}
