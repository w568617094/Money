package com.qfedu.service.admin;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysRole;

import java.util.List;

public interface SysRoleService {
    DataGridResult getPageList(Query query);
    void deleteBatch (Long[] ids);
    SysRole getById(Long roleId);
    void save(SysRole role);
    void update(SysRole role);
    List<SysRole> findAll();
    List<String> selectRoleNameList(Long userId);
}
