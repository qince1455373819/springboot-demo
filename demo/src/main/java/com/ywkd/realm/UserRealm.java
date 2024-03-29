package com.ywkd.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ywkd.model.Role;
import com.ywkd.model.User;
import com.ywkd.service.PermissionService;
import com.ywkd.service.RoleService;
import com.ywkd.service.UserService;

public class UserRealm extends AuthorizingRealm {
	 @Autowired
	    private UserService userService;

	    @Autowired
	    private RoleService roleService;

	    @Autowired
	    private PermissionService permissionService;

	 // 用户授权
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
	        User user = (User) principalCollection.getPrimaryPrincipal();
	        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	        List<Role> roleList = roleService.findRoleByUserId(user.getId());
	        Set<String> roleSet = new HashSet<>();
	        List<Integer> roleIds = new ArrayList<>();
	        for (Role role : roleList) {
	            roleSet.add(role.getRole());
	            roleIds.add(role.getId());
	        }
	        // 放入角色信息
	        authorizationInfo.setRoles(roleSet);
	        // 放入权限信息
	        List<String> permissionList = permissionService.findByRoleId(roleIds);
	        authorizationInfo.setStringPermissions(new HashSet<>(permissionList));

	        return authorizationInfo;
	    }

	    // 用户认证
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
	        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
	        User user = userService.findByAccount(token.getUsername());
	        if (user == null) {
	            return null;
	        }
	        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	    }

}
