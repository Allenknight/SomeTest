package hsj.whatever.com.selfviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by HSJ on 2017/6/25.
 * Version 1.0
 */

public class myListView extends ListView{

    private Context mContext;

private static int mMaxOverScrollY = 50;

    public myListView(Context context) {
        super(context);

        mContext = context;
        initView();
    }

    public myListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        initView();
    }

    public myListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView(){
        DisplayMetrics metric = mContext.getResources().getDisplayMetrics();
        float desity =metric.density;
        mMaxOverScrollY = (int)(desity * mMaxOverScrollY);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverScrollY, isTouchEvent);
    }
}
