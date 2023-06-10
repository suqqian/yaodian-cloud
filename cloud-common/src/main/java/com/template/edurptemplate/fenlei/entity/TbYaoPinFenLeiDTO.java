package com.template.edurptemplate.fenlei.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 药品分类(TbYaoPinFenLei)TbYaoPinFenLei
 *
 * @author makejava
 * @since 2021-12-25 13:15:38
 */
@Getter
@Setter
@Table(name = "tb_yao_pin_fen_lei")
public class TbYaoPinFenLeiDTO {
    private static final long serialVersionUID = -37489637535039104L;
    /**
     * 主键
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 类名
     */
    @Column(name = "lei_ming")
    private String leiMing;

    /**
     * 功效
     */
    @Column(name = "gong_xiao")
    private String gongXiao;

    /**
     * 备注
     */
    @Column(name = "bei_zhu")
    private String beiZhu;


}