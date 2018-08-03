package com.qfedu.controller;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.core.vo.R;
import com.qfedu.domain.admin.SysUser;
import com.qfedu.service.admin.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/{page}")
    public String listPage(@PathVariable String page){
    return "sys/user"+page;
}
    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions({"sys:user:list"})
    public DataGridResult getPage(@RequestParam Map<String,Object> params){
        Query query = new Query(params);
        return sysUserService.getPageList(query);
    }
    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions({"sys:user:delete"})
    public R deleteMore(@RequestBody Long[] ids){
        sysUserService.deleteBatch(ids);
        return R.setOK("删除成功");
    }
    @RequestMapping("/info/{userId}")
    @ResponseBody
    @RequiresPermissions({"sys:user:info"})
    public R info(@PathVariable Long userId){
        SysUser user=sysUserService.getById(userId);
        return new R(0,"用户详情",user);
    }
    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions({"sys:user:save"})
    public R save(@RequestBody SysUser user){
        sysUserService.save(user);
        return R.setOK("新增成功");
    }
    @RequestMapping("/update")
    @ResponseBody
    @RequiresPermissions({"sys:user:update"})
    public R update(@RequestBody SysUser user){
        sysUserService.update(user);
        return R.setOK("修改成功");
    }

}
