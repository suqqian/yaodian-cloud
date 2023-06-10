package com.template.edurptemplate.auth.sysper.service;

import com.template.edurptemplate.auth.sysper.entity.TSysPermissionDTO;
import com.template.edurptemplate.common.entity.BootstrapTree;
import com.template.edurptemplate.common.service.SysBaseService;

import java.util.List;

/**
 * 权限表(TSysPermission)表服务接口
 *
 * @author 作者名字
 */
public interface TSysPermissionService extends SysBaseService<TSysPermissionDTO, String> {


    BootstrapTree getbooBootstrapTreePerm(String userId);

    List<TSysPermissionDTO> selectAllBySql();

    Object getCheckPrem(String roleId);
}
