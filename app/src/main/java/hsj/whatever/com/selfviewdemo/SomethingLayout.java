package hsj.whatever.com.selfviewdemo;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * viewGroup
 * Created by AllenHan on 2018/3/9.
 */

public class SomethingLayout extends ViewGroup{

    final static String TAG = "SomethingLayout";

    public SomethingLayout(Context context) {
        super(context);
    }

    public SomethingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SomethingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SomethingLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        MarginLayoutParams params = null;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //开始处理warp_content 如果一个子元素都没有，设置为0
        if(getChildCount() == 0){
            setMeasuredDimension(0 , 0);
        }else if(widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            //ViewGroup 宽，高都是wrap_content  这里宽度是子控件的宽度 高度是所有子控件的总和
            View childOne = getChildAt(0);
            params = (MarginLayoutParams)childOne.getLayoutParams();
            int childWidth = childOne.getMeasuredWidth();
            int childHeight = childOne.getMeasuredHeight();

//            setMeasuredDimension(childWidth, childHeight * getChildCount());

            setMeasuredDimension(childWidth + params.leftMargin + params.rightMargin,
                                childHeight * getChildCount() + params.topMargin + params.bottomMargin);

        }else if(widthMode == MeasureSpec.AT_MOST){
            //ViewGroup的宽度为wrap_content 则高度不管 宽度还是控件宽度
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth();
            params = (MarginLayoutParams)childOne.getLayoutParams();
//            setMeasuredDimension(childWidth, heightSize);
            setMeasuredDimension(childWidth + params.leftMargin + params.rightMargin, heightSize);
        }else if(heightMode == MeasureSpec.AT_MOST){
            //ViewGroup的高度为wrap_content,则宽度不需要管,高度为子View的高度和
            View childOne = getChildAt(0);
            int childHeight = childOne.getMeasuredHeight();
            params = (MarginLayoutParams)childOne.getLayoutParams();
//            setMeasuredDimension(widthSize, childHeight * getChildCount());
            setMeasuredDimension(widthSize, childHeight * getChildCount() + params.topMargin + params.bottomMargin);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int height = 0;
        int count = getChildCount();
        View child;
        Log.e(TAG, count + "");
//        for(int i = 0; i < count; i++){
//            child = getChildAt(i);
//            child.layout(0, height, child.getMeasuredWidth(), height + child.getMeasuredHeight());
//            height += child.getMeasuredHeight();
//        }

        child = getChildAt(0);
        MarginLayoutParams params = (MarginLayoutParams)child.getLayoutParams();
        int c1 = params.leftMargin;
        int c2 = params.topMargin;
        int c3 = c1 + child.getMeasuredWidth();
        int c4 = c2 + child.getMeasuredHeight();
        child.layout(c1, c2, c3, c4);
        height = c4 + params.bottomMargin;
        for(int i = 0; i < count ; i ++){
            child = getChildAt(i);
            child.layout(c1, height, c3, height + child.getMeasuredHeight());
            height += child.getMeasuredHeight();
        }

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
//        return super.generateLayoutParams(attrs);
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
//        return super.generateDefaultLayoutParams();
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
//        return super.generateLayoutParams(p);
        return new MarginLayoutParams(p);
    }
}
