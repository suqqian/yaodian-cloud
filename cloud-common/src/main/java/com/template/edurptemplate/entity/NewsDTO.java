package com.template.edurptemplate.entity;

import com.template.edurptemplate.common.entity.Tablepar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 公告信息(News)News
 *
 * @author makejava
 * @since 2023-06-11 02:56:57
 */
@Getter
@Setter
@Table(name = "news")
public class NewsDTO {
    private static final long serialVersionUID = 964882745344766845L;
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
    @Column(name = "title")
    private String title;

    /**
     * 简介
     */
    @Column(name = "introduction")
    private Object introduction;

    /**
     * 图片
     */
    @Column(name = "picture")
    private String picture;

    /**
     * 内容
     */
    @Column(name = "content")
    private Object content;

    @Transient
    private Tablepar tablepar;


}
