package com.template.edurptemplate.auth.sysper.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.auth.sysper.entity.TSysPermissionDTO;
import com.template.edurptemplate.auth.sysper.service.TSysPermissionService;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


/**
 * 权限表(TSysPermission)表控制层
 */
@RestController
@RequestMapping("PermissionController")
public class TSysPermissionController extends BaseController {

    @Autowired
    private TSysPermissionService sysPermissionService;


    /**
     * 权限列表
     *
     * @param tablepar
     * @param searchText 搜索字符
     * @return
     */
    @PostMapping("/list")
    public Object list(Tablepar tablepar, String searchText) {
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<TSysPermissionDTO> list = sysPermissionService.selectAll();
        PageInfo<TSysPermissionDTO> page = new PageInfo<>(list);
        TableSplitResult<TSysPermissionDTO> result = new TableSplitResult<TSysPermissionDTO>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 权限列表
     *
     * @param
     * @param
     * @return
     */
    @PostMapping("/listall")
    public Object list2() {
        List<TSysPermissionDTO> page = sysPermissionService.selectAllBySql();
        return page;
    }


    /**
     * 权限添加
     *
     * @param role
     * @return
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody TSysPermissionDTO role) {
        role.setId(UUID.randomUUID().toString());
        role.setPid(role.getPid().replace(",", ""));
        int b = sysPermissionService.insertSelective(role);
        if (b > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * 删除权限
     *
     * @param ids
     * @return
     */
    @PostMapping("/remove")
    public AjaxResult remove(String ids) {
        String[] split = ids.split(",");
        List<String> list = Arrays.asList(split);
        for (String s : list) {
            sysPermissionService.deleteByPrimaryKey(s);
        }
        return success();

    }

    /**
     * 检查权限
     *
     * @param TsysPermission
     * @return
     */
    @PostMapping("/checkNameUnique")
    public int checkNameUnique(@RequestBody TSysPermissionDTO TsysPermission) {
        return 0;
    }

    /**
     * 检查权限URL
     *
     * @param
     * @return
     */
    @PostMapping("/checkURLUnique")
    public int checkURLUnique(@RequestBody TSysPermissionDTO tsysPermission) {
        return 0;
    }

    /**
     * 检查权限perms字段
     *
     * @param
     * @return
     */
    @PostMapping("/checkPermsUnique")
    public int checkPermsUnique(@RequestBody TSysPermissionDTO tsysPermission) {
        return 0;
    }


    /**
     * 修改保存权限
     */
    @PostMapping("/edit")
    public AjaxResult editSave(@RequestBody TSysPermissionDTO TsysPermission) {
        return toAjax(sysPermissionService.updateByPrimaryKey(TsysPermission));
    }

    /**
     * 获取所有的转换成bootstarp的权限数据
     *
     * @return
     */
    @GetMapping("/getTreePerm")
    public BootstrapTree getbooBootstrapTreePerm(String userId) {
        return sysPermissionService.getbooBootstrapTreePerm(userId);
    }


    /**
     * 根据角色id获取bootstarp 所有打勾权限
     *
     * @param roleId 角色id集合
     * @return
     */
    @PostMapping("/getCheckPrem")
    public AjaxResult getCheckPrem(String roleId) {
        return retobject(200, sysPermissionService.getCheckPrem(roleId));
    }



}
