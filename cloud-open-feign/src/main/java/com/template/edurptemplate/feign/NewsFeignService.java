package com.template.edurptemplate.feign;

import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.entity.NewsDTO;
import com.template.edurptemplate.fenlei.entity.TableFenLeiDTO;
import com.template.edurptemplate.fenlei.entity.TbYaoPinFenLeiDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 公告信息(News)表数据库访问层
 *
 * @author
 */

@FeignClient(value = "server")
public interface NewsFeignService {
    @PostMapping("/news/list")
    Object list(@RequestBody TableFenLeiDTO tableFenLeiDTO);

    @PostMapping("/news/add")
    AjaxResult add(@RequestBody NewsDTO entity);

    @PostMapping("/news/remove")
    AjaxResult remove(@RequestParam("ids") String ids);

    @GetMapping("/news/getById")
    TbYaoPinFenLeiDTO getById(@RequestParam("id") String id);

    @PostMapping("/news/edit")
    AjaxResult edit(@RequestBody NewsDTO entity);

    @GetMapping("/news/getAll")
    List<TbYaoPinFenLeiDTO> getAll();
}
