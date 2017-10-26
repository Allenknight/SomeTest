package hsj.whatever.com.selfviewdemo.image;

import android.app.Activity;
import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import hsj.whatever.com.selfviewdemo.R;
import hsj.whatever.com.selfviewdemo.services.FirstService;

/**
 * Created by HSJ on 2017/10/24.
 * Version 1.0
 */

public class TurnActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TurnImage(this));

        Intent intent = new Intent(TurnActivity.this, FirstService.class);
        startService(intent);
//        得到IBinder接口，我们通常有三种方式：继承Binder类，使用Messenger类，使用AIDL。
        FirstService mService;
        FirstService.BinderDemo mBinder;

        ServiceConnection mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
//                mBinder = (FirstService.BinderDemo) service;
//                mService = mBinder.getService();
                Log.d(this.getClass().getSimpleName(), "onServiceConnected");

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public class IntentServiceDemo extends IntentService{

        /**
         * Creates an IntentService.  Invoked by your subclass's constructor.
         *
         * @param name Used to name the worker thread, important only for debugging.
         */
        public IntentServiceDemo(String name) {
            super(name);
        }

        @Override
        protected void onHandleIntent(Intent intent) {

        }

        @Override
        public boolean bindService(Intent service, ServiceConnection conn, int flags) {
            return super.bindService(service, conn, flags);
        }
    }

}
