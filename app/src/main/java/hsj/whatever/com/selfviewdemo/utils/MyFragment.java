package hsj.whatever.com.selfviewdemo.utils;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by AllenHan on 2018/3/22.
 */

public class MyFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 配置变化时保存这个fragment
        setRetainInstance(true);
    }


}
