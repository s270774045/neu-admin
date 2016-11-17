package com.noisyle.crowbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.noisyle.crowbar.model.DbFile;
import com.noisyle.crowbar.repository.DbFileRepository;

@Service
@Transactional
public class DbFileService {

    @Autowired
    private DbFileRepository dbFileRepository;
    
	public DbFile uploadAvatar(MultipartFile file, Integer catalog) {
		return dbFileRepository.save(file, catalog);
	}
	
	public DbFile getAvatar(Long id) {
		return dbFileRepository.get(id);
	}
}
