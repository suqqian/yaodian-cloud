package com.template.edurptemplate.auth.user.controller;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.user.entity.TSysUserDTO;
import com.template.edurptemplate.auth.UserInfoUtils;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.common.entity.TitleVo;
import com.template.edurptemplate.feign.auth.sysrole.TSysRoleFeignService;
import com.template.edurptemplate.feign.auth.user.TSysUserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户表(TSysUser)表控制层
 *
 * @author 作者名字
 */
@Controller
@RequestMapping("tSysUser")
public class TSysUserController extends BaseController {
    private String prefix = "admin/user";

    @Autowired
    private TSysUserFeignService sysUserService;
    @Autowired
    private TSysRoleFeignService sysRoleService;

    /**
     * 展示跳转页面
     *
     * @param model
     * @return
     * @author fuce
     */
    @GetMapping("/view")
    public String view(ModelMap model) {
        String str = "用户";
        model.put("userType", UserInfoUtils.getUserType());
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return prefix + "/list";
    }


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
    public Object list(Tablepar tablepar, String searchText) {
        return sysUserService.list(tablepar, searchText);
    }

    /**
     * 新增跳转
     *
     * @param modelMap
     * @return
     * @author fuce
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        //添加角色列表
        List<TSysRoleDTO> tsysRoleList = sysRoleService.getAll();
        modelMap.put("tsysRoleList", tsysRoleList);
        return prefix + "/add";
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
        return sysUserService.add(user, roles);

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
        return sysUserService.remove(ids);
    }


    /**
     * 修改用户跳转
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        //查询所有角色
        List<TSysRoleDTO> roleVos = sysUserService.getRoleByUserId(id);
        mmap.put("roleVos", roleVos);
        TSysUserDTO tSysUserDTO = sysUserService.selectByPrimaryKey(id);
        mmap.put("TsysUser", tSysUserDTO);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSysUserDTO tsysUser, @RequestParam(value = "roles", required = false) List<String> roles) {
        return sysUserService.edit(tsysUser, roles);
    }


    /**
     * 修改用户密码跳转
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/editPwd/{id}")
    public String editPwd(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("TsysUser", sysUserService.selectByPrimaryKey(id));
        return prefix + "/editPwd";
    }

    /**
     * 修改保存用户
     */
    @PostMapping("/editPwd")
    @ResponseBody
    public AjaxResult editPwdSave(TSysUserDTO tsysUser) {
       return   sysUserService.update(tsysUser);
    }


}
