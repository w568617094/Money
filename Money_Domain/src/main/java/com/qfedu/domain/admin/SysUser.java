package com.qfedu.domain.admin;

import java.util.Date;
import java.util.List;

public class SysUser {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private byte status;
    private Long createUserId;
    private Date createTime;
    private List<Long> roleIdList;

    public SysUser() {
    }

    public SysUser(Long userId, String username, String password, String email, String mobile, byte status, Long createUserId, Date createTime, List<Long> roleIdList) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.roleIdList = roleIdList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
