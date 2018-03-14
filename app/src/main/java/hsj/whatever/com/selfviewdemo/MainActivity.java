package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.view.ViewStub;

import java.io.File;

import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import hsj.whatever.com.selfviewdemo.older.ThirdView;
import hsj.whatever.com.selfviewdemo.services.FlashIntentService;
import hsj.whatever.com.selfviewdemo.utils.ControlFlash;

public class MainActivity extends AppCompatActivity {
    ThirdView llll;
    ControlFlash c;
    boolean isFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.merge_xml);
        c = new ControlFlash(this);
        c.IsHaveFlash();





//        c.openFlash();

//        llll = (ThirdView)findViewById(R.id.llll);
//        llll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                if(getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null){
//                    try {
//                        startActivity(intent);
//                    }catch (ActivityNotFoundException e){
//
//                    }
//                }
//            }
//        });

//        Intent intent = new Intent(Intent.ACTION_VIEW);
////        intent.setData()
//        if(getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null){
//            try {
//                startActivity(intent);
//            }catch (ActivityNotFoundException e){
//
//            }
//        }
//        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new SweetAlertDialog(MainActivity.this)
//                        .setTitleText("Title")
//                        .setContentText("just show")
//                        .setConfirmText("ops")
//                        .show();
//            }
//        });
    }

    public void OnClick(View view) {
//        ((ViewStub)findViewById(R.id.vs_1)).inflate();

    }

    public void OnOpenClick(View view){
//        c.openFlash();
        Intent intent = new Intent(MainActivity.this, FlashIntentService.class);
        startService(intent);
        //直接闪
//        int i = 10;
//        while (i>0) {
//            try {
//                Thread.sleep(50);
//                if (!isFlash) {
//                    c.openFlash();
//                    isFlash = true;
//                } else {
//                    c.closeFlash();
//                    isFlash = false;
//                }
//            } catch (Exception e) {
//
//            }
//            i--;
//        }
    }

    public void OnCloseClick(View view){
//        c.closeFlash();
    }

    public File getFiles(String aName){
        //任何时候都不要硬编码文件路径，可能存在安全隐患 也可能出现适配问题
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), aName);
        if(!file.mkdirs()){
            Log.e( "directory", "Directory not created");
        }
        return file;
    }

    //检查外部存储，必须检查外部存储的可用性
    //读写检查
    public boolean isExternalStorageWriteable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }

    //只读检查
    public boolean isExternalStorageReadable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        }
        return false;
    }

    public void updateSettingAsync(){
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("", "");
        //apply在频繁存储的情况下 比commit性能要好 commit是直接存磁盘中 apply是先存内存再存磁盘  如果需要立刻使用存储数据的话 还是用commit
        editor.apply();

    }

    public void updateSetting(){
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(!editor.commit()){
            Log.e("MainActivity", "Failed to commit setting changes");
        }
    }

    //Cursor一定要记得关闭 不管使用情况 在退出的时候一定要关闭
    public void handlePhotos(SQLiteDatabase db, String userId){
        Cursor cursor = null;
        try {
//            cursor = db.query(TUserPhoto, new String[]{"userId", "content"}, "userId=?", new String[]{userId},null, null, null);
            while (cursor.moveToNext()){

            }
        }catch (Exception e){

        }finally {
            if(cursor != null){
                cursor.close();
            }
        }

    }

    public void insertUserPhoto(SQLiteDatabase db, String userId, String content){
        ContentValues cv = new ContentValues();
        cv.put("userId", userId);
        cv.put("content", content);
        //手动设置开始事务 避免每一条insert自动开启一条事务
        db.beginTransaction();
        try {
//            db.insert(TUserPhoto, null, cv);
            //Something
            //提交事务
            db.setTransactionSuccessful();
        }catch (Exception e){

        }finally {
            //结束事务
            db.endTransaction();
        }
    }

    //加载大图片或者一次性多张图片 在异步线程中进行
    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(Integer... integers) {
            final Bitmap bitmap = BitmapFactory.decodeFile("some path");
            return bitmap;
        }
    }

}
