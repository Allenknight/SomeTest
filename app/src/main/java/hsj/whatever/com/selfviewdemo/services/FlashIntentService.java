package hsj.whatever.com.selfviewdemo.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import hsj.whatever.com.selfviewdemo.utils.ControlFlash;

/**
 * Created by AllenHan on 2018/3/13.
 */

public class FlashIntentService extends IntentService{

    public final static String TAG = "FlashIntentService";
//    Context context;
    public ControlFlash controlFlash;
    public boolean isFlash;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public FlashIntentService() {
        super(TAG);
        controlFlash = new ControlFlash(this);
//        super();

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        int i = 10;
        while (i>0) {
            try {
                Thread.sleep(100);
                if (!isFlash) {
                    controlFlash.openFlash();
                    isFlash = true;
                } else {
                    controlFlash.closeFlash();
                    isFlash = false;
                }
            } catch (Exception e) {

            }
            i--;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isFlash = false;
        controlFlash.closeFlash();
    }
}
