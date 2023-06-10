package com.template.edurptemplate.auth.sysuserrole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色中间表(TSysRoleUser)TSysRoleUser
 *
 * @author makejava
 */
@Getter
@Setter
@Table(name = "t_sys_role_user")
public class TSysRoleUserDTO {
    private static final long serialVersionUID = 508802797502763925L;

    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 用户id
     */
    @Column(name = "sys_user_id")
    private String sysUserId;

    /**
     * 角色id
     */
    @Column(name = "sys_role_id")
    private String sysRoleId;


}
