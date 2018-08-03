package com.qfedu.domain.oss;


import java.util.Date;

public class OSSPo {
    private int id;
    private String objname;
    private Long period;
    private Date createtime;
    private String ourl;

    public OSSPo() {
    }

    public OSSPo(int id, String objname, Long period, Date createtime, String ourl) {
        this.id = id;
        this.objname = objname;
        this.period = period;
        this.createtime = createtime;
        this.ourl = ourl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjname() {
        return objname;
    }

    public void setObjname(String objname) {
        this.objname = objname;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOurl() {
        return ourl;
    }

    public void setOurl(String ourl) {
        this.ourl = ourl;
    }
}
