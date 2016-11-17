package com.noisyle.crowbar.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.noisyle.crowbar.core.base.BaseModel;

@Entity
@Table(name="neu_file")
public class DbFile extends BaseModel {

	private static final long serialVersionUID = 8998751049220493159L;
	
	private Integer catalog; //附件类别. 1:员工照片
	private String filename;
	private Blob content;
	private String content_type;
	
	public Integer getCatalog() {
		return catalog;
	}
	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Blob getContent() {
		return content;
	}
	public void setContent(Blob content) {
		this.content = content;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	
}
