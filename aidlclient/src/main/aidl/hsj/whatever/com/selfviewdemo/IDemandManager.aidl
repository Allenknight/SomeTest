package hsj.whatever.com.selfviewdemo;

import hsj.whatever.com.selfviewdemo.MessageBean;
import hsj.whatever.com.selfviewdemo.IDemandListener;

interface IDemandManager{

    MessageBean getDemand();

    void setDemandIn(in MessageBean msg);

    void setDemandOut(out MessageBean msg);

    void setDemandInOut(inout MessageBean msg);

    void registerListener(IDemandListener listener);

    void unregisterListener(IDemandListener listener);


    }
