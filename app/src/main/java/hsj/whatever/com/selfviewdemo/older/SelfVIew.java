package hsj.whatever.com.selfviewdemo.older;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 韩书剑 on 2017/5/1.
 * Version 1.0
 */

public class SelfVIew extends View{

    public SelfVIew(Context context) {
        super(context);
    }

    public SelfVIew(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    public SelfVIew(Context context, AttributeSet attributeSet, int defStyle){
        super(context,attributeSet,defStyle);
    }


    @Override
    protected  void onMeasure(int width, int height){
        setMeasuredDimension(
                MeasureWidth(width),
                MeasureHeight(height));

    }

    private int MeasureWidth(int width){
        int result = 0;
        int specMode = MeasureSpec.getMode(width);
        int specSize = MeasureSpec.getSize(width);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 100;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    private int MeasureHeight(int height){
        int result = 0;
        int specMode = MeasureSpec.getMode(height);
        int specSize = MeasureSpec.getSize(height);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 100;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
//        Toast.makeText(getContext(),"width="+ width + "height=" + height,Toast.LENGTH_LONG).show();
        Log.e("selfview","width="+ width + "height=" + height);
    }
}
