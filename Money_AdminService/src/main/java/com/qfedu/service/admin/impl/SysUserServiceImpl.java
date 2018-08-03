package com.qfedu.service.admin.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.qfedu.core.util.EncrypUtil;
import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.domain.admin.SysUser;
import com.qfedu.domain.admin.SysUserRole;
import com.qfedu.mapper.admin.SysUserMapper;
import com.qfedu.mapper.admin.SysUserRoleMapper;
import com.qfedu.service.admin.SysUserService;
import org.apache.shiro.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    private static final String SysUser=null;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Override
    public DataGridResult getPageList(Query query) {
        int offset= (int) query.get("offset");
        int limit = (int) query.get("limit");
        List<SysUser> rows = userMapper.selectByPage(offset ,limit);
        for (SysUser sysUser: rows) {
            sysUser.setPassword(null);
        }
        Long total=userMapper.selectCount();
        DataGridResult dataGridResult = new DataGridResult(rows,total);
        return dataGridResult;
    }

    @Override
    public void deleteBatch(Long[] userids) {
        userMapper.deleteBatch(userids);
        userRoleMapper.deleteByUserIds(userids);
    }

    @Override
    public SysUser getById(Long userId) {
        SysUser user = userMapper.selectByPrimaryKey(userId);
        user.setPassword(null);
        List<Long> roleIdList = userRoleMapper.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);
        return user;
    }

    @Override
    public void save(SysUser user) {
        SysUser creator= (SysUser) SecurityUtils.getSubject().getPrincipal();
        user.setCreateUserId(creator.getUserId());
        user.setCreateTime(new Date());
        user.setPassword(EncrypUtil.md5Pass(user.getPassword()));
        userMapper.insert(user);
        Long userId = user.getUserId();
        List<Long> roleIdList =user.getRoleIdList();
        if (roleIdList.size()==0){
         return;
        }
        for (int i = 0; i <roleIdList.size() ; i++) {
            SysUserRole sysUserRole =new SysUserRole();
            sysUserRole.setRoleId(roleIdList.get(i));
            sysUserRole.setRoleId(userId);
            userRoleMapper.insert(sysUserRole);
        }
    }

    @Override
    public void update(SysUser user) {
        String password = userMapper.queryPassword(user.getCreateUserId());
        if (StringUtils.isBlank(user.getPassword())){
            user.setPassword(password);
        }else {
            user.setPassword(EncrypUtil.md5Pass(user.getPassword()));
        }
        userMapper.updateByPrimaryKey(user);
        Long userId =user.getUserId();
        userRoleMapper.deleteByUserId(userId);
        List<Long> roleIdList = user.getRoleIdList();
        if (roleIdList.size()==0){
            return;
        }
        for (int i = 0; i <roleIdList.size() ; i++) {
            SysUserRole sysUserRole =  new SysUserRole();
            sysUserRole.setRoleId(roleIdList.get(i));
            sysUserRole.setRoleId(userId);
            userRoleMapper.insert(sysUserRole);
        }
    }

    @Override
    public SysUser getByUsername(String username) {
        return userMapper.queryByUserName(username);
    }
}
