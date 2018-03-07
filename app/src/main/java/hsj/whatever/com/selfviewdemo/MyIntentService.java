package hsj.whatever.com.selfviewdemo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by HSJ on 2018/3/7.
 * Version 1.0
 */

public class MyIntentService extends IntentService{

    final String WHATEVER = "MyIntentServices";

    private boolean isRunning;

    private int count;

    private LocalBroadcastManager mLocalBroadcastManager;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super("MyIntentService");

        Log.e(WHATEVER, "MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(WHATEVER, "onCreate");
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e(WHATEVER, "onHandleIntent");
        try{
            Thread.sleep(1000);
            isRunning = true;
            count = 0;
            while (isRunning){
                count++;
                if(count >= 100){
                    isRunning = false;
                }
                Thread.sleep(50);
                sendThreadStatus("线程运行中...." , count);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendThreadStatus(String status, int progress){
        Intent intent = new Intent(MainActiviy5.ACRION_TYPE_THREAD);
        intent.putExtra("status", status);
        intent.putExtra("progress", progress);
        mLocalBroadcastManager.sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(WHATEVER, "线程结束运行...");
    }
}
