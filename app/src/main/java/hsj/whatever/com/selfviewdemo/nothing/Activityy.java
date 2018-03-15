package hsj.whatever.com.selfviewdemo.nothing;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
    }
}
