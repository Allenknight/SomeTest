package hsj.whatever.com.selfviewdemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by AllenHan on 2017/10/26.
 */

public class LocalService extends Service{
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenerator = new Random();

    public class LocalBinder extends Binder{
        LocalService getService(){
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public int getRandomNumber(){
        return mGenerator.nextInt(100);
    }
}
