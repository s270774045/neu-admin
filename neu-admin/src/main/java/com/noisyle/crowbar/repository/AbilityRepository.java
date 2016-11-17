package com.noisyle.crowbar.repository;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.noisyle.crowbar.core.base.BaseHibernateRepository;
import com.noisyle.crowbar.core.datatables.FormatedPage;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.model.Ability;

@Repository
public class AbilityRepository extends BaseHibernateRepository<Ability, Long> {
	public FormatedPage getFormatedPage(PageParam pageParam, Long employeeId) {
		List<Criterion> criterions = new LinkedList<Criterion>();
		criterions.add(Restrictions.eq("employeeId", employeeId));
		criterions.add(Restrictions.gt("status", 0));
		return getFormatedPage(pageParam, criterions.toArray(new Criterion[0]));
	}
	
	public List<Ability> findByEmployeeId(Long employeeId) {
		List<Criterion> criterions = new LinkedList<Criterion>();
		criterions.add(Restrictions.eq("employeeId", employeeId));
		criterions.add(Restrictions.gt("status", 0));
		return this.find(criterions.toArray(new Criterion[0]));
	}
}