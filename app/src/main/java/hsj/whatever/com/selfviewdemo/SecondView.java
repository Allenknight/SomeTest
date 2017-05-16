package hsj.whatever.com.selfviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by HSJ on 2017/5/2.
 * Version 1.0
 */

public class SecondView extends TextView{

    private Paint mPaint1, mPaint2;

    public SecondView(Context context) {
        super(context);
        initView();
    }

    public SecondView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SecondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(getResources().getColor(android.R.color.holo_orange_light));
        mPaint2.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(
                0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1
        );
        canvas.drawRect(
                10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2
        );
        canvas.save();
        canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
