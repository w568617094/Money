package com.qfedu.service.admin.impl;

import com.alibaba.druid.util.StringUtils;
import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysMenu;
import com.qfedu.mapper.admin.SysMenuMapper;
import com.qfedu.mapper.admin.SysRoleMenuMapper;
import com.qfedu.service.admin.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;
    @Autowired
    private SysRoleMenuMapper roleMenuMapper;
    @Override
    public DataGridResult getPageLilst(Query query) {

        int offset= (int) query.get("offset");
        int limit= (int) query.get("limit");
        List<SysMenu> rows=menuMapper.queryByPage(offset,limit);
        Long total=menuMapper.queryCount();
        DataGridResult dataGridResult=new DataGridResult(rows,total);

        return dataGridResult;
    }

    @Override
    public void deleteBatch(Long[] ids) {
    menuMapper.deleteBatch(ids);
    roleMenuMapper.deleteByMenuIds(ids);
    }

    @Override
    public SysMenu getById(Long menuId) {

        return menuMapper.selectByPrimaryKey(menuId);
    }



    @Override
    public void save(SysMenu menu) {
        if (menu.getParentMenu()!=null&& menu.getParentMenu().getMenuId()==null){
            menu.setParentMenu(null);
        }
        menuMapper.insert(menu);
    }

    @Override
    public void update(SysMenu menu) {
    menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public List<SysMenu> getNotButtonMenuList() {

        return menuMapper.queryNotButtonList();
    }

    @Override
    public List<SysMenu> findAll() {

        return menuMapper.queryListAll();
    }

    @Override
    public List<String> getUserPermsList(Long userId) {
        List<String> userPermsList=menuMapper.queryAllPerms(userId);
        List<String> finalPermsList = new ArrayList<String>();
        for (int i = 0; i < userPermsList.size(); i++) {
            String perms = userPermsList.get(i);
            if (StringUtils.isEmpty(perms)){
                continue;
            }
            finalPermsList.addAll(Arrays.asList(perms.split(",")));
        }
        return finalPermsList;
    }

    @Override
    public List<SysMenu> getTopMenuList() {
        return menuMapper.queryTopMenuList();
    }

    @Override
    public List<SysMenu> findUserMenuList(Long userId) {
        List<SysMenu> menuList =new ArrayList<SysMenu>();
        List<Long> meniIdList = menuMapper.queryAllMenuId(userId);
        menuList=menuMapper.queryUserTop(meniIdList);
        for (int i = 0; i <menuList.size() ; i++) {
            List<SysMenu> subMenu=menuMapper.queryUserMenuByParentId(menuList.get(i).getMenuId(),meniIdList);
            menuList.get(i).setChildren(subMenu);
        }
        return menuList;
    }
}
