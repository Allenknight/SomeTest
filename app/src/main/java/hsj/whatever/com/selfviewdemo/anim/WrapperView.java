package hsj.whatever.com.selfviewdemo.anim;

import android.view.View;

/**
 * Created by HSJ on 2017/11/29.
 * Version 1.0
 */

public class WrapperView{

    private View mTarget;

    public WrapperView(View target){
        mTarget = target;
    }

    public int getWidth(){
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width){
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}
