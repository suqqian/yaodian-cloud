package com.template.edurptemplate.ypjbxx.service.impl;

import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import com.template.edurptemplate.ypjbxx.entity.TbYaoPinJiBenXinXiDTO;
import com.template.edurptemplate.ypjbxx.mapper.TbYaoPinJiBenXinXiMapper;
import com.template.edurptemplate.ypjbxx.service.TbYaoPinJiBenXinXiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 药品基本信息(TbYaoPinJiBenXinXi)表服务实现类
 *
 * @author zhouzhiwei
 * @since 2022-01-01 10:21:09
 */
@Service("tbYaoPinJiBenXinXiService")
public class TbYaoPinJiBenXinXiServiceImpl extends SysBaseServiceImpl<TbYaoPinJiBenXinXiDTO, String> implements TbYaoPinJiBenXinXiService {
    @Resource
    private TbYaoPinJiBenXinXiMapper tbYaoPinJiBenXinXiMapper;

    @Override
    public SysBaseMapper<TbYaoPinJiBenXinXiDTO, String> getMappser() {
        return tbYaoPinJiBenXinXiMapper;
    }

}