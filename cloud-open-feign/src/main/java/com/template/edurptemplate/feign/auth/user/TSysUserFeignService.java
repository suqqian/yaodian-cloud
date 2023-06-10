package com.template.edurptemplate.feign.auth.user;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.user.entity.TSysUserDTO;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.Tablepar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.feign.auth.user
 * @ClassName: TSysUserFeignService
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/7 03:27
 * @Version: 1.0
 */
@FeignClient(value = "server")
public interface TSysUserFeignService {
    @PostMapping("/tSysUser/list")
    Object list(@RequestBody Tablepar tablepar, @RequestParam(value = "searchText",required = false) String searchText);

    @PostMapping("/tSysUser/add")
    public AjaxResult add(@RequestBody TSysUserDTO user, @RequestParam("roles") List<String> roles);

    @PostMapping("/tSysUser/remove")
    public AjaxResult remove(@RequestParam("ids") String ids);

    @PostMapping("/tSysUser/edit")
    public AjaxResult edit(@RequestBody TSysUserDTO tsysUser, @RequestParam("roles") List<String> roles);

    @GetMapping("/tSysUser/getRoleByUserId")
    List<TSysRoleDTO> getRoleByUserId(@RequestParam("id") String id);

    @GetMapping("/tSysUser/getById")
    TSysUserDTO selectByPrimaryKey(@RequestParam("id") String id);

    @GetMapping("/tSysUser/update")
    AjaxResult update(@RequestBody TSysUserDTO tsysUser);

    @PostMapping("/tSysUser/getOne")
    TSysUserDTO selectOne(@RequestBody TSysUserDTO user);
}
