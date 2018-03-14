package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by HSJ on 2017/10/15.
 * Version 1.0
 */

public class MainActivity4 extends Activity{

    View v;

    int lastX;
    int lastY;
    
    ImageView mImageView;

    private LruCache<String, Bitmap> mMemoryCache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.move_layout_view);
        setContentView(R.layout.layout_drag_view);


        final int maxMemory = (int)(Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize = maxMemory/8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount()/1024;
            }
        };

//        v = (View)findViewById(R.id.v_view);
//        v.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int x = (int)event.getRawX();
//                int y = (int)event.getRawY();
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        lastX = x;
//                        lastY = y;
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int offSetX = x - lastX;
//                        int offSetY = y - lastY;
////                        v.layout(v.getLeft() + offSetX, v.getTop() + offSetY, v.getRight() + offSetX, v.getBottom() + offSetY);
//                        lastX = x;
//                        lastY = y;
//                        ((View)v.getParent()).scrollBy(-offSetX, -offSetY);
//                        break;
//                }
//
//                return true;
//            }
//        });
        Bitmap bitmap = null;
        //使用bitmap
        if(Build.VERSION.SDK_INT <= 10){
            bitmap.recycle();
        }
        bitmap = null;

    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap){
        if(getBitmapFromMemCache(key) == null){
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key){
        return mMemoryCache.get(key);
    }
    
    public void loadBitmap(int resId, ImageView imageView){
        final String imageKey = String.valueOf(resId);
        final Bitmap bitmap = getBitmapFromMemCache(imageKey);
        if(bitmap != null){
            mImageView.setImageBitmap(bitmap);
        }else{
            mImageView.setImageResource(R.drawable.animated);
            BitmapWorkerTask task = new BitmapWorkerTask(mImageView);
            task.execute(resId);
        }
    }
    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap>{

        public BitmapWorkerTask(ImageView mImageView) {
        }

        //图片解码
        @Override
        protected Bitmap doInBackground(Integer... integers) {
            final Bitmap bitmap = decodeSampledBitmapFromResource(getResources(), integers[0], 100, 100);
            addBitmapToMemoryCache(String.valueOf(integers[0]), bitmap);
            return bitmap;
        }
    }

    //压缩图片
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
        //首先通过inJustDecodeBounds=true获得图片尺寸
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        //然后根据图片分辨率以及实际需要的大小，计算压缩率
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        //设置压缩率，解码
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
