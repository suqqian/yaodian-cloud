package com.template.edurptemplate.auth;

import com.template.edurptemplate.auth.user.entity.TSysUserDTO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.service
 * @ClassName: LoginInterceptor
 * @Author: 作者名字
 * @Description:登陆拦截器
 * @Version: 1.0
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return true 的时候才会执行下一个操作，即拦截器不执行
        TSysUserDTO user = (TSysUserDTO) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
        } else {
            return true;
        }
        return false;
    }

}
