package hsj.whatever.com.selfviewdemo.nothing;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import javax.crypto.spec.IvParameterSpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import butterknife.internal.Utils;
import hsj.whatever.com.selfviewdemo.MainActiviy5;
import hsj.whatever.com.selfviewdemo.R;

import static android.view.WindowManager.LayoutParams.FLAG_SECURE;

/**
 * Created by HSJ on 2018/3/15.
 * Version 1.0
 */

public class Activityy extends Activity{
    private ImageView mImageView;
    private Animation mAnimation;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //禁止录屏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

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


        Intent intent = new Intent(this, MainActiviy5.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        try{
            pendingIntent.send();
        }catch(PendingIntent.CanceledException e){
            e.printStackTrace();
        }

//        IvParameterSpec

        byte[] rand = new byte[16];
        SecureRandom r = new SecureRandom();
        r.nextBytes(rand);
        IvParameterSpec iv = new IvParameterSpec(rand);

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        threadLocalRandom.nextInt(5);


        HostnameVerifier hnv = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                if("yourhostname".equals(hostname)){
                    return true;
                }else{
                    HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
                    return hv.verify(hostname, session);
                }

            }
        };

        Intent intent1 = null;
        String uri = "asdf";
        try {
            intent1 = Intent.parseUri(uri, Intent.URI_INTENT_SCHEME);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        intent1.addCategory("android.intent.category.BROWSABLE");
        intent1.setComponent(null);
        intent1.setSelector(null);
        this.startActivityIfNeeded(intent1, -1);

//        getWindow().setFlags(FLAG_SECURE);

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


