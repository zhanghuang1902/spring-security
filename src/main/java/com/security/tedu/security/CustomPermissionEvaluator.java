package com.security.tedu.security;

import com.security.tedu.entity.SysPermission;
import com.security.tedu.service.SysPermissionService;
import com.security.tedu.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class CustomPermissionEvaluator  implements PermissionEvaluator {

    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private SysRoleService roleService;

    /**
     * 在 hasPermission() 方法中，参数 1 代表用户的权限身份，参数 2 参数 3 分别和 @PreAuthorize("hasPermission('/admin','r')") 中的参数对应，即访问 url 和权限。
     * @param authentication
     * @param targetUrl
     * @param targetPermission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        Object obj=authentication.getAuthorities();
        // 获得loadUserByUsername()方法的结果authentication = {UsernamePasswordAuthenticationToken@8559} "UsernamePasswordAuthenticationToken [Principal=admin, Credentials=[PROTECTED], Authenticated=true, Details=CustomWebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=54E4F8DA0828F543AB4EB0B74B648F6F]; VerifyCode: 3by1, Granted Authorities=[ROLE_ADMIN]]"
        //User user = (User)authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        //Collection<GrantedAuthority> authorities = user.getAuthorities();
        // 遍历用户所有角色
        for(GrantedAuthority authority : authentication.getAuthorities()) {
            String roleName = authority.getAuthority();
            Integer roleId = roleService.selectByName(roleName).getId();
            // 得到角色所有的权限
            List<SysPermission> permissionList = permissionService.listByRoleId(roleId);
            // 遍历permissionList
            for(SysPermission sysPermission : permissionList) {
                // 获取权限集
                List permissions = sysPermission.getPermissions();
                // 如果访问的Url和权限用户符合的话，返回true
                if(targetUrl.equals(sysPermission.getUrl())
                        && permissions.contains(targetPermission)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
