package hsj.whatever.com.selfviewdemo.image;

import android.app.Activity;
import android.os.Bundle;

import hsj.whatever.com.selfviewdemo.R;

/**
 * Created by HSJ on 2017/10/24.
 * Version 1.0
 */

public class TurnActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TurnImage(this));
    }
}
