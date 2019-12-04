package com.ibm.vil.data.model;

public class Technology {
	private String techId;
	private String techName;
	public String getTechId() {
		return techId;
	}
	public void setTechId(String techId) {
		this.techId = techId;
	}
	public String getTech_name() {
		return techName;
	}
	public void setTech_name(String techName) {
		this.techName = techName;
	}
	@Override
	public String toString() {
		return "Technology [techId=" + techId + ", tech_name=" + techName + "]";
	}
	
}
