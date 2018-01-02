package hsj.whatever.com.selfviewdemo.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2018/1/2.
 * Version 1.0
 */

public class Menu extends Activity {

    @BindView(R.id.imageView_b)
    ImageView imageViewB;
    @BindView(R.id.imageView_c)
    ImageView imageViewC;
    @BindView(R.id.imageView_d)
    ImageView imageViewD;
    @BindView(R.id.imageView_e)
    ImageView imageViewE;
    @BindView(R.id.imageView_a)
    ImageView imageViewA;

    boolean flag = true;

    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_menu);
        ButterKnife.bind(this);

        mImageViews.add(imageViewA);
        mImageViews.add(imageViewB);
        mImageViews.add(imageViewC);
        mImageViews.add(imageViewD);
        mImageViews.add(imageViewE);


    }

    @OnClick(R.id.imageView_a)
    public void onImageViewClick(View v){
        switch (v.getId()){
            case R.id.imageView_a:
                if(flag){
                    startAnim();
                }else{
                    closeAnim();
                }
                break;
            default:
                break;
        }
    }

    public void startAnim(){
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                mImageViews.get(0),
                "alpha",
                1F,
                0.5F
        );
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImageViews.get(1),
                "translationY",
                200F
        );
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImageViews.get(2),
                "translationX",
                200F
        );
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImageViews.get(3),
                "translationY",
                -200F
        );
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImageViews.get(4),
                "translationX",
                -200F
        );
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4
        );
        set.start();
        flag = false;
    }

    public void closeAnim(){
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                mImageViews.get(0),
                "alpha",
                0.5F,
                1F
        );
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImageViews.get(1),
                "translationY",
                200F, 0
        );
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImageViews.get(2),
                "translationX",
                200F, 0
        );
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImageViews.get(3),
                "translationY",
                -200F,0
        );
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImageViews.get(4),
                "translationX",
                -200F,0
        );
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4
        );
        set.start();
        flag = true;
    }
}
