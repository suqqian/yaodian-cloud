package com.template.edurptemplate.ceshi.service.impl;

import com.template.edurptemplate.ceshi.entity.TbCeShiDTO;
import com.template.edurptemplate.ceshi.mapper.TbCeShiMapper;
import com.template.edurptemplate.ceshi.service.TbCeShiService;
import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试(TbCeShi)表服务实现类
 *
 * @author
 * @since 2023-05-07 21:19:03
 */
@Service("tbCeShiService")
public class TbCeShiServiceImpl extends SysBaseServiceImpl<TbCeShiDTO, String> implements TbCeShiService {
    @Resource
    private TbCeShiMapper tbCeShiMapper;

    @Override
    public SysBaseMapper<TbCeShiDTO, String> getMappser() {
        return tbCeShiMapper;
    }

}
