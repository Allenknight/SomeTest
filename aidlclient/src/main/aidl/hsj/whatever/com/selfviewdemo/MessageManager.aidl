package hsj.whatever.com.selfviewdemo;
//定义方法接口
import hsj.whatever.com.selfviewdemo.MessageBean;

interface MessageManager{

    MessageBean getMessage();

    void sendMessage(in MessageBean msg);

}