package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

import java.io.File;

import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import hsj.whatever.com.selfviewdemo.older.ThirdView;

public class MainActivity extends AppCompatActivity {
    ThirdView llll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.merge_xml);

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
        ((ViewStub)findViewById(R.id.vs_1)).inflate();
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
}
