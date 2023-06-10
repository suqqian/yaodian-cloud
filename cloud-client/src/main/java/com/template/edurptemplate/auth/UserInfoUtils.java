package com.template.edurptemplate.auth;

import com.template.edurptemplate.auth.user.entity.TSysUserDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common
 * @ClassName: UserInfoUtils
 * @Author: zhangqiang
 * @Description:
 * @Version: 1.0
 */
public class UserInfoUtils {

    public static String getUserType() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TSysUserDTO tSysUserDTO = (TSysUserDTO) request.getSession().getAttribute("user");
        String type = tSysUserDTO.getType();
        return type;
    }

    public static String getUserRelId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TSysUserDTO tSysUserDTO = (TSysUserDTO) request.getSession().getAttribute("user");
        return tSysUserDTO.getRelId();
    }

    public static TSysUserDTO getUserInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        TSysUserDTO tSysUserDTO = (TSysUserDTO) request.getSession().getAttribute("user");
        return tSysUserDTO;
    }
}

