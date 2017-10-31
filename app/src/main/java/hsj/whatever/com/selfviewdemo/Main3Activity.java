package hsj.whatever.com.selfviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by HSJ on 2017/9/12.
 * Version 1.0
 */

public class Main3Activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_move_layout);
        initView();
    }

    private void initView(){

        Handler uiHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

            }
        };

    }

    class DownloadThread extends Thread{
        @Override
        public void run() {
            try{
                System.out.println("DownloadThread id " + Thread.currentThread().getId());
                System.out.println("开始下载文件");
                //此处让线程DownloadThread休眠5秒中，模拟文件的耗时过程
                Thread.sleep(5000);
                System.out.println("文件下载完成");
                //文件下载完成后更新UI
                Message msg = new Message();
                //虽然Message的构造函数式public的，我们也可以通过以下两种方式通过循环对象获取Message
                //msg = Message.obtain(uiHandler);
                //msg = uiHandler.obtainMessage();

                //what是我们自定义的一个Message的识别码，以便于在Handler的handleMessage方法中根据what识别
                //出不同的Message，以便我们做出不同的处理操作
                msg.what = 1;

                //我们可以通过arg1和arg2给Message传入简单的数据
                msg.arg1 = 123;
                msg.arg2 = 321;
                //我们也可以通过给obj赋值Object类型传递向Message传入任意数据
                //msg.obj = null;
                //我们还可以通过setData方法和getData方法向Message中写入和读取Bundle类型的数据
                //msg.setData(null);
                //Bundle data = msg.getData();

                //将该Message发送给对应的Handler
//                uiHandler.sendMessage(msg);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    class DDThread extends Thread{

        @Override
        public void run() {
//            super.run();
            Message msg = new Message();
//        msg.sss = 1;
            msg.what = 1;
            msg.arg1 = 1;
//            msg.org = "";
//            msg.obj =

//                    uiHandler.sendMessage(msg);
        }


    }
}
