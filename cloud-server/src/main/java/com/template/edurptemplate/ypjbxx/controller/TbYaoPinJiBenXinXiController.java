package com.template.edurptemplate.ypjbxx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.fenlei.entity.TbYaoPinFenLeiDTO;
import com.template.edurptemplate.ypjbxx.entity.TableYpjbxxDTO;
import com.template.edurptemplate.ypjbxx.entity.TbYaoPinJiBenXinXiDTO;
import com.template.edurptemplate.ypjbxx.service.TbYaoPinJiBenXinXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 药品基本信息(TbYaoPinJiBenXinXi)表控制层
 *
 * @author zhouzhiwei
 * @since 2022-01-01 10:21:10
 */
@Controller
@RequestMapping("tbYaoPinJiBenXinXi")
public class TbYaoPinJiBenXinXiController extends BaseController {

    @Autowired
    private TbYaoPinJiBenXinXiService tbYaoPinJiBenXinXiService;


    /**
     * @param tablepar
     * @param entity
     * @Version 1.0
     * @Description 数据列表
     * @Return java.lang.Object
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(@RequestBody TableYpjbxxDTO tableYpjbxxDTO) {
        Tablepar tablepar = tableYpjbxxDTO.getTablepar();
        TbYaoPinJiBenXinXiDTO entity = tableYpjbxxDTO.getTbYaoPinJiBenXinXiDTO();
        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        if (!StringUtils.isEmpty(tablepar.getSearchText())) {
            //设置查询条件
            entity.setYaoPinMingCheng(tablepar.getSearchText());
        }
        List<TbYaoPinJiBenXinXiDTO> select = tbYaoPinJiBenXinXiService.select(entity);
        PageInfo<TbYaoPinJiBenXinXiDTO> pageInfo = new PageInfo(select);
        TableSplitResult<TbYaoPinJiBenXinXiDTO> result = new TableSplitResult<TbYaoPinJiBenXinXiDTO>(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
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
    public AjaxResult add(@RequestBody TbYaoPinJiBenXinXiDTO entity) {
        int result = tbYaoPinJiBenXinXiService.insertSelective(entity);
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
        int result = tbYaoPinJiBenXinXiService.deleteByIds(ids);
        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }


    /**
     * @param
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody TbYaoPinJiBenXinXiDTO entity) {

        return toAjax(tbYaoPinJiBenXinXiService.updateByPrimaryKeySelective(entity));
    }

    @GetMapping("/getById")
    @ResponseBody
    public TbYaoPinJiBenXinXiDTO getById(@RequestParam String id) {
        return tbYaoPinJiBenXinXiService.selectByPrimaryKey(id);
    }

}
