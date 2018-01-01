package hsj.whatever.com.selfviewdemo.anim;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2017/11/15.
 * Version 1.0
 */

public class animActivity extends Activity{
    LinearLayout btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initView();
    }

    public void initView(){
        btn = (LinearLayout)findViewById(R.id.ll);
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1  );
        sa.setDuration(20000);
        LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5F);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        btn.setLayoutAnimation(lac);
    }

    //透明度变换
    public void Alpha(View view){
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1000);
        view.startAnimation(aa);
        btn.setVisibility(View.GONE);
    }

    //旋转
    public void Rotate(View view){
        RotateAnimation ra = new RotateAnimation(0, 360, 100, 100);
        ra.setDuration(1000);
        view.startAnimation(ra);
        btn.setVisibility(View.VISIBLE);
    }

    //自身旋转
    public void RotateSelf(View view){
        RotateAnimation ra = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5F, //位置 or height & width
                RotateAnimation.RELATIVE_TO_SELF, 0.5F);
        ra.setDuration(1000);
        view.startAnimation(ra);
    }

    //位移
    public void Translate(View view){
        TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 0);
        ta.setDuration(1000);
        view.startAnimation(ta);
    }

    //缩放
    public void Scale(View view){
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        sa.setDuration(1000);
        view.startAnimation(sa);
    }

    //变位置缩放
    public void ScaleSelf(View view){
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 1F,
                Animation.RELATIVE_TO_SELF, 0.5F);
        sa.setDuration(1000);
        view.startAnimation(sa);
    }

    //动画集合
    public void AnimSet(View view){
        AnimationSet as = new AnimationSet(true);
        as.setDuration(1000);

        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1000);
        as.addAnimation(aa);

        RotateAnimation ra = new RotateAnimation(0, 360, 100, 100);
        ra.setDuration(1000);
        as.addAnimation(ra);

        view.startAnimation(as);

    }
}
