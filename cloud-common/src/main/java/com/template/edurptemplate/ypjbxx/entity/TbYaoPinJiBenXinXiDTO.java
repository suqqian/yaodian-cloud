package com.template.edurptemplate.ypjbxx.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 药品基本信息(TbYaoPinJiBenXinXi)TbYaoPinJiBenXinXi
 *
 * @author makejava
 * @since 2022-01-01 10:21:09
 */
@Getter
@Setter
@Table(name = "tb_yao_pin_ji_ben_xin_xi")
public class TbYaoPinJiBenXinXiDTO {
    private static final long serialVersionUID = -40433007055452944L;
    /**
     * 主键
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 药品名称
     */
    @Column(name = "yao_pin_ming_cheng")
    private String yaoPinMingCheng;

    /**
     * 批次
     */
    @Column(name = "pi_ci")
    private String piCi;

    /**
     * 分类
     */
    @Column(name = "fen_lei")
    private String fenLei;

    /**
     * 功效
     */
    @Column(name = "gong_xiao")
    private String gongXiao;

    /**
     * 不良反应
     */
    @Column(name = "bu_liang_fan_ying")
    private String buLiangFanYing;

    /**
     * 库存上限
     */
    @Column(name = "ku_cun_shang_xian")
    private String kuCunShangXian;

    /**
     * 库存下限
     */
    @Column(name = "ku_cun_xia_xian")
    private String kuCunXiaXian;

    /**
     * 进价指导价
     */
    @Column(name = "jin_jia_zhi_dao_jia")
    private String jinJiaZhiDaoJia;

    /**
     * 销售指导价
     */
    @Column(name = "xiao_shou_zhi_dao_jia")
    private String xiaoShouZhiDaoJia;
    /**
     * 销售指导价
     */
    @Column(name = "ku_cun")
    private String kuCun;

    @Column(name = "mai_chu")
    private Integer maiChu;

    @Column(name = "zong_li_run")
    private Double zongLiRun;


    /**
     * 生产时间
     */
    @Column(name = "sheng_chan_shi_jian")
    private String shengChanShiJian;


    /**
     * 有效期
     */
    @Column(name = "you_xiao_qi")
    private String youXiaoQi;


    /**
     * 生产商
     */
    @Column(name = "sheng_chan_shang")
    private String shengChanShang;

    @Column(name = "bian_hao")
    private String bianHao;




}