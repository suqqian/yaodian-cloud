package com.template.edurptemplate.auth.sysuserrole.service.impl;

import com.template.edurptemplate.auth.sysuserrole.entity.TSysRoleUserDTO;
import com.template.edurptemplate.auth.sysuserrole.mapper.TSysRoleUserMapper;
import com.template.edurptemplate.auth.sysuserrole.service.TSysRoleUserService;
import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户角色中间表(TSysRoleUser)表服务实现类
 *
 * @author 作者名字
 */
@Service("tSysRoleUserService")
public class TSysRoleUserServiceImpl extends SysBaseServiceImpl<TSysRoleUserDTO, String> implements TSysRoleUserService {
    @Resource
    private TSysRoleUserMapper tSysRoleUserMapper;

    @Override
    public SysBaseMapper<TSysRoleUserDTO, String> getMappser() {
        return tSysRoleUserMapper;
    }

}
