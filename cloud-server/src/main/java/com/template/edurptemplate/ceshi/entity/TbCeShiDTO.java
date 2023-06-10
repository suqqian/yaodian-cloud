package com.template.edurptemplate.ceshi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 测试(TbCeShi)TbCeShi
 *
 * @author makejava
 * @since 2023-05-07 21:19:03
 */
@Getter
@Setter
@Table(name = "tb_ce_shi")
public class TbCeShiDTO {
    private static final long serialVersionUID = -74004945669679810L;
    /**
     * 主键
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 测试
     */
    @Column(name = "ce_shi")
    private String ceShi;

    /**
     * 文件
     */
    @Column(name = "wen_jian")
    private String wenJian;

    /**
     * 图片
     */
    @Column(name = "tu_pian")
    private String tuPian;

    /**
     * 备注
     */
    @Column(name = "bei_zhu")
    private String beiZhu;

    /**
     * 文本
     */
    @Column(name = "wen_text12")
    private String wenText12;


}
