package com.noisyle.crowbar.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.noisyle.crowbar.core.base.BaseController;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.core.vo.ResponseData;
import com.noisyle.crowbar.model.DbFile;
import com.noisyle.crowbar.model.Employee;
import com.noisyle.crowbar.service.DbFileService;
import com.noisyle.crowbar.service.EmployeeService;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController extends BaseController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DbFileService dbFileService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "admin/employee/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@RequestBody PageParam pageParam) {
		return employeeService.getFormatedPage(pageParam);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "admin/employee/add";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, @RequestParam Long id) {
		model.addAttribute("entity", employeeService.get(id));
		return "admin/employee/view";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(Employee employee) {
		employeeService.save(employee);
		return ResponseData.buildSuccessResponse(employee, "保存成功");
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public Object del(Employee employee) {
		employeeService.delete(employee.getId());
		return ResponseData.buildSuccessResponse(employee.getId(), "删除成功");
	}
	
	@RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
	@ResponseBody
	public Object uploadAvatar(MultipartFile file) {
		DbFile f = dbFileService.uploadAvatar(file, 1);
		return ResponseData.buildSuccessResponse(f.getId().toString(), "上传成功");
	}

	@RequestMapping(value = "/avatar/{id}", method = RequestMethod.GET)
	public void getAvatar(@PathVariable Long id, HttpServletResponse response) {
		DbFile file = dbFileService.getAvatar(id);
		if (file != null) {
			try {
				response.setContentType(file.getContent_type());
				response.setContentLength((new Long(file.getContent().length()).intValue()));
				IOUtils.copy(file.getContent().getBinaryStream(), response.getOutputStream());
			} catch (Exception e) {
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
		} else {
			response.setStatus(HttpStatus.NOT_FOUND.value());
		}
	}

}
