package com.noisyle.crowbar.service;

import org.apache.shiro.SecurityUtils;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noisyle.crowbar.constant.AdminConstant;
import com.noisyle.crowbar.core.base.IUser;
import com.noisyle.crowbar.core.datatables.FormatedPage;
import com.noisyle.crowbar.core.datatables.PageParam;
import com.noisyle.crowbar.core.util.CryptoUtils;
import com.noisyle.crowbar.core.vo.UserContext;
import com.noisyle.crowbar.model.Admin;
import com.noisyle.crowbar.repository.AdminRepository;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    public Admin get(Long id) {
    	return adminRepository.get(id);
    }
    
    public void save(Admin user) {
		if (user.getId() == null) {
			user.setRole(AdminConstant.Role.ADMIN.toString());
			user.setPassword(CryptoUtils.md5("123456").toUpperCase());
		} else {
			Admin dbUser = adminRepository.get(user.getId());
			user.setRole(dbUser.getRole());
			user.setPassword(dbUser.getPassword());
		}
    	adminRepository.save(user);
    }
    
    public void delete(Long id) {
    	adminRepository.delete(id);
    }
    
    public FormatedPage getFormatedPage(PageParam pageParam) {
    	return adminRepository.getFormatedPage(pageParam, Restrictions.not(Restrictions.like("role", "%SUPERADMIN%")));
    }
    
	public Admin getAdminByLoginName(String loginname) {
		return adminRepository.getUserByLoginname(loginname);
	}
	
	public void initUserContext(IUser user) {
    	UserContext uctx = new UserContext(user);
    	uctx.setLoginTime(LocalDate.now().toDate());
    	SecurityUtils.getSubject().getSession().setAttribute(AdminConstant.SESSION_KEY_USER_CONTEXT, uctx);
	}
	
}
