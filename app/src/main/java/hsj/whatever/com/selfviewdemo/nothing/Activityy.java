package hsj.whatever.com.selfviewdemo.nothing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.internal.Utils;
import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2018/3/15.
 * Version 1.0
 */

public class Activityy extends Activity{
    private ImageView mImageView;
    private Animation mAnimation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAnimation = AnimationUtils.loadAnimation(this, R.anim.error_frame_in);
        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //判断资源是否已经被释放
                if(mImageView != null){
                    mImageView.clearAnimation();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImageView.startAnimation(mAnimation);

        //延迟释放
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mImageView != null){
                    mImageView.clearAnimation();
                }
            }
        }, mAnimation.getDuration());
    }

//    public static Bitmap decodeSampledBitmapFromFile(String filename, int reqWidth, int reqHeight, ImageCache cache){
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//
//        BitmapFactory.decodeFile(filename, options);
//
//        //判断版本
//        if(Utils.hasHoneycomb()){
//            addInBitmapOptions(options,cache);
//        }
//        return BitmapFactory.decodeFile(filename, options);
//    }
//
//    private static void addInBitmapOptions(BitmapFactory.Options options, ImageCache cache){
//        //inBitmap只处理可变的位图，所以强制返回可变的位图
//        options.inMutable =true;
//        if(cache != null){
//            Bitmap inBitmap = cache.getBitmapFromReusableSet(options);
//
//        }
//        options = new BitmapFactory.Options();
//        options.inSampleSize = 1;
//        options.inMutable = true;
//        inBitmap = BitmapFactory.decodeFile(path, options);
//        setImageBitmap(inBitmap);
//        options.inBitmap = inBitmap2;
//    }

    public static Bitmap drawableToBitmap(Drawable drawable){
        if(drawable == null){
            return null;
        }
        if(drawable instanceof BitmapDrawable){
            return ((BitmapDrawable)drawable).getBitmap();
        }
        try{
            Bitmap bitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return null;
        }
    }

}


