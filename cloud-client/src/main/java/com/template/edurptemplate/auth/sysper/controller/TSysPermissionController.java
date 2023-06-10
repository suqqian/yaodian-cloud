package com.template.edurptemplate.auth.sysper.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.auth.sysper.entity.TSysPermissionDTO;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.common.entity.TitleVo;
import com.template.edurptemplate.feign.auth.sysper.TSysPermissionFeignService;
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
@Controller
@RequestMapping("PermissionController")
public class TSysPermissionController extends BaseController {
    //跳转页面参数
    private String prefix = "admin/permission";
    @Autowired
    private TSysPermissionFeignService sysPermissionService;

    /**
     * 权限列表展示
     *
     * @param model
     * @return
     * @author fuce
     */
    @GetMapping("/view")
    public String view(ModelMap model) {
        String str = "权限";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return prefix + "/list";
    }

    /**
     * 权限列表
     *
     * @param tablepar
     * @param searchText 搜索字符
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(Tablepar tablepar, String searchText) {
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<TSysPermissionDTO> list = sysPermissionService.getAll();
        PageInfo<TSysPermissionDTO> page = new PageInfo<>(list);
        TableSplitResult<TSysPermissionDTO> result = new TableSplitResult<TSysPermissionDTO>(page.getPageNum(), page.getTotal(), page.getList());
        return result;
    }

    /**
     * 权限列表
     *
     * @param tablepar
     * @param searchText 搜索字符
     * @return
     */
    @PostMapping("/list2")
    @ResponseBody
    public Object list2(Tablepar tablepar, String searchText) {
        List<TSysPermissionDTO> page = sysPermissionService.getAll();
        return page;
    }

    /**
     * 新增权限
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, ModelMap mmap) {
        mmap.addAttribute("pid", id);
        return prefix + "/add";
    }


    /**
     * 权限添加
     *
     * @param role
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(TSysPermissionDTO role) {
        return sysPermissionService.add(role);

    }

    /**
     * 删除权限
     *
     * @param ids
     * @return
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return sysPermissionService.remove(ids);

    }

    /**
     * 检查权限
     *
     * @param TsysPermission
     * @return
     */
    @PostMapping("/checkNameUnique")
    @ResponseBody
    public int checkNameUnique(TSysPermissionDTO TsysPermission) {
        return 0;
    }

    /**
     * 检查权限URL
     *
     * @return
     */
    @PostMapping("/checkURLUnique")
    @ResponseBody
    public int checkURLUnique(TSysPermissionDTO tsysPermission) {
        return 0;
    }

    /**
     * 检查权限perms字段
     *
     * @return
     */
    @PostMapping("/checkPermsUnique")
    @ResponseBody
    public int checkPermsUnique(TSysPermissionDTO tsysPermission) {
        return 0;
    }

    /**
     * 修改权限
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{roleId}")
    public String edit(@PathVariable("roleId") String id, ModelMap mmap) {
        //获取自己的权限信息
        TSysPermissionDTO mytsysPermission = sysPermissionService.getById(id);
        //获取父权限信息
        TSysPermissionDTO pattsysPermission = sysPermissionService.getById(mytsysPermission.getPid());
        mmap.put("TsysPermission", mytsysPermission);
        mmap.put("pattsysPermission", pattsysPermission);
        return prefix + "/edit";
    }

    /**
     * 修改保存权限
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSysPermissionDTO TsysPermission) {

        return sysPermissionService.editSave(TsysPermission);
    }

    /**
     * 获取所有的转换成bootstarp的权限数据
     *
     * @return
     */
    @GetMapping("/getTreePerm")
    @ResponseBody
    public AjaxResult getbooBootstrapTreePerm() {
        return retobject(200,sysPermissionService.getbooBootstrapTree(null));
    }


    /**
     * 根据角色id获取bootstarp 所有打勾权限
     *
     * @param roleId 角色id集合
     * @return
     */
    @PostMapping("/getCheckPrem")
    @ResponseBody
    public AjaxResult getCheckPrem(String roleId) {

        return sysPermissionService.getCheckPrem(roleId);
    }


    /**
     * 跳转到菜单树页面
     *
     * @return
     */
    @GetMapping("/tree")
    public String Tree() {
        return prefix + "/tree";
    }



}
