package com.template.edurptemplate.common.file;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.file
 * @ClassName: WangResult
 * @Author: 作者名字
 * @Description:
 * @Version: 1.0
 */
@Data

public class WangResult {
    private int errno;
    private List<WangData> data;

}
