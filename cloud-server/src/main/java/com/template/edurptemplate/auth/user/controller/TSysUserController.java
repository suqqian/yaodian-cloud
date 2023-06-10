package com.template.edurptemplate.auth.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.sysrole.service.TSysRoleService;
import com.template.edurptemplate.auth.user.entity.TSysUserDTO;
import com.template.edurptemplate.auth.user.service.TSysUserService;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.common.entity.Tablepar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户表(TSysUser)表控制层
 *
 * @author 作者名字
 */
@RestController
@RequestMapping("tSysUser")
public class TSysUserController extends BaseController {

    @Autowired
    private TSysUserService sysUserService;
    @Autowired
    private TSysRoleService sysRoleService;


    /**
     * list集合
     *
     * @param tablepar
     * @param searchText
     * @return
     * @author fuce
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(@RequestBody Tablepar tablepar,@RequestParam(value = "searchText",required = false) String searchText) {
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        TSysUserDTO tSysUserDTO=new TSysUserDTO();
        tSysUserDTO.setUserrelname(searchText);
        List<TSysUserDTO> tSysUserDTOS  = sysUserService.select(tSysUserDTO);
        PageInfo<TSysUserDTO> page = new PageInfo<>(tSysUserDTOS);
        TableSplitResult<TSysUserDTO> result = new TableSplitResult<TSysUserDTO>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }


    /**
     * 新增保存
     *
     * @param user
     * @param model
     * @param roles
     * @return
     * @author fuce
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(TSysUserDTO user, Model model, @RequestParam(value = "roles", required = false) List<String> roles) {
        int b = sysUserService.insertUserRoles(user, roles);
        return success();

    }


    @PostMapping("/getOne")
    @ResponseBody
    public TSysUserDTO getOne(@RequestBody TSysUserDTO user) {
        return sysUserService.selectOne(user);
    }

    @GetMapping("/getById")
    public TSysUserDTO getById(@RequestParam("id") String id) {
        return sysUserService.selectByPrimaryKey(id);
    }


    @GetMapping("/getRoleByUserId")
    public List<TSysRoleDTO> getRoleByUserId(@RequestParam("id") String id) {
        return sysUserService.getUserIsRole(id);
    }

    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int b = sysUserService.deleteByUserIds(ids);
        return success();
    }


    /**
     * 修改保存用户
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSysUserDTO tsysUser, @RequestParam(value = "roles", required = false) List<String> roles) {
        return toAjax(sysUserService.updateUserRoles(tsysUser, roles));
    }


    /**
     * 修改保存用户
     */
    @PostMapping("/editPwd")
    @ResponseBody
    public AjaxResult editPwdSave(TSysUserDTO tsysUser) {
        return toAjax(sysUserService.updateUserPassword(tsysUser));
    }


}
