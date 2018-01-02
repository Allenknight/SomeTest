package hsj.whatever.com.selfviewdemo.anim;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2018/1/2.
 * Version 1.0
 */

public class TimeJumpActivity extends Activity {
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_jump);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.textView)
    public void onTextViewClick(View v){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        textView.setText("$" + (Integer)animation.getAnimatedValue());
                    }
                }
        );
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }
}
