package com.template.edurptemplate.auth.sysrole.service;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.common.service.SysBaseService;

/**
 * 角色表(TSysRole)表服务接口
 *
 * @author 作者名字
 */
public interface TSysRoleService extends SysBaseService<TSysRoleDTO, String> {


    int updateRole(TSysRoleDTO entity, String prem);

    int insertRole(TSysRoleDTO entity, String prem);
}
