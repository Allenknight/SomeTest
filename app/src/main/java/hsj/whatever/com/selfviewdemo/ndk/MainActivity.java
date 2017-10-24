package hsj.whatever.com.selfviewdemo.ndk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2017/9/23.
 * Version 1.0
 */

public class MainActivity extends AppCompatActivity{

    TextView tvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk_main);

        tvText = (TextView)findViewById(R.id.tv_the_text);
        NdkJniUtils jni = new NdkJniUtils();

        tvText.setText(jni.getCLanguageString());
    }
}
