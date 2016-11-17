package com.noisyle.crowbar.repository;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.noisyle.crowbar.core.base.BaseHibernateRepository;
import com.noisyle.crowbar.core.datatables.FormatedPage;
import com.noisyle.crowbar.core.datatables.Page;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.model.Employee;

@Repository
public class EmployeeRepository extends BaseHibernateRepository<Employee, Long> {
	public FormatedPage getFormatedPage(PageParam pageParam) {
		List<Criterion> criterions = new LinkedList<Criterion>();
		criterions.add(Restrictions.gt("status", 0));
		return getFormatedPage(pageParam, criterions.toArray(new Criterion[0]));
	}
	
	public Page<Employee> getPage(Integer page) {
		PageParam pageParam = new PageParam();
		pageParam.setStart((page-1)*pageParam.getLength());
		List<Criterion> criterions = new LinkedList<Criterion>();
		criterions.add(Restrictions.gt("status", 0));
		return getPage(pageParam, criterions.toArray(new Criterion[0]));
	}
}