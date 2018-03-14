package hsj.whatever.com.selfviewdemo.utils;


import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;

/**
 * Created by AllenHan on 2018/3/13.
 */

public class ControlFlash {

    public Camera camera = null;
    public Camera.Parameters parameters = null;

    public Context context;

    public ControlFlash(Context context){
        this.context = context;
        camera = Camera.open();
        parameters = camera.getParameters();
    }

    public boolean IsHaveFlash(){
        return !context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public void openFlash(){
        if(IsHaveFlash()){
            return;
        }
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();;
    }

    public void closeFlash(){
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
    }

}
