package com.template.edurptemplate.auth.sysper.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 权限表(TSysPermission)TSysPermission
 *
 * @author makejava
 */
@Getter
@Setter
@Table(name = "t_sys_permission")
public class TSysPermissionDTO {
    private static final long serialVersionUID = 263866506615531454L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 权限名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 权限描述
     */
    @Column(name = "descripion")
    private String descripion;

    /**
     * 授权链接
     */
    @Column(name = "url")
    private String url;

    /**
     * 是否跳转 0 不跳转 1跳转
     */
    @Column(name = "is_blank")
    private Integer isBlank;

    /**
     * 父节点id
     */
    @Column(name = "pid")
    private String pid;

    /**
     * 权限标识
     */
    @Column(name = "perms")
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 菜单图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 是否可见
     */
    @Column(name = "visible")
    private Integer visible;

    @Transient
    private Integer childCount;


}
