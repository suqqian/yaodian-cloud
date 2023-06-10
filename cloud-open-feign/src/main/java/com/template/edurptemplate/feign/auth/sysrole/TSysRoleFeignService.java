package com.template.edurptemplate.feign.auth.sysrole;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.sysrole.entity.TableRoleDTO;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.Tablepar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.feign.auth.sysrole
 * @ClassName: TSysRoleFeignService
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/7 03:24
 * @Version: 1.0
 */
@FeignClient(value = "server")
public interface TSysRoleFeignService {
    @PostMapping("/RoleController/list")
    public Object list(@RequestBody TableRoleDTO tabEntity);

    @PostMapping("/RoleController/add")
    public AjaxResult add(@RequestBody TSysRoleDTO entity, @RequestParam("prem") String prem);

    @PostMapping("/RoleController/delete")
    public AjaxResult remove(@RequestParam("ids") String ids);

    @PostMapping("/RoleController/edit")
    public AjaxResult edit(@RequestBody TSysRoleDTO entity, @RequestParam("prem") String prem);

    @GetMapping("/RoleController/getById")
    TSysRoleDTO getById(@RequestParam("id") String id);

    @GetMapping("/RoleController/getAll")
    List<TSysRoleDTO> getAll();
}
