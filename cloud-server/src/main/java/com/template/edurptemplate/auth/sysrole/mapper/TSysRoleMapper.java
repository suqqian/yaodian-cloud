package com.template.edurptemplate.auth.sysrole.mapper;

import com.template.edurptemplate.auth.sysrole.entity.TSysRoleDTO;
import com.template.edurptemplate.common.dao.SysBaseMapper;

/**
 * 角色表(TSysRole)表数据库访问层
 *
 * @author 作者名字
 */
public interface TSysRoleMapper extends SysBaseMapper<TSysRoleDTO, String> {


    void deleteAllPerByRoleId(String id);
}
