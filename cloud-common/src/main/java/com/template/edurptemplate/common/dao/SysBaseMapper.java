package com.template.edurptemplate.common.dao;

import tk.mybatis.mapper.common.*;

import java.io.Serializable;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.dao
 * @ClassName: SysBaseMapper
 * @Description: 基本mapper，包含增删改查的基本操作
 * @Version: 1.0
 */

public interface SysBaseMapper<T, E extends Serializable> extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

}


