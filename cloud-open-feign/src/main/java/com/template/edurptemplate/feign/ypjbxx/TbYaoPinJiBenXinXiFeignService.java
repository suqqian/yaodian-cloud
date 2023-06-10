package com.template.edurptemplate.feign.ypjbxx;

import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.fenlei.entity.TableFenLeiDTO;
import com.template.edurptemplate.fenlei.entity.TbYaoPinFenLeiDTO;
import com.template.edurptemplate.ypjbxx.entity.TableYpjbxxDTO;
import com.template.edurptemplate.ypjbxx.entity.TbYaoPinJiBenXinXiDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.feign.ypjbxx
 * @ClassName: TbYaoPinJiBenXinXiFeignService
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/10 09:25
 * @Version: 1.0
 */
@FeignClient(value = "server")
public interface TbYaoPinJiBenXinXiFeignService {
    @PostMapping("/tbYaoPinJiBenXinXi/list")
    Object list(@RequestBody TableYpjbxxDTO tableYpjbxxDTO);

    @PostMapping("/tbYaoPinJiBenXinXi/add")
    public AjaxResult add(@RequestBody TbYaoPinJiBenXinXiDTO entity);

    @PostMapping("/tbYaoPinJiBenXinXi/remove")
    public AjaxResult remove(@RequestParam("ids")  String ids);

    @GetMapping("/tbYaoPinJiBenXinXi/getById")
    public TbYaoPinJiBenXinXiDTO getById(@RequestParam("id")  String id);

    @PostMapping("/tbYaoPinJiBenXinXi/edit")
    public AjaxResult edit(@RequestBody TbYaoPinJiBenXinXiDTO entity);
}
