package com.security.tedu.security;

import com.security.tedu.entity.SysRole;
import com.security.tedu.entity.SysUser;
import com.security.tedu.entity.SysUserRole;
import com.security.tedu.service.SysRoleService;
import com.security.tedu.service.SysUserRoleService;
import com.security.tedu.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = userService.selectByName(username);
        System.out.println("我进来了"+user.getName());
        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
        System.out.println("我进来了"+userRoles);
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        // 返回UserDetails实现类
        return new User(user.getName(), user.getPassword(), authorities);
    }

}
