package com.noisyle.crowbar.repository;

import org.springframework.stereotype.Repository;

import com.noisyle.crowbar.core.base.BaseHibernateRepository;
import com.noisyle.crowbar.model.Admin;

@Repository
public class AdminRepository extends BaseHibernateRepository<Admin, Long> {

	public Admin getUserByLoginname(String loginname) {
		Admin user = findUniqueBy("loginname", loginname);
        return user;
    }

}