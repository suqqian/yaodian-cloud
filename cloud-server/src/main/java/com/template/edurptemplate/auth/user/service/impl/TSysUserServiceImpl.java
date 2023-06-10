package com.template.edurptemplate.auth.user.service.impl;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.auth.sysrole.service.TSysRoleService;
import com.template.edurptemplate.auth.sysuserrole.entity.TSysRoleUserDTO;
import com.template.edurptemplate.auth.sysuserrole.service.TSysRoleUserService;
import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import com.template.edurptemplate.auth.user.entity.TSysUserDTO;
import com.template.edurptemplate.auth.user.mapper.TSysUserMapper;
import com.template.edurptemplate.auth.user.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 用户表(TSysUser)表服务实现类
 */
@Service("tSysUserService")
public class TSysUserServiceImpl extends SysBaseServiceImpl<TSysUserDTO, String> implements TSysUserService {
    @Autowired
    private TSysUserMapper tSysUserMapper;
    @Autowired
    private TSysRoleUserService sysRoleUserService;
    @Autowired
    private TSysRoleService sysRoleService;


    @Override
    public SysBaseMapper<TSysUserDTO, String> getMappser() {
        return tSysUserMapper;
    }

    @Override
    public int insertUserRoles(TSysUserDTO user, List<String> roles) {
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        if (!CollectionUtils.isEmpty(roles)) {
            roles.stream().forEach(roleId -> {
                TSysRoleUserDTO tSysRoleUserDTO = new TSysRoleUserDTO();
                tSysRoleUserDTO.setId(UUID.randomUUID().toString());
                tSysRoleUserDTO.setSysUserId(userId);
                tSysRoleUserDTO.setSysRoleId(roleId);
                sysRoleUserService.insert(tSysRoleUserDTO);
            });
        }
        tSysUserMapper.insert(user);
        return 0;
    }

    @Override
    public int deleteByUserIds(String ids) {
        //删除role
        List<String> userIds = (List<String>) Arrays.asList(ids.split(","));
        userIds.stream().forEach(userId -> {
            TSysRoleUserDTO tSysRoleUserDTO = new TSysRoleUserDTO();
            tSysRoleUserDTO.setSysUserId(userId);
            sysRoleUserService.delete(tSysRoleUserDTO);
        });
        String[] split = ids.split(",");
        for (int i = split.length - 1; i >= 0; i--) {
            final TSysUserDTO tSysUserDTO = tSysUserMapper.selectByPrimaryKey(split[i]);
            if (!tSysUserDTO.getUsername().equals("admin")) {
                tSysUserMapper.deleteByPrimaryKey(split[i]);
            }
        }
        return 0;
    }

    @Override
    public List<TSysRoleDTO> getUserIsRole(String id) {
        TSysRoleUserDTO tSysRoleUserDTO = new TSysRoleUserDTO();
        tSysRoleUserDTO.setSysUserId(id);
        List<TSysRoleDTO> tSysRoleDTOS = sysRoleService.selectAll();
        List<TSysRoleUserDTO> selectRoles = sysRoleUserService.select(tSysRoleUserDTO);
        List<String> selectRoleIds = selectRoles.stream().map(TSysRoleUserDTO::getSysRoleId).collect(Collectors.toList());
        tSysRoleDTOS.stream().forEach(tSysRoleDTO -> {
            if (selectRoleIds.contains(tSysRoleDTO.getId())) {
                tSysRoleDTO.setIscheck(true);
            }
        });
        return tSysRoleDTOS;
    }

    @Override
    public int updateUserRoles(TSysUserDTO tsysUser, List<String> roles) {
        TSysRoleUserDTO tSysRoleUserDTO = new TSysRoleUserDTO();
        tSysRoleUserDTO.setSysUserId(tsysUser.getId());
        sysRoleUserService.delete(tSysRoleUserDTO);
        if (!CollectionUtils.isEmpty(roles)) {
            roles.stream().forEach(roleId -> {
                TSysRoleUserDTO tSysRoleUserDTO1 = new TSysRoleUserDTO();
                tSysRoleUserDTO1.setId(UUID.randomUUID().toString());
                tSysRoleUserDTO1.setSysRoleId(roleId);
                tSysRoleUserDTO1.setSysUserId(tsysUser.getId());
                sysRoleUserService.insert(tSysRoleUserDTO1);
            });
        }
        tSysUserMapper.updateByPrimaryKeySelective(tsysUser);
        return 1;
    }

    @Override
    public int updateUserPassword(TSysUserDTO tsysUser) {
        return tSysUserMapper.updateByPrimaryKeySelective(tsysUser);
    }
}
