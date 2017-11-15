package hsj.whatever.com.selfviewdemo.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.renderscript.Sampler;

/**
 * Created by AllenHan on 2017/11/13.
 */

public class LooperThread<T> extends Thread{
    public Handler mHandler;

    public void run(){
        Looper.prepare();

        mHandler =  new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
        final Looper me = Looper.myLooper();
        final MessageQueue queue = me.myQueue();
        Looper.loop();
    }

//    public void set(T value){
//        Thread currentThread = Thread.currentThread();
//        Values values = values(currentThread);
//        if(values == null){
//            values = initializeValues(currentThread);
//        }
//        values.put(this, value);
//    }
//
//    public T get(){
//        Thread currentThread = Thread.currentThread();
//        Values values = values(currentThread);
//        if(values != null){
//            Object[] table = values.table;
//            int index = hash & values.mash;
//            if(this.reference == table[index]){
//                return (T)table[index + 1];
//            }
//        }
//    }

}
