package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hsj.whatever.com.selfviewdemo.adp.ListViewAdp;

/**
 * Created by HSJ on 2017/6/25.
 * Version 1.0
 */

public class listviewActivity extends Activity {

    myListView myListview;

    List<String> mylist = new ArrayList<>();

    ListViewAdp mAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        for(int i = 0; i  < 20; i++){
            mylist.add(i+"");
        }
        mAdp = new ListViewAdp(this, mylist);
        myListview = (myListView) findViewById(R.id.my_list);
        myListview.setAdapter(mAdp);

//        myListview.setSelection(2);
//        myListview.smoothScrollToPosition(19);
        myListview.setEmptyView(findViewById(R.id.iv_empty));

        myListview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        //触摸
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //移动
                        break;
                    case MotionEvent.ACTION_UP:
                        //离开
                        break;

                }
                return false;
            }
        });

        myListview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //  滑动时
            }
        });
    }


}
