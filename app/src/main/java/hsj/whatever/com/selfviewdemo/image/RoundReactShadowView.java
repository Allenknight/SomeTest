package hsj.whatever.com.selfviewdemo.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2017/10/24.
 * Version 1.0
 */

public class RoundReactShadowView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;
    private BitmapShader mBitmapShader;

    public RoundReactShadowView(Context context) {
        super(context);
    }

    public RoundReactShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundReactShadowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.theking);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        mPaint = new Paint();
        mPaint.setShader(mBitmapShader);
        canvas.drawCircle(500, 250, 200, mPaint);


    }
}
