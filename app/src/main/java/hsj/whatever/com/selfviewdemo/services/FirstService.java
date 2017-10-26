package hsj.whatever.com.selfviewdemo.services;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by AllenHan on 2017/10/26.
 */

public class FirstService extends Service {
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    private final class ServiceHandler extends Handler{
        public ServiceHandler(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            long endTime = System.currentTimeMillis() + 5*100;
            while (System.currentTimeMillis() < endTime){
                synchronized (this){
                    try{
                        wait(endTime - System.currentTimeMillis());
                    }catch (Exception e){

                    }
                }
            }
            stopSelf(msg.arg1);
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
//        Log.d("FirstService", "onCreate");
//        super.onCreate();
//        HandlerThread thread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
//        thread.start();
//        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
//        super.onDestroy();
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
        
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return super.bindService(service, conn, flags);
    }

    public class BinderDemo extends Binder{

        public Service getService(){
            return null;
        }

    }
}
