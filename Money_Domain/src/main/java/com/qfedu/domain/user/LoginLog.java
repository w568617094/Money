package com.qfedu.domain.user;

import javax.xml.crypto.Data;

public class LoginLog {
private int id;
private String ip;
private Data createtime;
private int uid;
private String msg;

    public LoginLog() {
    }

    public LoginLog(int id, String ip, Data createtime, int uid, String msg) {
        this.id = id;
        this.ip = ip;
        this.createtime = createtime;
        this.uid = uid;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Data getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Data createtime) {
        this.createtime = createtime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
