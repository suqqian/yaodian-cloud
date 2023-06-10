package com.template.edurptemplate.ceshi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.ceshi.entity.TbCeShiDTO;
import com.template.edurptemplate.ceshi.service.TbCeShiService;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.common.entity.Tablepar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 测试(TbCeShi)表控制层
 *
 * @author
 * @since 2023-05-07 21:19:03
 */
@Controller
@RequestMapping("tbCeShi")
public class TbCeShiController extends BaseController {
    private static final String prefixUrl = "tbCeShi/";
    /**
     * 服务对象
     */
    @Autowired
    private TbCeShiService tbCeShiService;

    /**
     * @param model
     * @Version 1.0
     * @Description:进入数据列表，进入页面
     * @Return java.lang.String
     */
    @GetMapping("/view")
    public String view(ModelMap model) {
        model.put("userType", "admin");
        return prefixUrl + "/list";
    }


    /**
     * @param tablepar
     * @param entity
     * @Version 1.0
     * @Description 数据列表
     * @Return java.lang.Object
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(Tablepar tablepar, TbCeShiDTO entity) {

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        if (!StringUtils.isEmpty(tablepar.getSearchText())) {
            //设置查询条件

        }
        List<TbCeShiDTO> select = tbCeShiService.select(entity);
        PageInfo<TbCeShiDTO> pageInfo = new PageInfo(select);
        TableSplitResult<TbCeShiDTO> result = new TableSplitResult<TbCeShiDTO>(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
        return result;
    }

    /**
     * 新增跳转
     *
     * @param modelMap
     * @return
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        return prefixUrl + "/add";
    }

    /**
     * @param entity
     * @Version 1.0
     * @Description：数据新增
     * @Return
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(TbCeShiDTO entity) {
        int result = tbCeShiService.insertSelective(entity);
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
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int result = tbCeShiService.deleteByIds(ids);
        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }


    /**
     * @param id
     * @param mmap
     * @Version 1.0
     * @Description：进入更新页面（编辑页面）
     * @Return java.lang.String
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("tbCeShi", tbCeShiService.selectByPrimaryKey(id));
        return prefixUrl + "/edit";
    }

    /**
     * @param id
     * @param mmap
     * @Version 1.0
     * @Description：详情页面
     * @Return java.lang.String
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("tbCeShi", tbCeShiService.selectByPrimaryKey(id));
        return prefixUrl + "/detail";
    }

    /**
     * @param
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbCeShiDTO entity) {

        return toAjax(tbCeShiService.updateByPrimaryKeySelective(entity));
    }

}
