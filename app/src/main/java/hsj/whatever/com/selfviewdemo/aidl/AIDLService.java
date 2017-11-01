package hsj.whatever.com.selfviewdemo.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import hsj.whatever.com.selfviewdemo.MessageManager;
import hsj.whatever.com.selfviewdemo.MessageBean;

/**
 * Created by AllenHan on 2017/10/24.
 */

public class AIDLService extends Service{

    public final String TAG = "AIDL_MESSAGE";

    private MessageBean message = new MessageBean();

    private final MessageManager.Stub mMessageManager = new MessageManager.Stub() {
        @Override
        public MessageBean getMessage() throws RemoteException {
            synchronized (this) {
                Log.e(TAG, "received message is " + message.toString());
                if (message != null) {
                    return message;
                }
                return new MessageBean();
            }
        }

        @Override
        public void sendMessage(MessageBean msg) throws RemoteException {
            synchronized (this) {
                if (message == null) {
                    message = new MessageBean();
                }
                if(msg == null){
                    Log.e(TAG, "message is null");
                    msg = new MessageBean();
                }
                msg.setMessageContent("Content1");
                msg.setMessageTitle("Title1");
                if(message.getMessageTitle() == null){
                    message = msg;
                }
            }
            Log.e(TAG, "send message is"+ message.toString());
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        MessageBean msg = new MessageBean();
        msg.setMessageTitle("Title0");
        msg.setMessageContent("Content0");
        message = msg;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(getClass().getSimpleName(), String.format("on bind, intent = %s", intent.toString()));
        return mMessageManager;
    }
}
