package com.colander.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import hsj.whatever.com.selfviewdemo.MessageBean;
import hsj.whatever.com.selfviewdemo.MessageManager;

public class MainActivity extends AppCompatActivity {

    private MessageManager messageManager = null;

    //是否连接成功
    private boolean mBound = false;

    //传输对象
    private MessageBean messageBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        if(!mBound){
            connectService();
            Toast.makeText(this, "Connecting", Toast.LENGTH_SHORT);
            return;
        }
        if(messageManager == null) return;

        MessageBean msg = new MessageBean();
        msg.setMessageTitle("Client title");
        msg.setMessageContent("Client content");
        try{
            messageManager.sendMessage(msg);
            Log.e(getLocalClassName(), msg.toString());
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

    private void connectService(){
        Intent intent = new Intent();
        intent.setAction("hsj.whatever.com.selfviewdemo");
        intent.setPackage("hsj.whatever.com.selfviewdemo");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!mBound){
            connectService();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mBound){
            unbindService(mServiceConnection);
            mBound = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(getLocalClassName(), "service connected");
            messageManager = MessageManager.Stub.asInterface(service);
            mBound = true;

            if(messageManager != null){
                try{
                    messageBean = messageManager.getMessage();
                    Log.e(getLocalClassName(), messageBean.toString());
                }catch (RemoteException e){
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(getLocalClassName(), "service disconnected");
            mBound = false;
        }
    };
}
