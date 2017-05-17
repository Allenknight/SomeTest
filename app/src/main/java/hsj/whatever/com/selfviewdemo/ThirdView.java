package hsj.whatever.com.selfviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by HSJ on 2017/5/17.
 * Version 1.0
 */

public class ThirdView extends TextView{

    private Paint mPaint;

    private int mViewWidth = 0;
    private int mTranslate = 0;

    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;

    public ThirdView(Context context) {
        super(context);
    }

    public ThirdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(mViewWidth == 0){
            mViewWidth = getMeasuredWidth();
            if(mViewWidth > 0){
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(
                        0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{
                                Color.BLUE, 0xffffffff,
                                Color.BLUE
                        },
                        null,
                        Shader.TileMode.CLAMP
                );
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mGradientMatrix != null){
            mTranslate += mViewWidth/5;
            if(mTranslate > 2*mViewWidth){
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }

    }
}
