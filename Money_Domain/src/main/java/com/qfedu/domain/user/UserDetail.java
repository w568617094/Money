package com.qfedu.domain.user;

import java.util.Date;

public class UserDetail {
    private int id;
    private  int uid;
    private String realname;
    private String sex;
    private String idnumber;
    private Date birthdate;
    private Date Createtime;
    private int flag;

    public UserDetail() {
    }

    public UserDetail(int id, int uid, String realname, String sex, String idnumber, Date birthdate, Date createtime, int flag) {
        this.id = id;
        this.uid = uid;
        this.realname = realname;
        this.sex = sex;
        this.idnumber = idnumber;
        this.birthdate = birthdate;
        Createtime = createtime;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getCreatetime() {
        return Createtime;
    }

    public void setCreatetime(Date createtime) {
        Createtime = createtime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
