package com.template.edurptemplate.auth.sysperrole.controller;

import com.template.edurptemplate.auth.sysper.entity.TablePerDTO;
import com.template.edurptemplate.auth.sysperrole.entity.TSysPermissionRoleDTO;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.common.entity.TitleVo;
import com.template.edurptemplate.feign.auth.sysperrole.TSysPermissionRoleFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 角色权限中间表(TSysPermissionRole)表控制层
 *
 * @author 作者名字
 */
@Controller
@RequestMapping("tSysPermissionRole")
public class TSysPermissionRoleController extends BaseController {
    private static final String prefixUrl = "admin/tSysPermissionRole";
    @Resource
    private TSysPermissionRoleFeignService tsPermissionRoleService;

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
    public Object list(Tablepar tablepar, TSysPermissionRoleDTO entity) {
        TablePerDTO table=new TablePerDTO();
        table.setTablepar(tablepar);
        table.setEntity(entity);
        return tsPermissionRoleService.list(table);
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
    public AjaxResult add(TSysPermissionRoleDTO entity) {
        return tsPermissionRoleService.add(entity);
    }

    /**
     * @param ids
     * @Author 作者名字
     * @Version 1.0
     * @Description：根据id 删除数据
     * @Return
     */
    @GetMapping("/delete")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return tsPermissionRoleService.remove(ids);
    }


    /**
     * @param id
     * @param mmap
     * @Version 1.0
     * @Description：进入更新页面（编辑页面）
     * @Return java.lang.String
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("TSysPermissionRole", tsPermissionRoleService.getById(id));
        return prefixUrl + "/edit";
    }

    /**
     * @Author 作者名字
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSysPermissionRoleDTO entity) {
        return tsPermissionRoleService.editSave(entity);
    }

}
