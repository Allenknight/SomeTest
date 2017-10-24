package hsj.whatever.com.selfviewdemo.image;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by HSJ on 2017/10/24.
 * Version 1.0
 */

public class SurfaceVView extends SurfaceView implements SurfaceHolder.Callback, Runnable{

    public SurfaceVView(Context context) {
        super(context);
    }

    public SurfaceVView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SurfaceVView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void run() {

    }
}
