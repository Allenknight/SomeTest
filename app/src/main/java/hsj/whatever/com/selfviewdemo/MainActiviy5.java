package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by HSJ on 2018/3/7.
 * Version 1.0
 */

public class MainActiviy5 extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    ProgressBar progressBar;
    Button btn1;

    private LocalBroadcastManager mLocalBroadcastManager;
    private MyBroadcastReceiver mBroadcastReceiver;
    public final static String ACRION_TYPE_THREAD = "action.type.thread";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_service_activity);

        tv1 = (TextView)findViewById(R.id.textView2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        tv2 = (TextView)findViewById(R.id.textView3);
        btn1 = (Button)findViewById(R.id.button);

        //注册广播
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACRION_TYPE_THREAD);
        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);

        initView();
    }

    public void initView(){
        tv1.setText("线程状态：未运行");
        progressBar.setMax(100);
        progressBar.setProgress(0);
        tv2.setText("0%");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
    }

    public class MyBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case ACRION_TYPE_THREAD:
                    int progress = intent.getIntExtra("progress", 0);
                    tv1.setText("线程状态：" + intent.getStringExtra("status"));
                    progressBar.setProgress(progress);
                    tv2.setText(progress + "%");
                    if(progress >= 100){
                        tv1.setText("线程结束");
                    }
                    break;
            }
        }
    }

    public void onClick(View view){
        Intent intent = new Intent(MainActiviy5.this, MyIntentService.class);
        startService(intent);
    }
}
