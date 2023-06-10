package com.template.edurptemplate.common.entity;

import lombok.Data;

/**
 * boostrap table post 参数
 * @author fc
 *
 */
@Data
public class Tablepar {
	private int pageNum;//页码
	private int pageSize;//数量
	private String orderByColumn;//排序字段
	private String isAsc;//排序字符 asc desc
	private String searchText;

}
