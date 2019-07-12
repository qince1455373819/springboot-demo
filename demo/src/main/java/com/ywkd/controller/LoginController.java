package com.ywkd.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ywkd.common.ServerResponseEnum;
import com.ywkd.utils.JsonUtils;
import com.ywkd.utils.ServerResponseVO;

@RestController
@RequestMapping("")
public class LoginController {
	 @PostMapping("/login")
	    public String login(@RequestParam(value = "account") String account,
	                                  @RequestParam(value = "password") String password) {
	        Subject userSubject = SecurityUtils.getSubject();
	        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
	        try {
	            // 登录验证
	            userSubject.login(token);
	            return JsonUtils.objectToJson(ServerResponseEnum.SUCCESS);
	        } catch (UnknownAccountException e) {
	            return JsonUtils.objectToJson(ServerResponseEnum.ACCOUNT_NOT_EXIST);
	        } catch (DisabledAccountException e) {
	            return JsonUtils.objectToJson(ServerResponseEnum.ACCOUNT_IS_DISABLED);
	        } catch (IncorrectCredentialsException e) {
	            return JsonUtils.objectToJson(ServerResponseEnum.INCORRECT_CREDENTIALS);
	        } catch (Throwable e) {
	            e.printStackTrace();
	            return JsonUtils.objectToJson(ServerResponseEnum.ERROR);
	        }
	    }

	    @GetMapping("/login")
	    public String login() {
	        return JsonUtils.objectToJson(ServerResponseEnum.NOT_LOGIN_IN);
	    }

	    @GetMapping("/auth")
	    public String auth() {
	        return "已成功登录";
	    }

	    @GetMapping("/role")
	    @RequiresRoles("vip")
	    public String role() {
	        return "测试Vip角色";
	    }

	    @GetMapping("/permission")
	    @RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
	    public String permission() {
	        return "测试Add和Update权限";
	    }
}
