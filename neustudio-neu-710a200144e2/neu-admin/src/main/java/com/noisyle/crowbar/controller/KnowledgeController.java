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
import com.noisyle.crowbar.model.Knowledge;
import com.noisyle.crowbar.service.KnowledgeService;

@Controller
@RequestMapping("/admin/employee/knowledge")
public class KnowledgeController extends BaseController {
	@Autowired
	private KnowledgeService knowledgeService;

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String employeeList() {
		return "admin/employee/knowledge/employeeList";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "admin/employee/knowledge/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@RequestBody PageParam pageParam, Long employeeId) {
		return knowledgeService.getFormatedPage(pageParam, employeeId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "admin/employee/knowledge/add";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, @RequestParam Long id) {
		model.addAttribute("entity", knowledgeService.get(id));
		return "admin/employee/knowledge/view";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(Knowledge knowledge) {
		knowledgeService.save(knowledge);
		return ResponseData.buildSuccessResponse(knowledge, "保存成功");
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(Knowledge knowledge) {
		knowledgeService.delete(knowledge.getId());
		return ResponseData.buildSuccessResponse(knowledge.getId(), "删除成功");
	}

}
