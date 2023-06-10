package com.template.edurptemplate.auth.sysperrole.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.auth.sysper.entity.TablePerDTO;
import com.template.edurptemplate.auth.sysperrole.entity.TSysPermissionRoleDTO;
import com.template.edurptemplate.auth.sysperrole.service.TSysPermissionRoleService;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.common.entity.TitleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 角色权限中间表(TSysPermissionRole)表控制层
 *
 * @author 作者名字
 */
@Controller
@RequestMapping("tSysPermissionRole")
public class TSysPermissionRoleController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private TSysPermissionRoleService tSysPermissionRoleService;



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
    public Object list(TablePerDTO table) {
        PageHelper.startPage(table.getTablepar().getPageNum(), table.getTablepar().getPageSize());
        List<TSysPermissionRoleDTO> select = tSysPermissionRoleService.select(table.getEntity());
        PageInfo<TSysPermissionRoleDTO> pageInfo = new PageInfo(select);
        TableSplitResult<TSysPermissionRoleDTO> result = new TableSplitResult<TSysPermissionRoleDTO>(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
        return result;
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
    public AjaxResult add(TSysPermissionRoleDTO entity) {
        int result = tSysPermissionRoleService.insertSelective(entity);
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
    @GetMapping("/delete")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int result = tSysPermissionRoleService.deleteByIds(ids);
        if (result > 0) {
            return success();
        } else {
            return error();
        }
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
    public AjaxResult editSave(TSysPermissionRoleDTO entity) {
        return toAjax(tSysPermissionRoleService.updateByPrimaryKeySelective(entity));
    }

}
