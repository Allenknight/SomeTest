package hsj.whatever.com.selfviewdemo.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by AllenHan on 2017/10/26.
 */

public class SecService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SecService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
