package hsj.whatever.com.selfviewdemo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import hsj.whatever.com.selfviewdemo.older.ThirdView;

public class MainActivity extends AppCompatActivity {
    ThirdView llll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.merge_xml);

//        llll = (ThirdView)findViewById(R.id.llll);
//        llll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                if(getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null){
//                    try {
//                        startActivity(intent);
//                    }catch (ActivityNotFoundException e){
//
//                    }
//                }
//            }
//        });

//        Intent intent = new Intent(Intent.ACTION_VIEW);
////        intent.setData()
//        if(getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null){
//            try {
//                startActivity(intent);
//            }catch (ActivityNotFoundException e){
//
//            }
//        }
//        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new SweetAlertDialog(MainActivity.this)
//                        .setTitleText("Title")
//                        .setContentText("just show")
//                        .setConfirmText("ops")
//                        .show();
//            }
//        });
    }

    public void OnClick(View view) {
        ((ViewStub)findViewById(R.id.vs_1)).inflate();
    }
}
