package com.noisyle.crowbar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noisyle.crowbar.constant.AdminConstant;
import com.noisyle.crowbar.core.base.BaseController;
import com.noisyle.crowbar.core.vo.BeanUtils;
import com.noisyle.crowbar.model.Ability;
import com.noisyle.crowbar.model.Employee;
import com.noisyle.crowbar.model.Knowledge;
import com.noisyle.crowbar.service.AbilityService;
import com.noisyle.crowbar.service.EmployeeService;
import com.noisyle.crowbar.service.KnowledgeService;
import com.noisyle.crowbar.vo.EmployeeVO;

@Controller
public class IndexController extends BaseController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private KnowledgeService knowledgeService;
	@Autowired
	private AbilityService abilityService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index/index";
	}

	@RequestMapping(value = "/profile/list.html", method = RequestMethod.GET)
	public String list() {
		return "index/list";
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	@ResponseBody
	public Object queryProfiles(@RequestParam(required = false, defaultValue = "1") Integer page) {
		return employeeService.getPage(page);
	}

	@RequestMapping(value = "/profile/detail.html", method = RequestMethod.GET)
	public String detail() {
		return "index/detail";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	@ResponseBody
	public Object queryProfileById(@RequestParam Long id) {
		Employee entity = employeeService.get(id);
		List<Knowledge> knowledges = knowledgeService.findByEmployeeId(id);
		List<Ability> abilitys = abilityService.findByEmployeeId(id);
		EmployeeVO vo = new EmployeeVO();
		BeanUtils.copyProperties(entity, vo);
		vo.setSexual_text(AdminConstant.Sexual.valueOf(entity.getSexual()).getText());
		vo.setRating_text(AdminConstant.Rating.valueOf(entity.getRating()).getText());
		vo.setKnowledges(knowledges);
		vo.setAbilitys(abilitys);
		return vo;
	}

}
