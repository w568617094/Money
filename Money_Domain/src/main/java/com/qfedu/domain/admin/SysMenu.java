package com.qfedu.domain.admin;

import java.util.List;

public class SysMenu {
    private Long menuId;
    private Long parentId;
    private String name;
    private String url;
    private String perms;
    private int type;
    private String icon;
    private int orderNum;
    private List<SysMenu> list;
    private SysMenu parentMenu;
    private List<SysMenu> children;

    public SysMenu() {
    }

    public SysMenu(Long menuId, Long parentId, String name, String url, String perms, int type, String icon, int orderNum, List<SysMenu> list, SysMenu parentMenu, List<SysMenu> children) {
        this.menuId = menuId;
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.perms = perms;
        this.type = type;
        this.icon = icon;
        this.orderNum = orderNum;
        this.list = list;
        this.parentMenu = parentMenu;
        this.children = children;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public List<SysMenu> getList() {
        return list;
    }

    public void setList(List<SysMenu> list) {
        this.list = list;
    }

    public SysMenu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(SysMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }
}
