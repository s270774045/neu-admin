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
import com.noisyle.crowbar.model.Knowledge;
import com.noisyle.crowbar.repository.KnowledgeRepository;

@Service
@Transactional
public class KnowledgeService {

    @Autowired
    private KnowledgeRepository knowledgeRepository;
    
    public Knowledge get(Long id) {
    	return knowledgeRepository.get(id);
    }
    
    public void save(Knowledge entity) {
		if (entity.getId() == null) {
			entity.setStatus(AdminConstant.Status.SAVE.getId());
		} else {
			Knowledge entity_db = knowledgeRepository.get(entity.getId());
			BeanUtils.copyProperties(entity, entity_db);
			entity = entity_db;
		}
    	knowledgeRepository.save(entity);
    }
    
    public void delete(Long id) {
    	Knowledge entity = knowledgeRepository.get(id);
    	entity.setStatus(AdminConstant.Status.INVALID.getId());
    	knowledgeRepository.save(entity);
    }
    
    public FormatedPage getFormatedPage(PageParam pageParam, Long employeeId) {
    	pageParam.setColumnFormatter("rating", new IFormatter() {
    		@Override
    		public Object format(Object value) {
    			return AdminConstant.Rating.valueOf((Integer)value).getText();
    		}
    	});
    	return knowledgeRepository.getFormatedPage(pageParam, employeeId);
    }
    
    public List<Knowledge> findByEmployeeId(Long employeeId) {
    	return knowledgeRepository.findByEmployeeId(employeeId);
    }
    
}
