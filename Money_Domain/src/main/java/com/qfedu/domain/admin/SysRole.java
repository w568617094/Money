package com.qfedu.domain.admin;

import java.util.Date;
import java.util.List;

public class SysRole {
    private Long roleId;
    private String roleName;
    private String remark;
    private Long createUserId;
    private Date createTime;
    private List<Long> menuIdList;

    public SysRole() {
    }

    public SysRole(Long roleId, String roleName, String remark, Long createUserId, Date createTime, List<Long> menuIdList) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.remark = remark;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.menuIdList = menuIdList;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }
}
