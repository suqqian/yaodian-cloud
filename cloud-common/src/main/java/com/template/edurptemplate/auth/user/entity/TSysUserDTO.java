package com.template.edurptemplate.auth.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表(TSysUser)TSysUser
 *
 * @author makejava
 */
@Getter
@Setter
@Table(name = "t_sys_user")
public class TSysUserDTO {
    private static final long serialVersionUID = 936285906319596253L;
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 登陆名
     */
    @Column(name = "username")
    private String username;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "userrelname")
    private String userrelname;
    /**
     * 用户类型
     */
    @Column(name = "type")
    private String type;

    @Column(name = "rel_id")
    private  String relId;


}
