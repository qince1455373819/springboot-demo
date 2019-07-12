package com.ywkd.model;

public class Role {
	private static final long serialVersionUID = -1767327914553823741L;

    private Integer id;

    private String role;

    private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", desc=" + desc + "]";
	}
    
    
}
