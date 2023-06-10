package com.template.edurptemplate.auth.sysper.mapper;

import com.template.edurptemplate.auth.sysper.entity.TSysPermissionDTO;
import com.template.edurptemplate.common.dao.SysBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限表(TSysPermission)表数据库访问层
 *
 * @author 作者名字
 */
public interface TSysPermissionMapper extends SysBaseMapper<TSysPermissionDTO, String> {
    List<TSysPermissionDTO> selectByUserId(@Param(value = "userId") String userId);
    List<TSysPermissionDTO> selectAllBySql();
    List<TSysPermissionDTO> queryRoleId(@Param(value = "roleId") String roleId);
}
