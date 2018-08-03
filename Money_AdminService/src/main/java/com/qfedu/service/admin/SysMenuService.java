package com.qfedu.service.admin;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysMenu;

import java.util.List;

public interface SysMenuService {
    DataGridResult getPageLilst(Query query);
    void deleteBatch(Long[] ids);
    SysMenu getById(Long menuId);
    void save(SysMenu menu);
    void update(SysMenu menu);
    List<SysMenu> getNotButtonMenuList();
    List<SysMenu> findAll();
    List<String> getUserPermsList(Long userId);
    List<SysMenu> getTopMenuList();
    List<SysMenu> findUserMenuList(Long userId);
}
