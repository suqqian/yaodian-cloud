package com.template.edurptemplate.auth.sysperrole.service.impl;

import com.template.edurptemplate.auth.sysperrole.entity.TSysPermissionRoleDTO;
import com.template.edurptemplate.auth.sysperrole.mapper.TSysPermissionRoleMapper;
import com.template.edurptemplate.auth.sysperrole.service.TSysPermissionRoleService;
import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色权限中间表(TSysPermissionRole)表服务实现类
 *
 * @author 作者名字
 */
@Service("tSysPermissionRoleService")
public class TSysPermissionRoleServiceImpl extends SysBaseServiceImpl<TSysPermissionRoleDTO, String> implements TSysPermissionRoleService {
    @Resource
    private TSysPermissionRoleMapper tSysPermissionRoleMapper;

    @Override
    public SysBaseMapper<TSysPermissionRoleDTO, String> getMappser() {
        return tSysPermissionRoleMapper;
    }

}
