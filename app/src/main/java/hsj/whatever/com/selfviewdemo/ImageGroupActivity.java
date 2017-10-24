package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HSJ on 2017/10/23.
 * Version 1.0
 */

public class ImageGroupActivity extends Activity{

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.gv_image)
    GridLayout gvImage;
    Bitmap bitmap;

    int mEtWidth;
    int mEtHeight;
    private EditText[] mEts = new EditText[20];
    private float[] mColorMatrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_color_matrix);
        ButterKnife.bind(this);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.theking);
        ivImage.setImageBitmap(bitmap);

        gvImage.post(new Runnable() {
            @Override
            public void run() {
                mEtHeight = gvImage.getWidth()/5;
                mEtWidth = gvImage.getHeight()/4;
                addEts();
                initMatrix();

            }
        });
    }

    private void addEts(){
        for(int i = 0; i < 20; i++){
            EditText editText = new EditText(ImageGroupActivity.this);
            mEts[i] = editText;
            gvImage.addView(editText, mEtWidth, mEtHeight);
        }
    }

    private void initMatrix(){
        for(int i = 0; i< 20; i++){
            if(i%6 == 0){
                mEts[i].setText(String.valueOf(1));
            }else{
                mEts[i].setText(String.valueOf(0));
            }
        }
    }

    private void getMatrix(){
        for(int i = 0; i< 20 ; i ++){
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());
        }
    }

    private void setImageMatrix(){
        Bitmap bmp = Bitmap.createBitmap(
                bitmap.getWidth(),
                bitmap.getHeight(),
                Bitmap.Config.ARGB_8888
        );

        ColorMatrix colorMatrix =
                new ColorMatrix();
        colorMatrix.set(mColorMatrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        ivImage.setImageBitmap(bmp);
    }

}
