package hsj.whatever.com.selfviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by HSJ on 2017/10/15.
 * Version 1.0
 */

public class dragView extends View{
    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public dragView(Context context) {
        super(context);
        initView(context);
    }

    public dragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public dragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        setBackgroundColor(Color.BLUE);
        mScroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offSetX = x - lastX;
                int offSetY = y - lastY;
                layout(getLeft() + offSetX, getTop() + offSetY, getRight() + offSetX, getBottom() + offSetY);
                break;
            case MotionEvent.ACTION_UP:
                View viewGroup = ((View)getParent());
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY()
                );
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //判断Scroller是否执行完毕
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY()
            );
            //重绘
            invalidate();
        }
    }
}
