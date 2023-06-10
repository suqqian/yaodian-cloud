package com.template.edurptemplate.auth.sysrole.service.impl;

import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import com.template.edurptemplate.auth.sysper.service.TSysPermissionService;
import com.template.edurptemplate.auth.sysperrole.entity.TSysPermissionRoleDTO;
import com.template.edurptemplate.auth.sysperrole.service.TSysPermissionRoleService;
import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.sysrole.mapper.TSysRoleMapper;
import com.template.edurptemplate.auth.sysrole.service.TSysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 角色表(TSysRole)表服务实现类
 *
 * @author 作者名字
 */
@Service("tSysRoleService")
public class TSysRoleServiceImpl extends SysBaseServiceImpl<TSysRoleDTO, String> implements TSysRoleService {
    @Resource
    private TSysRoleMapper tSysRoleMapper;

    @Autowired
    private TSysPermissionService sysPermissionService;

    @Autowired
    private TSysPermissionRoleService sysPermissionRoleService;

    @Override
    public SysBaseMapper<TSysRoleDTO, String> getMappser() {
        return tSysRoleMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateRole(TSysRoleDTO entity, String prem) {
        //先删除角色下面的所有权限
        tSysRoleMapper.deleteAllPerByRoleId(entity.getId());
        this.savePrem(prem, entity.getId());
        return tSysRoleMapper.updateByPrimaryKeySelective(entity);
    }

    @Transactional
    public void savePrem(String prem, String roleId) {
        List<String> perStrs = null;
        if (!StringUtils.isEmpty(prem)) {
            perStrs = Arrays.asList(prem.split(","));
        }

        for (String pre : perStrs) {
            TSysPermissionRoleDTO sysPermissionRoleDTO = new TSysPermissionRoleDTO();
            sysPermissionRoleDTO.setId(UUID.randomUUID().toString());
            sysPermissionRoleDTO.setRoleId(roleId);
            sysPermissionRoleDTO.setPermissionId(pre);
            sysPermissionRoleService.insert(sysPermissionRoleDTO);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertRole(TSysRoleDTO entity, String prem) {
        entity.setId(UUID.randomUUID().toString());
        this.insertSelective(entity);
        this.savePrem(prem, entity.getId());
        return 1;
    }
}
