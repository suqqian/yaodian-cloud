package com.template.edurptemplate.auth.sysrole.controller;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.sysrole.entity.TableRoleDTO;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.*;
import com.template.edurptemplate.feign.auth.sysper.TSysPermissionFeignService;
import com.template.edurptemplate.feign.auth.sysrole.TSysRoleFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private static final String prefixUrl = "admin/role/";
    @Resource
    private TSysRoleFeignService tSysRoleFeignService;
    @Resource
    private TSysPermissionFeignService tsSysPermissionService;

    /**
     * @param model
     * @Author 作者名字
     * @Version 1.0
     * @Description:进入数据列表，进入页面
     * @Return java.lang.String
     */
    @GetMapping("/view")
    public String view(ModelMap model) {
        String str = "用户";
        setTitle(model, new TitleVo("列表", str + "管理", true, "欢迎进入" + str + "页面", true, false));
        return prefixUrl + "/list";
    }


    /**
     * @param tablepar
     * @Author 作者名字
     * @Version 1.0
     * @Description 数据列表
     * @Return java.lang.Object
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(Tablepar tablepar, TSysRoleDTO entity) {
        TableRoleDTO tabEntity=new TableRoleDTO();
        tabEntity.setEntity(entity);
        tabEntity.setTablepar(tablepar);
        return tSysRoleFeignService.list(tabEntity);
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
        return prefixUrl + "/add";
    }

    /**
     * @Author
     * @Version 1.0
     * @Description：数据新增
     * @Return
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(TSysRoleDTO entity, String prem) {
        return tSysRoleFeignService.add(entity, prem);

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
        return tSysRoleFeignService.remove(ids);
    }


    /**
     * @param id
     * @param mmap
     * @Version 1.0
     * @Description：进入更新页面（编辑页面）
     * @Return java.lang.String
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap, HttpServletRequest request) {
        TSysRoleDTO tSysRoleDTO = tSysRoleFeignService.getById(id);
        BootstrapTree bootstrapTree = tsSysPermissionService.getbooBootstrapTree(null);
        request.getSession().setAttribute("bootstrapTree", bootstrapTree);
        mmap.put("TSysRole", tSysRoleDTO);
        return prefixUrl + "edit";
    }

    @PostMapping("/checkNameUnique")
    @ResponseBody
    public int checkNameUnique(TSysRoleDTO tsysRole) {

        return 0;
    }

    /**
     * @Author 作者名字
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSysRoleDTO entity, String prem) {
        return tSysRoleFeignService.edit(entity, prem);
    }

}
