package com.noisyle.crowbar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.noisyle.crowbar.core.base.BaseModel;
import com.noisyle.crowbar.core.base.IUser;

@Entity
@Table(name="neu_admin")
public class Admin extends BaseModel implements IUser {

	private static final long serialVersionUID = 3975453762847879353L;
	
	private String loginname;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String role;
	private String avatarId;
	private Date createtime;
	
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(String avatarId) {
		this.avatarId = avatarId;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
