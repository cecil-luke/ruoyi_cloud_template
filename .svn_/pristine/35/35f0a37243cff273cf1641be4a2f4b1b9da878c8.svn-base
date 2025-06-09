package com.szmtr.system.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.ArrayUtils;
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
import org.springframework.web.multipart.MultipartFile;
import com.szmtr.common.core.domain.R;
import com.szmtr.common.core.utils.StringUtils;
import com.szmtr.common.core.utils.poi.ExcelUtil;
import com.szmtr.common.core.web.controller.BaseController;
import com.szmtr.common.core.web.domain.AjaxResult;
import com.szmtr.common.core.web.page.TableDataInfo;
import com.szmtr.common.log.annotation.Log;
import com.szmtr.common.log.enums.BusinessType;
import com.szmtr.common.security.annotation.InnerAuth;
import com.szmtr.common.security.annotation.RequiresPermissions;
import com.szmtr.common.security.service.TokenService;
import com.szmtr.common.security.utils.SecurityUtils;
import com.szmtr.system.api.domain.SysDept;
import com.szmtr.system.api.domain.SysRole;
import com.szmtr.system.api.domain.SysUser;
import com.szmtr.system.api.model.LoginUser;
import com.szmtr.system.service.ISysConfigService;
import com.szmtr.system.service.ISysPermissionService;

/**
 * 用户信息
 *
 * @author szmtr
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理模块", description = "包含用户账号的增删改查及权限分配") // 分组注释
public class SysUserController extends BaseController {
    @Autowired
    private ISysPermissionService permissionService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private TokenService tokenService;

    /**
     * 获取用户列表
     */
    @Operation(summary = "查询用户分页列表", description = "支持多条件筛选查询，需管理员权限", method = "GET", responses = {@ApiResponse(responseCode = "200", description = "成功获取数据"), @ApiResponse(responseCode = "401", description = "未授权访问")})
    @RequiresPermissions("system:user:list")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user) {
        startPage();
        List<SysUser> list = null;
        return getDataTable(list);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.importTemplateExcel(response, "用户数据");
    }

    /**
     * 获取当前用户信息
     */
    @GetMapping("/info/{username}")
    public R<LoginUser> info(@PathVariable("username") String username) {
        username = "admin";
        String password = "admin123";
        SysUser sysUser = new SysUser();
        sysUser.setUserId(1L);
        sysUser.setUserName("admin");
        sysUser.setDeptId(103L);
        sysUser.setNickName("若依");
        sysUser.setEmail("ry@163.com");
        sysUser.setPhonenumber("15888888888");
        sysUser.setSex("1");
        sysUser.setPassword("$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2");
        sysUser.setDelFlag("0");
        sysUser.setRemark("管理员");
//        SysUser sysUser = userService.selectUserByUserName(username);
        if (StringUtils.isNull(sysUser)) {
            return R.fail("用户名或密码错误");
        }
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(sysUser);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(sysUser);
        LoginUser sysUserVo = new LoginUser();
        sysUserVo.setSysUser(sysUser);
        sysUserVo.setRoles(roles);
        sysUserVo.setPermissions(permissions);
        return R.ok(sysUserVo);
    }

//    /**
//     * 注册用户信息
//     */
//    @InnerAuth
//    @PostMapping("/register")
//    public R<Boolean> register(@RequestBody SysUser sysUser) {
//        String username = sysUser.getUserName();
//        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
//            return R.fail("当前系统没有开启注册功能！");
//        }
//        if (!userService.checkUserNameUnique(sysUser)) {
//            return R.fail("保存用户'" + username + "'失败，注册账号已存在");
//        }
//        return R.ok(userService.registerUser(sysUser));
//    }

//    /**
//     * 记录用户登录IP地址和登录时间
//     */
//    @InnerAuth
//    @PutMapping("/recordlogin")
//    public R<Boolean> recordlogin(@RequestBody SysUser sysUser) {
//        return R.ok(userService.updateUserProfile(sysUser));
//    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser sysUser = new SysUser();
        sysUser.setUserId(1L);
        sysUser.setUserName("admin");
        sysUser.setDeptId(103L);
        sysUser.setNickName("若依");
        sysUser.setEmail("ry@163.com");
        sysUser.setPhonenumber("15888888888");
        sysUser.setSex("1");
        sysUser.setPassword("$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2");
        sysUser.setDelFlag("0");
        sysUser.setRemark("管理员");
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(sysUser);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(sysUser);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", sysUser);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    private SysUser getSysUser(LoginUser loginUser) {
        return loginUser.getSysUser();
    }

