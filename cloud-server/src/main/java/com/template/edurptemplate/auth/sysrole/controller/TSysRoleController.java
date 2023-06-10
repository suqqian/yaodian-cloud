package com.template.edurptemplate.auth.sysrole.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.auth.sysper.service.TSysPermissionService;
import com.template.edurptemplate.auth.sysperrole.entity.TSysPermissionRoleDTO;
import com.template.edurptemplate.auth.sysperrole.service.TSysPermissionRoleService;
import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.sysrole.entity.TableRoleDTO;
import com.template.edurptemplate.auth.sysrole.service.TSysRoleService;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 角色表(TSysRole)表控制层
 *
 * @author 作者名字
 */
@Controller
@RequestMapping("RoleController")
public class TSysRoleController extends BaseController {
    @Autowired
    private TSysPermissionService sysPermissionService;
    @Autowired
    private TSysRoleService tSysRoleService;
    @Autowired
    private TSysPermissionRoleService sysPermissionRoleService;


    /**
     * @param
     * @param
     * @Author 作者名字
     * @Version 1.0
     * @Description 数据列表
     * @Return java.lang.Object
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(@RequestBody TableRoleDTO tabEntity) {
        PageHelper.startPage(tabEntity.getTablepar().getPageNum(), tabEntity.getTablepar().getPageSize());
        List<TSysRoleDTO> select = tSysRoleService.select(tabEntity.getEntity());
        PageInfo<TSysRoleDTO> pageInfo = new PageInfo(select);
        TableSplitResult<TSysRoleDTO> result = new TableSplitResult<TSysRoleDTO>(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
        return result;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Object getAll() {
        List<TSysRoleDTO> select = tSysRoleService.selectAll();
        return select;
    }


    @GetMapping("/getById")
    @ResponseBody
    public Object getById(@RequestParam String id) {
        TSysRoleDTO select = tSysRoleService.selectByPrimaryKey(id);
        return select;
    }


    /**
     * @param
     * @Author
     * @Version 1.0
     * @Description：数据新增
     * @Return
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(TSysRoleDTO entity, String prem) {

        int result = tSysRoleService.insertRole(entity, prem);
        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * @param ids
     * @Author 作者名字
     * @Version 1.0
     * @Description：根据id 删除数据
     * @Return
     */
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int result = tSysRoleService.deleteByIds(ids);
        String[] split = ids.split(",");
        List<String> roleIds = Arrays.asList(split);
        roleIds.forEach(s -> {
            TSysPermissionRoleDTO tSysPermissionRoleDTO = new TSysPermissionRoleDTO();
            tSysPermissionRoleDTO.setId(s);
            sysPermissionRoleService.delete(tSysPermissionRoleDTO);
        });
        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }


    @PostMapping("/checkNameUnique")
    @ResponseBody
    public int checkNameUnique(TSysRoleDTO tsysRole) {

        return 0;
    }

    /**
     * @param
     * @Author 作者名字
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSysRoleDTO entity, String prem) {

        return toAjax(tSysRoleService.updateRole(entity, prem));
    }

}
