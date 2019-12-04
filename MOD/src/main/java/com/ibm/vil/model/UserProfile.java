package com.ibm.vil.model;

import java.util.Arrays;

public class UserProfile {

	private long id;

	private String userName;

	private String password;

	private String address;

	private String userRole;

	private String email;

	private String phoneNo;

	private String[] time_selectedItems;

	private String[] tech_selectedItems;

	private int experience;
	
	private int average_rating;
	
	private int noOfTrainingsDlvr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String[] getTime_selectedItems() {
		return time_selectedItems;
	}

	public void setTime_selectedItems(String[] time_selectedItems) {
		this.time_selectedItems = time_selectedItems;
	}

	public String[] getTech_selectedItems() {
		return tech_selectedItems;
	}

	public void setTech_selectedItems(String[] tech_selectedItems) {
		this.tech_selectedItems = tech_selectedItems;
	}

	public int getAverage_rating() {
		return average_rating;
	}

	public void setAverage_rating(int average_rating) {
		this.average_rating = average_rating;
	}

	public int getNoOfTrainingsDlvr() {
		return noOfTrainingsDlvr;
	}

	public void setNoOfTrainingsDlvr(int noOfTrainingsDlvr) {
		this.noOfTrainingsDlvr = noOfTrainingsDlvr;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", userRole=" + userRole + ", email=" + email + ", phoneNo=" + phoneNo + ", time_selectedItems="
				+ Arrays.toString(time_selectedItems) + ", tech_selectedItems=" + Arrays.toString(tech_selectedItems)
				+ ", experience=" + experience + ", average_rating=" + average_rating + ", noOfTrainingsDlvr="
				+ noOfTrainingsDlvr + "]";
	}

	


}
