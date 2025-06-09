package com.szmtr.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.szmtr.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.szmtr.common.core.constant.UserConstants;
import com.szmtr.common.core.utils.StringUtils;
import com.szmtr.common.core.web.controller.BaseController;
import com.szmtr.common.core.web.domain.AjaxResult;
import com.szmtr.common.log.annotation.Log;
import com.szmtr.common.log.enums.BusinessType;
import com.szmtr.common.security.annotation.RequiresPermissions;
import com.szmtr.common.security.utils.SecurityUtils;
import com.szmtr.system.domain.SysMenu;
import com.szmtr.system.service.ISysMenuService;

/**
 * 菜单信息
 *
 * @author szmtr
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController {
    @Autowired
    private ISysMenuService menuService;
//
//    /**
//     * 获取菜单列表
//     */
//    @RequiresPermissions("system:menu:list")
//    @GetMapping("/list")
//    public AjaxResult list(SysMenu menu) {
//        Long userId = SecurityUtils.getLoginUser().getUserid();
//        List<SysMenu> menus = menuService.selectMenuList(menu, userId);
//        return success(menus);
//    }
//
//    /**
//     * 根据菜单编号获取详细信息
//     */
//    @RequiresPermissions("system:menu:query")
//    @GetMapping(value = "/{menuId}")
//    public AjaxResult getInfo(@PathVariable Long menuId) {
//        return success(menuService.selectMenuById(menuId));
//    }
//
//    /**
//     * 获取菜单下拉树列表
//     */
//    @GetMapping("/treeselect")
//    public AjaxResult treeselect(SysMenu menu) {
//        Long userId = SecurityUtils.getLoginUser().getUserid();
//        List<SysMenu> menus = menuService.selectMenuList(menu, userId);
//        return success(menuService.buildMenuTreeSelect(menus));
//    }

//    /**
//     * 加载对应角色菜单列表树
//     */
//    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
//    public AjaxResult roleMenuTreeselect(@PathVariable("roleId") Long roleId) {
//        Long userId = SecurityUtils.getLoginUser().getUserid();
//        List<SysMenu> menus = menuService.selectMenuList(userId);
//        AjaxResult ajax = AjaxResult.success();
//        ajax.put("checkedKeys", menuService.selectMenuListByRoleId(roleId));
//        ajax.put("menus", menuService.buildMenuTreeSelect(menus));
//        return ajax;
//    }
//
////    /**
////     * 新增菜单
////     */
////    @RequiresPermissions("system:menu:add")
////    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
////    @PostMapping
////    public AjaxResult add(@Validated @RequestBody SysMenu menu) {
////        if (!menuService.checkMenuNameUnique(menu)) {
////            return error("新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
////        } else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.ishttp(menu.getPath())) {
////            return error("新增菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
////        }
////        menu.setCreateBy(SecurityUtils.getUsername());
////        return toAjax(menuService.insertMenu(menu));
////    }
////
//////    /**
//////     * 修改菜单
//////     */
//////    @RequiresPermissions("system:menu:edit")
//////    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
//////    @PutMapping
//////    public AjaxResult edit(@Validated @RequestBody SysMenu menu) {
//////        if (!menuService.checkMenuNameUnique(menu)) {
//////            return error("修改菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
//////        } else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.ishttp(menu.getPath())) {
//////            return error("修改菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
//////        } else if (menu.getMenuId().equals(menu.getParentId())) {
//////            return error("修改菜单'" + menu.getMenuName() + "'失败，上级菜单不能选择自己");
//////        }
//////        menu.setUpdateBy(SecurityUtils.getUsername());
//////        return toAjax(menuService.updateMenu(menu));
//////    }

