package com.qfedu.service.admin;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysUser;



public interface SysUserService {

    DataGridResult getPageList(Query query);
    void deleteBatch(Long[] userids);
    SysUser getById(Long userId);
    void save(SysUser user);
    void update(SysUser user);
    SysUser getByUsername(String username);
}

