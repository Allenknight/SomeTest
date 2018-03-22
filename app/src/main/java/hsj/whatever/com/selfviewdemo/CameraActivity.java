package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by AllenHan on 2018/3/22.
 */

public class CameraActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCameraClick(){

//        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
//        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
//        Uri imageUri = FileProvider.getUriForFile(context, "com.jph.takephoto.fileprovider", file);//通过FileProvider创建一个content类型的Uri
//        Intent intent = new Intent();
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
//        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//将拍取的照片保存到指定URI
//        startActivityForResult(intent,1006);


        File file = new File(Environment.getExternalStorageDirectory(), "/temp/"+ System.currentTimeMillis() + ".jpg");
        if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
        //通过FileProvider创建一个content类型的Uri
        Uri imageUri = FileProvider.getUriForFile(this, "hsj.whatever.com.selfviewdemo", file);
        Intent intent = new Intent();
        //临时授权目标应用 uri所代表文件
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        //Action设置为拍照
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        //照片保存
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent,1005);

//
//        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
//        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
//        Uri outputUri = Uri.fromFile(file);
//        Uri imageUri=Uri.fromFile(new File("/storage/emulated/0/temp/1474960080319.jpg"));
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.setDataAndType(imageUri, "image/*");
//        intent.putExtra("crop", "true");
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        intent.putExtra("scale", true);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//        intent.putExtra("noFaceDetection", true); // no face detection
//        startActivityForResult(intent,1008);
//
//        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
//        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
//        Uri outputUri = FileProvider.getUriForFile(context, "com.jph.takephoto.fileprovider",file);
//        Uri imageUri=FileProvider.getUriForFile(context, "com.jph.takephoto.fileprovider", new File("/storage/emulated/0/temp/1474960080319.jpg");//通过FileProvider创建一个content类型的Uri
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        intent.setDataAndType(imageUri, "image/*");
//        intent.putExtra("crop", "true");
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        intent.putExtra("scale", true);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//        intent.putExtra("noFaceDetection", true); // no face detection
//        startActivityForResult(intent,1008);

    }
}
