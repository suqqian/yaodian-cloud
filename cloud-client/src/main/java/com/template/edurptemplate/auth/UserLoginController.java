package com.template.edurptemplate.auth;

import com.template.edurptemplate.auth.user.entity.TSysUserDTO;
import com.template.edurptemplate.common.controller.BaseController;
import com.template.edurptemplate.common.entity.AjaxResult;
import com.template.edurptemplate.common.entity.BootstrapTree;
import com.template.edurptemplate.common.entity.TitleVo;
import com.template.edurptemplate.feign.auth.sysper.TSysPermissionFeignService;
import com.template.edurptemplate.feign.auth.sysrole.TSysRoleFeignService;
import com.template.edurptemplate.feign.auth.user.TSysUserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.login
 * @ClassName: UserLogin
 * @Author: 作者名字
 * @Description: 用户登陆
 * @Version: 1.0
 */
@Controller
@RequestMapping("admin")
public class UserLoginController extends BaseController {
    @Value("${sys.config.sysname}")
    private String sysName;


    @Autowired
    private TSysPermissionFeignService sysPermissionService;
    @Autowired
    private TSysUserFeignService sysUserService;
    @Autowired
    private TSysRoleFeignService sysRoleService;

    private String prefix = "admin";

    /**
     * @param
     * @Author 作者名字
     * @Version 1.0
     * @Description： 进入到登陆页面
     * @Return java.lang.String
     */
    @GetMapping("login")
    public String login(ModelMap map) {
        map.addAttribute("sysName", sysName);
        return "/login";
    }

    /**
     * @param username
     * @param password
     * @param request
     * @Author 作者名字
     * @Version 1.0
     * @Description: 用户登陆
     * @Return com.template.edurptemplate.common.entity.AjaxResult
     */
    @ResponseBody
    @PostMapping("login")
    public AjaxResult login(String username, String password, HttpServletRequest request) {
        TSysUserDTO tSysUserDTO = new TSysUserDTO();
        tSysUserDTO.setUsername(username);
        tSysUserDTO.setPassword(password);
        TSysUserDTO tSysUserDTO1 = sysUserService.selectOne(tSysUserDTO);
        request.getSession().setAttribute("user", tSysUserDTO);
        if (tSysUserDTO1 == null) {
            return AjaxResult.error(500, "用户名或密码不正确");
        } else {
            return AjaxResult.success(tSysUserDTO1.getId());
        }
    }

    /**
     * @param userId
     * @Author 作者名字
     * @Version 1.0
     * @Description: 根据用户id获取权限信息
     * @Return java.lang.String
     */
    @GetMapping("toindex")
    public String index(String userId, HttpServletRequest request) {
        TSysUserDTO tSysUserDTO = sysUserService.selectByPrimaryKey(userId);
        request.getSession().setAttribute("user", tSysUserDTO);
        request.getSession().setAttribute("uid", tSysUserDTO.getId());
        //获取菜单栏
        BootstrapTree bootstrapTree = sysPermissionService.getbooBootstrapTree(userId);
        request.getSession().setAttribute("bootstrapTree", bootstrapTree);
        request.getSession().setAttribute("sessionUserName", tSysUserDTO.getUserrelname());
        return prefix + "/index";
    }

    /**
     * @param map
     * @Version 1.0
     * @Description: 设置页面默认的首页
     * @Return java.lang.String
     * todo :设置页面默认的首页
     */
    @GetMapping("/main")
    public String main(ModelMap map) {
        setTitle(map, new TitleVo("首页", "首页", true, "欢迎进入", true, false));
        return "/admin/user/list";
    }

    /**
     * @param request
     * @Version 1.0
     * @Description 退出
     * @Return java.lang.String
     */
    @GetMapping("/loginOut")
    public String loginout(HttpServletRequest request, ModelMap map) {
        map.addAttribute("sysName", sysName);
        request.getSession().invalidate();
        return "/login";

    }
}
