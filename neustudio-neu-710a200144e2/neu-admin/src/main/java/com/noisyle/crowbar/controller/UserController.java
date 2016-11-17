package com.noisyle.crowbar.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noisyle.crowbar.auth.MongoDBUserRealm;
import com.noisyle.crowbar.core.base.BaseController;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.core.vo.ResponseData;
import com.noisyle.crowbar.model.Admin;
import com.noisyle.crowbar.service.AdminService;

@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {
	@Autowired
	private AdminService adminService;

	// 注册用户管理
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "admin/user/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object getUserByPage(@RequestBody PageParam pageParam) {
		return adminService.getFormatedPage(pageParam);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		return "admin/user/add";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, @RequestParam Long id) {
		model.addAttribute("user", adminService.get(id));
		return "admin/user/view";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object saveUser(Admin user) {
		adminService.save(user);
		if (user.getId() != null) {
			RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
			for (Realm realm : securityManager.getRealms()) {
				if (realm instanceof MongoDBUserRealm) {
					((MongoDBUserRealm) realm).clearCachedAuthorizationInfo(user);
				}
			}
		}
		return ResponseData.buildSuccessResponse(user, "保存成功");
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object delUser(Admin user) {
		adminService.delete(user.getId());
		return ResponseData.buildSuccessResponse(user.getId(), "删除成功");
	}

}
