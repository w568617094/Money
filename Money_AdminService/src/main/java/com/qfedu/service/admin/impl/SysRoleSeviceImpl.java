package com.qfedu.service.admin.impl;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysRole;
import com.qfedu.domain.admin.SysRoleMenu;
import com.qfedu.mapper.admin.SysRoleMapper;
import com.qfedu.mapper.admin.SysRoleMenuMapper;
import com.qfedu.mapper.admin.SysUserRoleMapper;
import com.qfedu.service.admin.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleSeviceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysRoleMenuMapper roleMenuMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Override
    public DataGridResult getPageList(Query query) {
        int offset = (int) query.get("offset");
        int limit = (int) query.get("limit");
        List<SysRole> rows=roleMapper.queryByPage(offset,limit);
        Long total =roleMapper.queryCount();
        DataGridResult dataGridResult = new DataGridResult(rows,total);
        return dataGridResult;
    }

    @Override
    public void deleteBatch(Long[] ids) {
        roleMapper.deleteBatch(ids);
        roleMenuMapper.deleteByMenuIds(ids);
        userRoleMapper.deleteByUserIds(ids);
    }

    @Override
    public SysRole getById(Long roleId) {
        SysRole role =roleMapper.selectByPrimaryKey(roleId);
        List<Long> menudList = roleMenuMapper.queryMenuIdList(roleId);
        role.setMenuIdList(menudList);
        return role;
    }

    @Override
    public void save(SysRole role) {
        role.setCreateTime(new Date());
        roleMapper.insert(role);
        Long roleId =role.getRoleId();
        List<Long> menuIdList=role.getMenuIdList();
        if (menuIdList.size()==0){
            return;
        }
        for (int i = 0; i <menuIdList.size() ; i++) {
            SysRoleMenu sysRoleMenu =new SysRoleMenu();
            sysRoleMenu.setMenuId(menuIdList.get(i));
            sysRoleMenu.setRoleId(roleId);
            roleMenuMapper.insert(sysRoleMenu);
        }
    }

    @Override
    public void update(SysRole role) {
        roleMapper.updateByPrimaryKey(role);
        Long roleId=role.getRoleId();
        roleMenuMapper.deleteByRoleId(roleId);

        List<Long> menuIdList = role.getMenuIdList();
        if (menuIdList.size()==0){
            return;
        }
        for (int i = 0; i <menuIdList.size() ; i++) {
            SysRoleMenu sysRoleMenu =new SysRoleMenu();
            sysRoleMenu.setMenuId(menuIdList.get(i));
            sysRoleMenu.setRoleId(roleId);
            roleMenuMapper.insert(sysRoleMenu);
        }
    }


    @Override
    public List<SysRole> findAll() {
        return roleMapper.queryAll();
    }

    @Override
    public List<String> selectRoleNameList(Long userId) {
        return roleMapper.selectRoleNameList(userId);
    }
}
