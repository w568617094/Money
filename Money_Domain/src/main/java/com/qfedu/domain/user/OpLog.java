package com.qfedu.domain.user;

import java.util.Date;

public class OpLog {
    private int id;
    private Date createtime;
    private int type;
    private String msg;

    public OpLog() {
    }

    public OpLog(int id, Date createtime, int type, String msg) {
        this.id = id;
        this.createtime = createtime;
        this.type = type;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
