package com.template.edurptemplate.ypjbxx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.TableSplitResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.feign.fenlei.TbYaoPinFenLeiFeignService;
import com.template.edurptemplate.feign.ypjbxx.TbYaoPinJiBenXinXiFeignService;
import com.template.edurptemplate.fenlei.entity.TbYaoPinFenLeiDTO;
import com.template.edurptemplate.ypjbxx.entity.TableYpjbxxDTO;
import com.template.edurptemplate.ypjbxx.entity.TbYaoPinJiBenXinXiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    private static final String prefixUrl = "tbYaoPinJiBenXinXi/";
    /**
     * 服务对象
     */
    @Autowired
    private TbYaoPinJiBenXinXiFeignService tbYaoPinJiBenXinXiService;
    @Resource
    private TbYaoPinFenLeiFeignService tbYaoPinFenLeiFeignService;

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
     * @param tablepar
     * @param entity
     * @Version 1.0
     * @Description 数据列表
     * @Return java.lang.Object
     */
    @PostMapping("/list")
    @ResponseBody
    public Object list(Tablepar tablepar, TbYaoPinJiBenXinXiDTO entity) {
        TableYpjbxxDTO tableYpjbxxDTO = new TableYpjbxxDTO();
        tableYpjbxxDTO.setTablepar(tablepar);
        tableYpjbxxDTO.setTbYaoPinJiBenXinXiDTO(entity);
        return tbYaoPinJiBenXinXiService.list(tableYpjbxxDTO);
    }

    /**
     * 新增跳转
     *
     * @param modelMap
     * @return
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        List<TbYaoPinFenLeiDTO> yaoPinFenLeiList = tbYaoPinFenLeiFeignService.getAll();
        modelMap.put("yaoPinFenLeiList", yaoPinFenLeiList);
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
    public AjaxResult add(TbYaoPinJiBenXinXiDTO entity) {
        return tbYaoPinJiBenXinXiService.add(entity);
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
       return tbYaoPinJiBenXinXiService.remove(ids);

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
        List<TbYaoPinFenLeiDTO> yaoPinFenLeiList = tbYaoPinFenLeiFeignService.getAll();
        mmap.put("yaoPinFenLeiList", yaoPinFenLeiList);
        mmap.put("tbYaoPinJiBenXinXi", tbYaoPinJiBenXinXiService.getById(id));
        return prefixUrl + "/edit";
    }

    /**
     * @param
     * @Version 1.0
     * @Description: 保存数据信息
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbYaoPinJiBenXinXiDTO entity) {
       return tbYaoPinJiBenXinXiService.edit(entity);
    }

}
