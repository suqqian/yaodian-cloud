package com.template.edurptemplate.auth.sysperrole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色权限中间表(TSysPermissionRole)TSysPermissionRole
 *
 * @author makejava
 */
@Getter
@Setter
@Table(name = "t_sys_permission_role")
public class TSysPermissionRoleDTO {
    private static final long serialVersionUID = 267511503479611419L;

    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private String roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private String permissionId;



}
