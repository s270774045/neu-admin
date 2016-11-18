package com.noisyle.crowbar.vo;

import java.util.List;

import com.noisyle.crowbar.core.base.BaseModel;
import com.noisyle.crowbar.model.Ability;
import com.noisyle.crowbar.model.Knowledge;

public class EmployeeVO extends BaseModel {

	private static final long serialVersionUID = -2040051458005917717L;

	private Long avatarId;
	private String employeeName;
	private String sapCode;
	private String dateOfBirth;
	private Integer sexual;
	private String sexual_text;
	private Integer score;
	private Integer rating;
	private String rating_text;
	private List<Knowledge> knowledges;
	private List<Ability> abilitys;
	//部门
	private String department;
	//岗位
	private String post;

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
	public String getSexual_text() {
		return sexual_text;
	}
	public void setSexual_text(String sexual_text) {
		this.sexual_text = sexual_text;
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
	public String getRating_text() {
		return rating_text;
	}
	public void setRating_text(String rating_text) {
		this.rating_text = rating_text;
	}
	public List<Knowledge> getKnowledges() {
		return knowledges;
	}
	public void setKnowledges(List<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}
	public List<Ability> getAbilitys() {
		return abilitys;
	}
	public void setAbilitys(List<Ability> abilitys) {
		this.abilitys = abilitys;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
}
