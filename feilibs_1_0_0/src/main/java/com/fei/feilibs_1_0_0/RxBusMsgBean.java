package com.fei.feilibs_1_0_0;

public class RxBusMsgBean {
    private String msg;

    public String getMsg() {
        //如果是String类型，那么判断是否为空，为空返回"",否则返回字段值本身
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
