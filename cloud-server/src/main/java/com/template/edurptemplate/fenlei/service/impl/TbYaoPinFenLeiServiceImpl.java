package com.template.edurptemplate.fenlei.service.impl;

import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import com.template.edurptemplate.fenlei.entity.TbYaoPinFenLeiDTO;
import com.template.edurptemplate.fenlei.mapper.TbYaoPinFenLeiMapper;
import com.template.edurptemplate.fenlei.service.TbYaoPinFenLeiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 药品分类(TbYaoPinFenLei)表服务实现类
 *
 * @author zhouzhiwei
 * @since 2021-12-25 13:15:38
 */
@Service("tbYaoPinFenLeiService")
public class TbYaoPinFenLeiServiceImpl extends SysBaseServiceImpl<TbYaoPinFenLeiDTO, String> implements TbYaoPinFenLeiService {
    @Resource
    private TbYaoPinFenLeiMapper tbYaoPinFenLeiMapper;

    @Override
    public SysBaseMapper<TbYaoPinFenLeiDTO, String> getMappser() {
        return tbYaoPinFenLeiMapper;
    }

}