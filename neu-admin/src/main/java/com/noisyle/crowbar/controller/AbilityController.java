package com.noisyle.crowbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noisyle.crowbar.core.base.BaseController;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.core.vo.ResponseData;
import com.noisyle.crowbar.model.Ability;
import com.noisyle.crowbar.service.AbilityService;

@Controller
@RequestMapping("/admin/employee/ability")
public class AbilityController extends BaseController {
	@Autowired
	private AbilityService abilityService;

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String employeeList() {
		return "admin/employee/ability/employeeList";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "admin/employee/ability/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@RequestBody PageParam pageParam, Long employeeId) {
		return abilityService.getFormatedPage(pageParam, employeeId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "admin/employee/ability/add";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, @RequestParam Long id) {
		model.addAttribute("entity", abilityService.get(id));
		return "admin/employee/ability/view";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(Ability entity) {
		abilityService.save(entity);
		return ResponseData.buildSuccessResponse(entity, "保存成功");
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(Ability entity) {
		abilityService.delete(entity.getId());
		return ResponseData.buildSuccessResponse(entity.getId(), "删除成功");
	}

}
