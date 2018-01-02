package hsj.whatever.com.selfviewdemo.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import hsj.whatever.com.selfviewdemo.R;


/**
 * Created by HSJ on 2018/1/2.
 * Version 1.0
 */

public class DropActivity extends Activity {

    @BindView(R.id.hidden_view)
    LinearLayout hiddenView;
    float mDensity;
    int mHiddenViewMeasuredHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_drop);
        ButterKnife.bind(this);

        //
        mDensity = getResources().getDisplayMetrics().density;

        mHiddenViewMeasuredHeight = (int)(mDensity * 40 + 0.5);
    }

    public void llClick(View v) {

        if(hiddenView.getVisibility() == View.GONE){
            animateOpen(hiddenView);
        }else{
            animateClose(hiddenView);
        }
    }

    private void animateOpen(final View view){
        view.setVisibility(View.VISIBLE);
        ValueAnimator animator = createDropAnimator(
                view,
                0,
                mHiddenViewMeasuredHeight
        );
        animator.start();
    }

    private void animateClose(final View view){
        int origHeight = view.getHeight();
        ValueAnimator animator = createDropAnimator(
                view, origHeight, 0
        );
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.GONE);
            }
        });
        animator.start();
    }

    private ValueAnimator createDropAnimator(final View view, int start, int end){
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (Integer)valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }
}
