package com.template.edurptemplate.news.service.impl;

import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import com.template.edurptemplate.entity.NewsDTO;
import com.template.edurptemplate.news.mapper.NewsMapper;
import com.template.edurptemplate.news.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 公告信息(News)表服务实现类
 *
 * @author
 * @since 2023-06-11 03:40:09
 */
@Service("newsService")
public class NewsServiceImpl extends SysBaseServiceImpl<NewsDTO, String> implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public SysBaseMapper<NewsDTO, String> getMappser() {
        return newsMapper;
    }

}
