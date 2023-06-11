package com.template.edurptemplate.news;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.entity.NewsDTO;
import com.template.edurptemplate.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 公告信息(News)表控制层
 *
 * @author
 * @since 2023-06-11 03:45:09
 */
@Controller
@RequestMapping("news")
public class NewsController extends BaseController {
    private static final String prefixUrl = "news/";
    /**
     * 服务对象
     */
    @Autowired
    private NewsService newsService;


    /**
     * @param
     * @param entity
     * @Version 1.0
     * @Description 数据列表
     * @Return java.lang.Object
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(NewsDTO entity) {

        PageHelper.startPage(entity.getTablepar().getPageNum(), entity.getTablepar().getPageSize());
        if (!StringUtils.isEmpty(entity.getTablepar().getSearchText())) {
            //设置查询条件

        }
        List<NewsDTO> select = newsService.select(entity);
        PageInfo<NewsDTO> pageInfo = new PageInfo(select);
        TableSplitResult<NewsDTO> result = new TableSplitResult<NewsDTO>(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
        return result;
    }


    /**
     * @param entity
     * @Version 1.0
     * @Description：数据新增
     * @Return
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(NewsDTO entity) {
        int result = newsService.insertSelective(entity);
        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }

    /**
     * @param ids
     * @Version 1.0
     * @Description：根据id 删除数据
     * @Return
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(@RequestParam("ids") String ids) {
        int result = newsService.deleteByIds(ids);
        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }


    /**
     * @param id
     * @Version 1.0
     * @Description：详情页面
     * @Return java.lang.String
     */
    @GetMapping("/getById")
    public NewsDTO detail(@RequestParam("id") String id) {
        return newsService.selectByPrimaryKey(id);

    }

    /**
     * @param
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsDTO entity) {
        return toAjax(newsService.updateByPrimaryKeySelective(entity));
    }

    @GetMapping("/getAll")
    public List<NewsDTO> getAll() {
        return newsService.selectAll();

    }

}
