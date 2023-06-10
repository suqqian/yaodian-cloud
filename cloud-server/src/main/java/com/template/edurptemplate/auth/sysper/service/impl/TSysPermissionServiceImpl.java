package com.template.edurptemplate.auth.sysper.service.impl;

import com.template.edurptemplate.auth.sysper.entity.TSysPermissionDTO;
import com.template.edurptemplate.auth.sysper.mapper.TSysPermissionMapper;
import com.template.edurptemplate.auth.sysper.service.TSysPermissionService;
import com.template.edurptemplate.common.dao.SysBaseMapper;
import com.template.edurptemplate.common.entity.BootstrapTree;
import com.template.edurptemplate.common.service.impl.SysBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限表(TSysPermission)表服务实现类
 *
 * @author 作者名字
 */
@Service("tSysPermissionService")
public class TSysPermissionServiceImpl extends SysBaseServiceImpl<TSysPermissionDTO, String> implements TSysPermissionService {
    @Resource
    private TSysPermissionMapper tSysPermissionMapper;

    @Override
    public SysBaseMapper<TSysPermissionDTO, String> getMappser() {
        return tSysPermissionMapper;
    }

    @Override
    public BootstrapTree getbooBootstrapTreePerm(String userId) {
        List<BootstrapTree> treeList = new ArrayList<BootstrapTree>();
        List<TSysPermissionDTO> menuList;
        if (!StringUtils.isEmpty(userId)) {
            menuList = getall(userId);
        } else {
            menuList = selectAllBySql();
        }
        treeList = getbooBootstrapTreePerm(menuList, "0");
        if (treeList != null && treeList.size() == 1) {
            return treeList.get(0);
        }
        return new BootstrapTree("菜单", "fa fa-home", "", "-1", "###", 0, treeList, "", 0);
    }

    @Override
    public List<TSysPermissionDTO> selectAllBySql() {
        return tSysPermissionMapper.selectAllBySql();
    }

    @Override
    public Object getCheckPrem(String roleId) {
        Map<String, Object> map = new HashMap<String, Object>();
        //设置选中
        map.put("checked", true);
        List<TSysPermissionDTO> myTsysPermissions = tSysPermissionMapper.queryRoleId(roleId);
        // 获取所有的权限∂
        BootstrapTree sysPermissions = getbooBootstrapTreePerm(null);
        iterationCheckPre(sysPermissions, myTsysPermissions, map);
        return sysPermissions;
    }

    public Boolean ifpermissions(List<TSysPermissionDTO> myTsysPermissions, BootstrapTree sysPermission) {
        for (TSysPermissionDTO mytsysPermission : myTsysPermissions) {
            if (sysPermission.getId().equals(mytsysPermission.getId())) {
                return true;
            }
        }
        return false;
    }

    public void iterationCheckPre(BootstrapTree pboostrapTree, List<TSysPermissionDTO> myTsysPermissions, Map<String, Object> map) {
        if (null != pboostrapTree) {
            if (ifpermissions(myTsysPermissions, pboostrapTree)) {
                pboostrapTree.setState(map);
            }
            List<BootstrapTree> bootstrapTreeList = pboostrapTree.getNodes();
            if (null != bootstrapTreeList && !bootstrapTreeList.isEmpty()) {
                for (BootstrapTree bootstrapTree : bootstrapTreeList) {
                    if (ifpermissions(myTsysPermissions, bootstrapTree)) {// 菜单栏设置
                        bootstrapTree.setState(map);
                    }
                    //检查子节点
                    iterationCheckPre(bootstrapTree, myTsysPermissions, map);
                }
            }
        }
    }

    public List<TSysPermissionDTO> getall(String userid) {
        return tSysPermissionMapper.selectByUserId(userid);
    }

    private static List<BootstrapTree> getbooBootstrapTreePerm(List<TSysPermissionDTO> menuList, String parentId) {
        List<BootstrapTree> treeList = new ArrayList<>();
        List<BootstrapTree> childList = null;
        for (TSysPermissionDTO p : menuList) {
            p.setPid(p.getPid() == null || p.getPid().trim().equals("") ? "0" : p.getPid());
            if (p.getPid().trim().equals(parentId)) {
                if (p.getChildCount() != null && p.getChildCount() > 0) {
                    childList = getbooBootstrapTreePerm(menuList, String.valueOf(p.getId()));
                }
                BootstrapTree bootstrapTree = new BootstrapTree(p.getName(), p.getIcon(), "", String.valueOf(p.getId()), p.getUrl(), p.getIsBlank(), childList, p.getPerms(), p.getVisible());
                treeList.add(bootstrapTree);
                childList = null;
            }
        }
        return treeList.size() > 0 ? treeList : null;
    }

}
