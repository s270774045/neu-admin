package com.noisyle.crowbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noisyle.crowbar.constant.AdminConstant;
import com.noisyle.crowbar.core.datatables.FormatedPage;
import com.noisyle.crowbar.core.datatables.IFormatter;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.core.vo.BeanUtils;
import com.noisyle.crowbar.model.Ability;
import com.noisyle.crowbar.repository.AbilityRepository;

@Service
@Transactional
public class AbilityService {

    @Autowired
    private AbilityRepository abilityRepository;
    
    public Ability get(Long id) {
    	return abilityRepository.get(id);
    }
    
    public void save(Ability entity) {
		if (entity.getId() == null) {
			entity.setStatus(AdminConstant.Status.SAVE.getId());
		} else {
			Ability entity_db = abilityRepository.get(entity.getId());
			BeanUtils.copyProperties(entity, entity_db);
			entity = entity_db;
		}
    	abilityRepository.save(entity);
    }
    
    public void delete(Long id) {
    	Ability entity = abilityRepository.get(id);
    	entity.setStatus(AdminConstant.Status.INVALID.getId());
    	abilityRepository.save(entity);
    }
    
    public FormatedPage getFormatedPage(PageParam pageParam, Long employeeId) {
    	pageParam.setColumnFormatter("catalog", new IFormatter() {
    		@Override
    		public Object format(Object value) {
    			return AdminConstant.TrainingCatalog.valueOf((Integer)value).getText();
    		}
    	});
    	pageParam.setColumnFormatter("mode", new IFormatter() {
    		@Override
    		public Object format(Object value) {
    			return AdminConstant.TrainingMode.valueOf((Integer)value).getText();
    		}
    	});
    	pageParam.setColumnFormatter("issue", new IFormatter() {
    		@Override
    		public Object format(Object value) {
    			return AdminConstant.YesOrNo.valueOf((Integer)value).getText();
    		}
    	});
    	return abilityRepository.getFormatedPage(pageParam, employeeId);
    }
    
    public List<Ability> findByEmployeeId(Long employeeId) {
    	return abilityRepository.findByEmployeeId(employeeId);
    }
    
}
