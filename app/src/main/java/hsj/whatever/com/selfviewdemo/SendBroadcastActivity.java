package hsj.whatever.com.selfviewdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by HSJ on 2018/3/8.
 * Version 1.0
 */

public class SendBroadcastActivity extends ActionBarActivity{

    private MyReceiver receiver;
    private IntentFilter filter;
    private Context context;

    private static final String MY_BROADCAST_TAG = "com.example.localbroadcast";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
        filter = new IntentFilter();
        Button button = (Button)findViewById(R.id.btn_alpha);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //触发针对性广播
                Intent intent = new Intent();
                //目标tag
                intent.setAction(MY_BROADCAST_TAG);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }

    class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //message received
        }
    }
}
