package com.template.edurptemplate.common.service;

import com.template.edurptemplate.common.dao.SysBaseMapper;

import java.io.Serializable;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.service
 * @ClassName: BaseService
 * @Author: 作者名字
 * @Description: baseservice
 * @Version: 1.0
 */

public interface SysBaseService<T, E extends Serializable> extends SysBaseMapper<T, E> {

}