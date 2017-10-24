package hsj.whatever.com.selfviewdemo.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HSJ on 2017/10/24.
 * Version 1.0
 */

public class LinearGradientt extends View{

    public LinearGradientt(Context context) {
        super(context);
    }

    public LinearGradientt(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearGradientt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*super.onDraw(canvas);*/
        Paint paint = new Paint();
        paint.setShader(new android.graphics.LinearGradient(0, 0, 400, 400, Color.BLUE, Color.YELLOW, Shader.TileMode.REPEAT));
        canvas.drawRect(0, 0, 400, 400, paint);
    }
}
