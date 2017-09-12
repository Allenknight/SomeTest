package hsj.whatever.com.selfviewdemo.older;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Scroller;

/**
 * Created by HSJ on 2017/6/20.
 * Version 1.0
 */

public class ScrollView extends ViewGroup{

    int mSceenHeight;
    private Scroller mScroller;

    ListView mListview;


    public ScrollView(Context context) {
        super(context);
    }

    public ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Context context){
        WindowManager wm = (WindowManager)context.getSystemService(
                Context.WINDOW_SERVICE
        );
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mSceenHeight = dm.heightPixels;
        mScroller = new Scroller(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int childCount = getChildCount();

        MarginLayoutParams mlp = (MarginLayoutParams)getLayoutParams();
        mlp.height = mSceenHeight * childCount;
        setLayoutParams(mlp);
        for(int i=0; i<childCount; i++){
            View child = getChildAt(i);
            if(child.getVisibility() != View.GONE){
                child.layout(1, i * mSceenHeight,
                        r, (i+1)* mSceenHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//
//                break;
//            default:
//                break;
//        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for(int i = 0; i < count; i ++){
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }
}
