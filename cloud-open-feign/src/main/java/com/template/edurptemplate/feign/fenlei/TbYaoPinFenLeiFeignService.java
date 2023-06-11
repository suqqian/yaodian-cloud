package com.template.edurptemplate.feign.fenlei;

import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.Tablepar;
import com.template.edurptemplate.fenlei.entity.TableFenLeiDTO;
import com.template.edurptemplate.fenlei.entity.TbYaoPinFenLeiDTO;
import com.template.edurptemplate.ypjbxx.entity.TableYpjbxxDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.feign.fenlei
 * @ClassName: TbYaoPinFenLeiFeignService
 * @Description:
 * @Version: 1.0
 */
@FeignClient(value = "server")
public interface TbYaoPinFenLeiFeignService {
    @PostMapping("/tbYaoPinFenLei/list")
    Object list(@RequestBody TableFenLeiDTO tableFenLeiDTO);

    @PostMapping("/tbYaoPinFenLei/add")
    public AjaxResult add(@RequestBody TbYaoPinFenLeiDTO entity);

    @PostMapping("/tbYaoPinFenLei/remove")
    public AjaxResult remove(@RequestParam("ids") String ids);

    @GetMapping("/tbYaoPinFenLei/getById")
    public TbYaoPinFenLeiDTO getById(@RequestParam("id") String id);

    @PostMapping("/tbYaoPinFenLei/edit")
    public AjaxResult edit(@RequestBody TbYaoPinFenLeiDTO entity);

    @GetMapping("/tbYaoPinFenLei/getAll")
    List<TbYaoPinFenLeiDTO> getAll();
}
