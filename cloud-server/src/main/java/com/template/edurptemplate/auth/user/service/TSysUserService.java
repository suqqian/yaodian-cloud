package com.template.edurptemplate.auth.user.service;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.common.service.SysBaseService;
import com.template.edurptemplate.auth.user.entity.TSysUserDTO;

import java.util.List;

/**
 * 用户表(TSysUser)表服务接口
 *
 * @author 作者名字
 */
public interface TSysUserService extends SysBaseService<TSysUserDTO, String> {


    int insertUserRoles(TSysUserDTO user, List<String> roles);

    int deleteByUserIds(String ids);

    List<TSysRoleDTO> getUserIsRole(String id);

    int updateUserRoles(TSysUserDTO tsysUser, List<String> roles);

    int updateUserPassword(TSysUserDTO tsysUser);
}
