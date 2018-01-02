package hsj.whatever.com.selfviewdemo.anim;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2017/12/13.
 * Version 1.0
 */

public class AnimActivity2 extends Activity {

    @BindView(R.id.image)
    ImageView mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_2);
        ButterKnife.bind(this);
        Drawable drawable = mImage.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}
