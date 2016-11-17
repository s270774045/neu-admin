package com.noisyle.crowbar.repository;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.noisyle.crowbar.core.base.BaseHibernateRepository;
import com.noisyle.crowbar.core.exception.GeneralException;
import com.noisyle.crowbar.model.DbFile;

@Repository
public class DbFileRepository extends BaseHibernateRepository<DbFile, Long> {
    
	public DbFile save(MultipartFile file, Integer catalog) {
		try {
			String filename = file.getOriginalFilename();
			String contentType = file.getContentType();
			Blob content = Hibernate.getLobCreator(getSession()).createBlob(file.getInputStream(), file.getSize());
			DbFile f = new DbFile();
			f.setCatalog(catalog);
			f.setFilename(filename);
			f.setContent(content);
			f.setContent_type(contentType);
			save(f);
			return f;
		} catch (IOException e) {
			throw new GeneralException("上传失败", e);
		}
	}
}