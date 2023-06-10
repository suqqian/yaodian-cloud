package com.template.edurptemplate.feign.auth.sysper;

import com.template.edurptemplate.auth.sysper.entity.TSysPermissionDTO;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.BootstrapTree;
import com.template.edurptemplate.common.entity.Tablepar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.feign.auth.sysper
 * @ClassName: TSysPermissionFeignService
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/6 23:40
 * @Version: 1.0
 */
@FeignClient(value = "server")
public interface TSysPermissionFeignService {
    @PostMapping("/PermissionController/list")
    public Object list(@RequestBody Tablepar tablepar, @RequestParam("searchText") String searchText);

    @PostMapping("/PermissionController/list2")
    public Object list2(@RequestBody Tablepar tablepar, @RequestParam("searchText") String searchText);

    @PostMapping("/PermissionController/add")
    public AjaxResult add(@RequestBody TSysPermissionDTO role);

    @PostMapping("/PermissionController/remove")
    public AjaxResult remove(@RequestParam("ids") String ids);

    @GetMapping("/PermissionController/edit")
    public String edit(@RequestParam("roleId") String id);

    @PostMapping("/PermissionController/edit")
    AjaxResult editSave(@RequestBody TSysPermissionDTO TsysPermission);

    @PostMapping("/PermissionController/getCheckPrem")
    public AjaxResult getCheckPrem(@RequestParam("roleId") String roleId);

    @PostMapping("/PermissionController/tree")
    public AjaxResult Tree(@RequestParam("pid") String pid);

    @PostMapping("/PermissionController/listall")
    public List<TSysPermissionDTO> getAll();

    @GetMapping("/PermissionController/getById")
    public TSysPermissionDTO getById(@RequestParam("id") String id);

    @GetMapping("/PermissionController/getTreePerm")
    public BootstrapTree getbooBootstrapTree(@RequestParam("userId") String userId);
}
