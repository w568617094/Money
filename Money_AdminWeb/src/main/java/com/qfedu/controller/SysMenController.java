package com.qfedu.controller;

import com.qfedu.core.vo.DataGridResult;
import com.qfedu.core.vo.Query;
import com.qfedu.core.vo.R;
import com.qfedu.core.vo.RM;
import com.qfedu.domain.admin.SysMenu;
import com.qfedu.service.admin.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/menu")
public class SysMenController {
    @Autowired
    private SysMenuService sysMenuService;
    @RequestMapping("/{page}")
    public String index (@PathVariable String page){
        return "sys/menu/"+page;
    }
    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions({"sys:menu:list"})
    public DataGridResult getPage(@RequestParam Map<String,Object> params){
        Query query =new Query(params);
        return sysMenuService.getPageLilst(query);
    }
    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions({"sys:menu:delete"})
    public R deleteBatch(@RequestBody Long[] ids){
        sysMenuService.deleteBatch(ids);
        return R.setOK("批量删除成功");
    }
    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions({"sys:menu:save"})
    public R save(@RequestBody SysMenu menu){
        sysMenuService.save(menu);
        return R.setOK("新增成功");
    }
    @RequestMapping("/info/{}menuId")
    @ResponseBody
    @RequiresPermissions({"sys:menu:info"})
    public RM save(@PathVariable Long menuId){
        SysMenu sysMenu =sysMenuService.getById(menuId);
        return RM.ok().put("menu",sysMenu);
    }
    @RequestMapping("/update")
    @ResponseBody
    @RequiresPermissions({"sys:menu:update"})
    public R update(@RequestBody SysMenu menu){
        sysMenuService.update(menu);
        return R.setOK("更新成功");
    }
    @RequestMapping("/select")
    @ResponseBody
    @RequiresPermissions({"sys:menu:select"})
    public RM getPage(){
        List<SysMenu> list =sysMenuService.getNotButtonMenuList();
        return RM.ok().put("menuList",list);
    }
}
