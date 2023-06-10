package com.template.edurptemplate.auth.sysrole.entity;

import com.template.edurptemplate.common.entity.Tablepar;
import lombok.Data;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.auth.sysrole.entity
 * @ClassName: TableRoleDTO
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/9 00:25
 * @Version: 1.0
 */
@Data
public class TableRoleDTO {
    private Tablepar tablepar;
    private TSysRoleDTO entity;
}
