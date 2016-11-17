package com.noisyle.crowbar.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noisyle.crowbar.constant.AdminConstant;
import com.noisyle.crowbar.core.base.BaseController;
import com.noisyle.crowbar.core.exception.GeneralException;
import com.noisyle.crowbar.core.vo.ResponseData;
import com.noisyle.crowbar.model.Admin;
import com.noisyle.crowbar.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest request, @ModelAttribute("user") Admin user,
			@RequestParam(required = false, defaultValue = "false") boolean rememberMe) {
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginname(), user.getPassword());
			token.setRememberMe(rememberMe);
			SecurityUtils.getSubject().login(token);
			return ResponseData.buildSuccessResponse(user);
		} catch (UnknownAccountException e) {
			throw new GeneralException("login.wrongUsername", user.getLoginname());
		} catch (IncorrectCredentialsException e) {
			throw new GeneralException("login.wrongPassword");
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		SecurityUtils.getSubject().getSession().removeAttribute(AdminConstant.SESSION_KEY_USER_CONTEXT);
		SecurityUtils.getSubject().logout();
		return "admin/login";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}

	@RequestMapping(value = "/changePass", method = RequestMethod.GET)
	public String changePass() {
		return "admin/changePass";
	}

	@RequestMapping(value = "/changePass", method = RequestMethod.POST)
	@ResponseBody
	public Object changePass(HttpServletRequest request) {
		String oldPass = request.getParameter("oldPass");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		if (oldPass == null || "".equals(oldPass.trim()) || pass1 == null || "".equals(pass1.trim()) || pass2 == null
				|| "".equals(pass2.trim())) {
			throw new GeneralException("修改密码失败，参数不正确");
		}
		Admin user = adminService.get(getUserContext().getUser().getId());
		if (user == null) {
			throw new GeneralException("修改密码失败，用户不存在");
		}
		if (!user.getPassword().equalsIgnoreCase(oldPass.trim())) {
			throw new GeneralException("修改密码失败，旧密码不正确");
		}
		if (!pass1.trim().equals(pass2.trim())) {
			throw new GeneralException("修改密码失败，两次新密码必须相同");
		}
		user.setPassword(pass1);
		adminService.save(user);
		SecurityUtils.getSubject().getSession().removeAttribute(AdminConstant.SESSION_KEY_USER_CONTEXT);
		SecurityUtils.getSubject().logout();
		return ResponseData.buildSuccessResponse(null, "密码修改成功，请重新登陆");
	}

}
