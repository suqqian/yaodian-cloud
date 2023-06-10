package com.template.edurptemplate.auth.sysper.entity;

import com.template.edurptemplate.auth.sysperrole.entity.TSysPermissionRoleDTO;
import com.template.edurptemplate.common.entity.Tablepar;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ProjectName: cloud-template
 * @Package: com.template.edurptemplate.auth.sysper.entity
 * @ClassName: TablePerDTO
 * @Author: zhangqiang
 * @Description:
 * @Date: 2023/6/9 00:29
 * @Version: 1.0
 */
@Data
public class TablePerDTO {
    private Tablepar tablepar;
    private TSysPermissionRoleDTO entity;
}
