package com.qfedu.domain.admin;

public class SysConfig {
    private Long id;
    private String key;
    private String value;
    private String remark;
    private Byte status;
    public SysConfig() {
    }

    public SysConfig(Long id, String key, String value, String remark, Byte status) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.remark = remark;
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
