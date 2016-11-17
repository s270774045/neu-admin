package com.noisyle.crowbar.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.noisyle.crowbar.core.base.BaseModel;

@Entity
@Table(name="neu_knowledge")
public class Knowledge extends BaseModel {

	private static final long serialVersionUID = 2402537241866799092L;
	
	private Long employeeId;
	private String date;
	private Integer safe1;
	private Integer theory1;
	private Integer practice1;
	private Integer safe2;
	private Integer theory2;
	private Integer practice2;
	private Integer theory3;
	private Integer safe3;
	private Integer score;
	private Integer rating;
	private Integer winter;
	private Integer risk;
	private Integer standard;
	private Integer flood;
	private Integer status;

	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getSafe1() {
		return safe1;
	}
	public void setSafe1(Integer safe1) {
		this.safe1 = safe1;
	}
	public Integer getTheory1() {
		return theory1;
	}
	public void setTheory1(Integer theory1) {
		this.theory1 = theory1;
	}
	public Integer getPractice1() {
		return practice1;
	}
	public void setPractice1(Integer practice1) {
		this.practice1 = practice1;
	}
	public Integer getSafe2() {
		return safe2;
	}
	public void setSafe2(Integer safe2) {
		this.safe2 = safe2;
	}
	public Integer getTheory2() {
		return theory2;
	}
	public void setTheory2(Integer theory2) {
		this.theory2 = theory2;
	}
	public Integer getPractice2() {
		return practice2;
	}
	public void setPractice2(Integer practice2) {
		this.practice2 = practice2;
	}
	public Integer getTheory3() {
		return theory3;
	}
	public void setTheory3(Integer theory3) {
		this.theory3 = theory3;
	}
	public Integer getSafe3() {
		return safe3;
	}
	public void setSafe3(Integer safe3) {
		this.safe3 = safe3;
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
	public Integer getWinter() {
		return winter;
	}
	public void setWinter(Integer winter) {
		this.winter = winter;
	}
	public Integer getRisk() {
		return risk;
	}
	public void setRisk(Integer risk) {
		this.risk = risk;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	public Integer getFlood() {
		return flood;
	}
	public void setFlood(Integer flood) {
		this.flood = flood;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
