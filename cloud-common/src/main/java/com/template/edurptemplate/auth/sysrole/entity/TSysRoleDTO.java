package com.template.edurptemplate.auth.sysrole.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 角色表(TSysRole)TSysRole
 *
 * @author makejava
 */
@Getter
@Setter
@Table(name = "t_sys_role")
public class TSysRoleDTO {
    private static final long serialVersionUID = 929769778347465296L;
    /**
     * id
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;
    @Transient
    private boolean ischeck;


}
