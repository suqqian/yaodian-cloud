package com.template.edurptemplate.entity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 备忘录(Beiwanglu)Beiwanglu
 *
 * @author makejava
 * @since 2023-06-11 02:58:33
 */
@Getter
@Setter
@Table(name = "beiwanglu")
public class BeiwangluDTO {
    private static final long serialVersionUID = -70320800816647827L;
    /**
     * 主键
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "addtime")
    private LocalDateTime addtime;

    /**
     * 标题
     */
    @Column(name = "biaoti")
    private String biaoti;

    /**
     * 类型
     */
    @Column(name = "leixing")
    private String leixing;

    /**
     * 图片
     */
    @Column(name = "tupian")
    private String tupian;

    /**
     * 内容
     */
    @Column(name = "neirong")
    private Object neirong;

    /**
     * 日期
     */
    @Column(name = "riqi")
    private Object riqi;

    /**
     * 备注
     */
    @Column(name = "beizhu")
    private String beizhu;

    /**
     * 用户名
     */
    @Column(name = "yonghuming")
    private String yonghuming;

    /**
     * 用户id
     */
    @Column(name = "userid")
    private Long userid;


}
