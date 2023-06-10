package com.template.edurptemplate.common.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.Util
 * @ClassName: TimeUtils
 * @Author: zhangqiang
 * @Description:
 * @Version: 1.0
 */
public class TimeUtils {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static String getCurrentTime(Date date) {
        return sdf.format(date);
    }
}
