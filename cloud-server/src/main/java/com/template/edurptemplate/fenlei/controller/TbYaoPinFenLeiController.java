package com.template.edurptemplate.fenlei.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.fenlei.entity.TableFenLeiDTO;
import com.template.edurptemplate.fenlei.entity.TbYaoPinFenLeiDTO;
import com.template.edurptemplate.fenlei.service.TbYaoPinFenLeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 药品分类(TbYaoPinFenLei)表控制层
 *
 * @author zhouzhiwei
 * @since 2021-12-25 13:15:39
 */
@Controller
@RequestMapping("tbYaoPinFenLei")
public class TbYaoPinFenLeiController extends BaseController {
    private static final String prefixUrl = "tbYaoPinFenLei/";
    /**
     * 服务对象
     */
    @Autowired
    private TbYaoPinFenLeiService tbYaoPinFenLeiService;

    /**
     * @param model
     * @Version 1.0
     * @Description:进入数据列表，进入页面
     * @Return java.lang.String
     */
    @GetMapping("/view")
    public String view(ModelMap model) {
        return prefixUrl + "/list";
    }


    /**
     * @param
     * @param
     * @Version 1.0
     * @Description 数据列表
     * @Return java.lang.Object
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(@RequestBody TableFenLeiDTO tableFenLeiDTO) {
        TbYaoPinFenLeiDTO entity = tableFenLeiDTO.getEntity();
        PageHelper.startPage(tableFenLeiDTO.getTablepar().getPageNum(), tableFenLeiDTO.getTablepar().getPageSize());
        if (!StringUtils.isEmpty(tableFenLeiDTO.getTablepar().getSearchText())) {
            //设置查询条件
            entity.setLeiMing(tableFenLeiDTO.getTablepar().getSearchText());
        }
        List<TbYaoPinFenLeiDTO> select = tbYaoPinFenLeiService.select(entity);
        PageInfo<TbYaoPinFenLeiDTO> pageInfo = new PageInfo(select);
        TableSplitResult<TbYaoPinFenLeiDTO> result = new TableSplitResult<TbYaoPinFenLeiDTO>(pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
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
    public AjaxResult add(@RequestBody TbYaoPinFenLeiDTO entity) {
        int result = tbYaoPinFenLeiService.insertSelective(entity);
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
    public AjaxResult remove(@RequestParam("ids") String ids) {
        int result = tbYaoPinFenLeiService.deleteByIds(ids);
        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }


    /**
     * @param id
     * @param
     * @Version 1.0
     * @Description：进入更新页面（编辑页面）
     * @Return java.lang.String
     */
    @GetMapping("/edit")
    public TbYaoPinFenLeiDTO edit(@RequestParam String id) {
        return tbYaoPinFenLeiService.selectByPrimaryKey(id);

    }

    /**
     * @param
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody TbYaoPinFenLeiDTO entity) {

        return toAjax(tbYaoPinFenLeiService.updateByPrimaryKeySelective(entity));
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<TbYaoPinFenLeiDTO> getAll() {
        return tbYaoPinFenLeiService.selectAll();
    }

}