//    /**
//     * 删除菜单
//     */
//    @RequiresPermissions("system:menu:remove")
//    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{menuId}")
//    public AjaxResult remove(@PathVariable("menuId") Long menuId) {
//        if (menuService.hasChildByMenuId(menuId)) {
//            return warn("存在子菜单,不允许删除");
//        }
//        if (menuService.checkMenuExistRole(menuId)) {
//            return warn("菜单已分配,不允许删除");
//        }
//        return toAjax(menuService.deleteMenuById(menuId));
//    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRouters")
    public AjaxResult getRouters() {
        List<SysMenu> menus = new ArrayList<>();

        SysMenu sysManagerMenu = new SysMenu();
        sysManagerMenu.setMenuId(1L);
        sysManagerMenu.setMenuName("系统管理");
        sysManagerMenu.setParentId(0L);
        sysManagerMenu.setOrderNum(1);
        sysManagerMenu.setPath("system");
        sysManagerMenu.setIsFrame("1");
        sysManagerMenu.setIsCache("0");
        sysManagerMenu.setMenuType("M");
        sysManagerMenu.setVisible("0");
        sysManagerMenu.setStatus("0");
        sysManagerMenu.setIcon("system");
        menus.add(sysManagerMenu);

        // 新增权限管理父菜单
        SysMenu authMenu = new SysMenu();
        authMenu.setMenuId(2L);
        authMenu.setMenuName("权限管理");
        authMenu.setParentId(0L);
        authMenu.setOrderNum(2);
        authMenu.setPath("auth");
        authMenu.setIsFrame("1");
        authMenu.setIsCache("0");
        authMenu.setMenuType("M");
        authMenu.setVisible("0");
        authMenu.setStatus("0");
        authMenu.setIcon("codepen");
        menus.add(authMenu);

        // 权限管理子菜单
        addChild(menus, 2L, 201L, "菜单定义", "system/menu/index", "menu", 1);
        addChild(menus, 2L, 202L, "权限组定义", "system/permGroup/index", "permGroup", 2);
        addChild(menus, 2L, 203L, "供应商定义", "system/supplier/index", "supplier", 3);
        addChild(menus, 2L, 204L, "人员和日志", "system/person/index", "person", 4);

        // 编码体系父菜单（保持原有ID）
        SysMenu codeSystem = new SysMenu();
        codeSystem.setMenuId(2004L);
        codeSystem.setMenuName("编码体系");
        codeSystem.setParentId(0L);
        codeSystem.setOrderNum(3);
        codeSystem.setPath("codeSystem");
        codeSystem.setIsFrame("1");
        codeSystem.setIsCache("0");
        codeSystem.setMenuType("M");
        codeSystem.setVisible("0");
        codeSystem.setStatus("0");
        codeSystem.setIcon("cluster");
        menus.add(codeSystem);

        // 编码体系子菜单
        addChild(menus, 2004L, 2005L, "编码体系", "business/encodingScheme/index", "encodingScheme", 1);
        addChild(menus, 2004L, 2006L, "编码规则主数据", "business/rule/index", "rule", 2);
        addChild(menus, 2004L, 2007L, "编码图元管理", "business/element/index", "element", 3);
        addChild(menus, 2004L, 2008L, "标识标注", "business/tag/index", "tag", 4);

        // 新增项目编码管理父菜单
        SysMenu projectMenu = new SysMenu();
        projectMenu.setMenuId(3L);
        projectMenu.setMenuName("项目编码管理");
        projectMenu.setParentId(0L);
        projectMenu.setOrderNum(4);
        projectMenu.setPath("project");
        projectMenu.setIsFrame("1");
        projectMenu.setIsCache("0");
        projectMenu.setMenuType("M");
        projectMenu.setVisible("0");
        projectMenu.setStatus("0");
        projectMenu.setIcon("file-protect");
        menus.add(projectMenu);

        // 项目编码管理子菜单
        addChild(menus, 3L, 301L, "项目编码", "project/main/index", "project", 1);
        addChild(menus, 3L, 302L, "项目编码规则", "project/projRule/index", "projRule", 2);
        addChild(menus, 3L, 303L, "编码规则变更单", "project/ruleChange/index", "ruleChange", 3);
        addChild(menus, 3L, 304L, "网页赋码", "project/webCode/index", "webCode", 4);
        addChild(menus, 3L, 305L, "编码归档", "project/archive/index", "archive", 5);
        addChild(menus, 3L, 306L, "编码全生命周期管理", "project/lifeCycle/index", "lifeCycle", 6);

        // 新增统计分析父菜单
        SysMenu analyticsMenu = new SysMenu();
        analyticsMenu.setMenuId(4L);
        analyticsMenu.setMenuName("统计分析");
        analyticsMenu.setParentId(0L);
        analyticsMenu.setOrderNum(5);
        analyticsMenu.setPath("analytics");
        analyticsMenu.setIsFrame("1");
        analyticsMenu.setIsCache("0");
        analyticsMenu.setMenuType("M");
        analyticsMenu.setVisible("0");
        analyticsMenu.setStatus("0");
        analyticsMenu.setIcon("fund");
        menus.add(analyticsMenu);

        // 统计分析子菜单
        addChild(menus, 4L, 401L, "启动中心", "analytics/dashboard/index", "dashboard", 1);
        addChild(menus, 4L, 402L, "统计查询", "analytics/stat/index", "stat", 2);
        addChild(menus, 4L, 403L, "内置图标", "analytics/icons/index", "icons", 3);

        // 原有系统管理子菜单保持不变
        addChild(menus, 1L, 101L, "权限组定义", "system/role/index", "role", 1);
        addChild(menus, 1L, 102L, "菜单定义", "system/menu/index", "menu", 2);

        List<SysMenu> menusList = menuService.selectMenuTreeByUserId(menus);
        return success(menuService.buildMenus(menusList));
    }

    // 子菜单构
    private void addChild(List<SysMenu> menus, Long parentId, Long menuId,
                          String name, String component, String path, int order) {
        SysMenu menu = new SysMenu();
        menu.setMenuId(menuId);
        menu.setMenuName(name);
        menu.setParentId(parentId);
        menu.setOrderNum(order);
        menu.setPath(path);
        menu.setComponent(component);
        menu.setMenuType("C");
        menu.setIsFrame("1");
        menu.setIsCache("0");
        menu.setVisible("0");
        menu.setStatus("0");
        menu.setIcon("");
        menus.add(menu);
    }
}