package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by HSJ on 2017/10/15.
 * Version 1.0
 */

public class MainActivity4 extends Activity{

    View v;

    int lastX;
    int lastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.move_layout_view);
        setContentView(R.layout.layout_drag_view);

//        v = (View)findViewById(R.id.v_view);
//        v.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int x = (int)event.getRawX();
//                int y = (int)event.getRawY();
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        lastX = x;
//                        lastY = y;
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int offSetX = x - lastX;
//                        int offSetY = y - lastY;
////                        v.layout(v.getLeft() + offSetX, v.getTop() + offSetY, v.getRight() + offSetX, v.getBottom() + offSetY);
//                        lastX = x;
//                        lastY = y;
//                        ((View)v.getParent()).scrollBy(-offSetX, -offSetY);
//                        break;
//                }
//
//                return true;
//            }
//        });


    }
}
