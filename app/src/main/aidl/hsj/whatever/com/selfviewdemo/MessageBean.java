package hsj.whatever.com.selfviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AllenHan on 2017/11/1.
 */

public class MessageBean implements Parcelable{

    private String messageContent;
    private String messageTitle;

    public MessageBean(){

    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTitle(){
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle){
        this.messageTitle = messageTitle;
    }

    protected MessageBean(Parcel in) {
        messageContent = in.readString();
        messageTitle = in.readString();
    }

    public static final Creator<MessageBean> CREATOR = new Creator<MessageBean>() {
        @Override
        public MessageBean createFromParcel(Parcel in) {
            return new MessageBean(in);
        }

        @Override
        public MessageBean[] newArray(int size) {
            return new MessageBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(messageContent);
        dest.writeString(messageTitle);
    }

    @Override
    public String toString() {
        return "Title:" + messageTitle + ", Content:" + messageContent;
    }
}
