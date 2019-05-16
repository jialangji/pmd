package com.jlj.pmd.news;

/**
 * effect :
 * Created by Cattle_Wei on 2018/12/10.
 */
public class RangBarEvent {
    private int leftmsg;
    private int type;
    private int rightmsg;

    public RangBarEvent(int str,int str2, int type) {
        leftmsg = str;
        this.type = type;
        rightmsg=str2;
    }

    public int getMsg() {
        return leftmsg;
    }

    public int getType(){
        return type;
    }

    public int getRight(){
        return rightmsg;
    }
}