//    /**
//     * 根据用户编号获取详细信息
//     */
//    @RequiresPermissions("system:user:query")
//    @GetMapping(value = {"/", "/{userId}"})
//    public AjaxResult getInfo(@PathVariable(value = "userId", required = false) Long userId) {
//        AjaxResult ajax = AjaxResult.success();
//        if (StringUtils.isNotNull(userId)) {
//            userService.checkUserDataScope(userId);
//            SysUser sysUser = userService.selectUserById(userId);
//            ajax.put(AjaxResult.DATA_TAG, sysUser);
//            ajax.put("postIds", postService.selectPostListByUserId(userId));
//            ajax.put("roleIds", sysUser.getRoles().stream().map(SysRole::getRoleId).collect(Collectors.toList()));
//        }
//        List<SysRole> roles = roleService.selectRoleAll();
//        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
//        ajax.put("posts", postService.selectPostAll());
//        return ajax;
//    }
//
//    /**
//     * 新增用户
//     */
//    @RequiresPermissions("system:user:add")
//    @Log(title = "用户管理", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@Validated @RequestBody SysUser user) {
//        deptService.checkDeptDataScope(user.getDeptId());
//        roleService.checkRoleDataScope(user.getRoleIds());
//        if (!userService.checkUserNameUnique(user)) {
//            return error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
//        } else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user)) {
//            return error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
//        } else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user)) {
//            return error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
//        }
//        user.setCreateBy(SecurityUtils.getUsername());
//        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
//        return toAjax(userService.insertUser(user));
//    }

//    /**
//     * 修改用户
//     */
//    @RequiresPermissions("system:user:edit")
//    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@Validated @RequestBody SysUser user) {
//        userService.checkUserAllowed(user);
//        userService.checkUserDataScope(user.getUserId());
//        deptService.checkDeptDataScope(user.getDeptId());
//        roleService.checkRoleDataScope(user.getRoleIds());
//        if (!userService.checkUserNameUnique(user)) {
//            return error("修改用户'" + user.getUserName() + "'失败，登录账号已存在");
//        } else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user)) {
//            return error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
//        } else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user)) {
//            return error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
//        }
//        user.setUpdateBy(SecurityUtils.getUsername());
//        return toAjax(userService.updateUser(user));
//    }
//
////    /**
////     * 删除用户
////     */
////    @RequiresPermissions("system:user:remove")
////    @Log(title = "用户管理", businessType = BusinessType.DELETE)
////    @DeleteMapping("/{userIds}")
////    public AjaxResult remove(@PathVariable Long[] userIds) {
////        if (ArrayUtils.contains(userIds, SecurityUtils.getUserId())) {
////            return error("当前用户不能删除");
////        }
////        return toAjax(userService.deleteUserByIds(userIds));
////    }

//    /**
//     * 重置密码
//     */
//    @RequiresPermissions("system:user:edit")
//    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
//    @PutMapping("/resetPwd")
//    public AjaxResult resetPwd(@RequestBody SysUser user) {
//        userService.checkUserAllowed(user);
//        userService.checkUserDataScope(user.getUserId());
//        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
//        user.setUpdateBy(SecurityUtils.getUsername());
//        return toAjax(userService.resetPwd(user));
//    }
//
////    /**
////     * 状态修改
////     */
////    @RequiresPermissions("system:user:edit")
////    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
////    @PutMapping("/changeStatus")
////    public AjaxResult changeStatus(@RequestBody SysUser user) {
////        userService.checkUserAllowed(user);
////        userService.checkUserDataScope(user.getUserId());
////        user.setUpdateBy(SecurityUtils.getUsername());
////        return toAjax(userService.updateUserStatus(user));
////    }
////
//////    /**
//////     * 根据用户编号获取授权角色
//////     */
//////    @RequiresPermissions("system:user:query")
//////    @GetMapping("/authRole/{userId}")
//////    public AjaxResult authRole(@PathVariable("userId") Long userId) {
//////        AjaxResult ajax = AjaxResult.success();
//////        SysUser user = userService.selectUserById(userId);
//////        List<SysRole> roles = roleService.selectRolesByUserId(userId);
//////        ajax.put("user", user);
//////        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
//////        return ajax;
//////    }
//////
////////    /**
////////     * 用户授权角色
////////     */
////////    @RequiresPermissions("system:user:edit")
////////    @Log(title = "用户管理", businessType = BusinessType.GRANT)
////////    @PutMapping("/authRole")
////////    public AjaxResult insertAuthRole(Long userId, Long[] roleIds) {
////////        userService.checkUserDataScope(userId);
////////        roleService.checkRoleDataScope(roleIds);
////////        userService.insertUserAuth(userId, roleIds);
////////        return success();
////////    }

//    /**
//     * 获取部门树列表
//     */
//    @RequiresPermissions("system:user:list")
//    @GetMapping("/deptTree")
//    public AjaxResult deptTree(SysDept dept) {
//        return success(deptService.selectDeptTreeList(dept));
//    }
}
