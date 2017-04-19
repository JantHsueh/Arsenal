package cn.xuexuan.newui.model.event;

/**
 * Created by Jant on 2017/4/17.
 */

public class Event {


    public Object mObject;
    public int mMessageType;


    public Event(Object object, int messageType) {
        mObject = object;
        mMessageType = messageType;
    }
}
