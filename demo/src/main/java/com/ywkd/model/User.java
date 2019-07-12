package com.ywkd.model;

public class User {
	private static final long serialVersionUID = -6056125703075132981L;
    private Integer id;
    private String account;
    private String password;
    private String username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", username=" + username + "]";
	}
    
    

}
