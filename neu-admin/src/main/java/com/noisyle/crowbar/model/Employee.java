package com.noisyle.crowbar.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.noisyle.crowbar.core.base.BaseModel;

@Entity
@Table(name="neu_employee")
public class Employee extends BaseModel {

	private static final long serialVersionUID = 8476856854052345938L;
	
	private Long avatarId;
	private String employeeName;
	private String sapCode;
	private String dateOfBirth;
	private Integer sexual;
	private Integer score;
	private Integer rating;
	private Integer status;

	public Long getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(Long avatarId) {
		this.avatarId = avatarId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSapCode() {
		return sapCode;
	}
	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getSexual() {
		return sexual;
	}
	public void setSexual(Integer sexual) {
		this.sexual = sexual;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
