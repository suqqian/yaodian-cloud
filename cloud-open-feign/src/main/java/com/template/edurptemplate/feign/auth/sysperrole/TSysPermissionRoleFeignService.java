package com.template.edurptemplate.feign.auth.sysperrole;

import com.template.edurptemplate.auth.sysper.entity.TablePerDTO;
import com.template.edurptemplate.auth.sysperrole.entity.TSysPermissionRoleDTO;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.Tablepar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.feign.auth.sysperrole
 * @ClassName: TSysPermissionRoleFeignService
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/7 03:21
 * @Version: 1.0
 */
@FeignClient(value = "server")
public interface TSysPermissionRoleFeignService {
    @PostMapping("/tSysPermissionRole/list")
    Object list(@RequestBody TablePerDTO tablePerDTO);

    @PostMapping("/tSysPermissionRole/add")
    AjaxResult add(@RequestBody TSysPermissionRoleDTO entity);

    @GetMapping("/tSysPermissionRole/delete")
    AjaxResult remove(@RequestParam("ids") String ids);

    @GetMapping("/tSysPermissionRole/edit")
    AjaxResult editSave(@RequestBody TSysPermissionRoleDTO entity);

    @GetMapping("/tSysPermissionRole/getById")
    TSysPermissionRoleDTO getById(@RequestParam("id") String id);


}
