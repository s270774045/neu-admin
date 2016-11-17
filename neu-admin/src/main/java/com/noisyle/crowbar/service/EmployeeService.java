package com.noisyle.crowbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noisyle.crowbar.constant.AdminConstant;
import com.noisyle.crowbar.core.datatables.FormatedPage;
import com.noisyle.crowbar.core.datatables.IFormatter;
import com.noisyle.crowbar.core.datatables.Page;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.core.vo.BeanUtils;
import com.noisyle.crowbar.model.Employee;
import com.noisyle.crowbar.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee get(Long id) {
    	return employeeRepository.get(id);
    }
    
    public void save(Employee employee) {
		if (employee.getId() == null) {
			employee.setStatus(AdminConstant.Status.SAVE.getId());
		} else {
			Employee employee_db = employeeRepository.get(employee.getId());
			BeanUtils.copyProperties(employee, employee_db);
			employee = employee_db;
		}
    	employeeRepository.save(employee);
    }
    
    public void delete(Long id) {
    	Employee employee = employeeRepository.get(id);
    	employee.setStatus(AdminConstant.Status.INVALID.getId());
    	employeeRepository.save(employee);
    }
    
    public FormatedPage getFormatedPage(PageParam pageParam) {
    	pageParam.setColumnFormatter("sexual", new IFormatter() {
			@Override
			public Object format(Object value) {
				return AdminConstant.Sexual.valueOf((Integer)value).getText();
			}
		});
    	pageParam.setColumnFormatter("rating", new IFormatter() {
    		@Override
    		public Object format(Object value) {
    			return AdminConstant.Rating.valueOf((Integer)value).getText();
    		}
    	});
    	return employeeRepository.getFormatedPage(pageParam);
    }
    
    public Page<Employee> getPage(Integer page) {
    	return employeeRepository.getPage(page);
    }
    
}
