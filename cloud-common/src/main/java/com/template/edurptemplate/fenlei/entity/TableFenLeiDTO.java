package com.template.edurptemplate.fenlei.entity;

import com.template.edurptemplate.common.entity.Tablepar;
import lombok.Data;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.fenlei.entity
 * @ClassName: TableFenLeiDTO
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/10 09:42
 * @Version: 1.0
 */
@Data
public class TableFenLeiDTO {
    private Tablepar tablepar;
    private TbYaoPinFenLeiDTO entity;
}
