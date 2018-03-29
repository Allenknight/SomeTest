package hsj.whatever.com.selfviewdemo;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RemoteViews;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HSJ on 2018/3/26.
 * Version 1.0
 */

public class NotificationActivity extends Activity{

    @BindView(R.id.btn_notification_1)
    Button btnNo1;
    @BindView(R.id.ll_noti)
    LinearLayout llW;

    private  NotificationManager notificationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.b);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getVibrantSwatch();
                llW.setBackgroundDrawable(new ColorDrawable(swatch != null ? swatch.getRgb() : 0));
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.btn_notification_1, R.id.btn_notification_2, R.id.btn_notification_3})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_notification_1:
                sendNotification();
                break;
            case R.id.btn_notification_2:
                sendNotification2();
                break;
            case R.id.btn_notification_3:
                sendNotification3();
                break;
            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sendNotification(){
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("normal Notification");
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        builder.setContentText("public");


        notificationManager.notify(0, builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sendNotification2(){
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("fold Notification");
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        builder.setContentText("public");

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.view_fold);
        Notification notification = builder.build();
        notification.bigContentView = remoteViews;
        notificationManager.notify(0, notification);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sendNotification3(){
        Notification.Builder builder = new Notification.Builder(this);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("hang Notification");

        builder.setVisibility(Notification.VISIBILITY_PUBLIC);
        builder.setContentText("public");

        Intent hangIntent = new Intent();
        hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hangIntent.setClass(this, NotificationActivity.class);

        PendingIntent hangPendingIntent = PendingIntent.getActivity(this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(hangPendingIntent, true);

        notificationManager.notify(0, builder.build());
    }

    private static final int PERMISSIONS_REQUEST_CALL_PHONT = 1;

    public void call(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_CALL_PHONT);
        }else{
            callPhone();
        }
    }

    public void callPhone(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        try{
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == PERMISSIONS_REQUEST_CALL_PHONT){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //权限通过
                callPhone();
            }else{
                //权限被拒绝
            }
            return;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
