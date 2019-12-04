package com.ibm.vil.data.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name="USER")*/
public class User {/*

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	private long id;
	
	/*@Column(name="NAME")*/
	private String userName;
	
	/*@Column(name="PASSWORD")*/
	private String password;
	
	/*@Column(name="ADDRESS")*/
	private String address;
	
	/*@Column(name="ROLE")*/
	private String userRole;
	
	/*@Column(name="EMAIL")*/
	private String email;
	
	/*@Column(name="PHONE_NO")*/
	private String phoneNo;
	
	/*@Column(name="BATCH_TIMES")*/
	private String time_selectedItems;
	
	/*@Column(name="TECHNOLOGIES")*/
	private String tech_selectedItems;
	
	/*@Column(name="EXPERIENCE")*/
	private int experience;
	
	/*@Column(name="AVERAGE_RATING")*/
	private int average_rating;
	
	/*@Column(name="  NO_OF_TRAININGS_DLVR")*/
	private int no_of_trainings_dlvr;
	
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
	public String getTime_selectedItems() {
		return time_selectedItems;
	}
	public void setTime_selectedItems(String time_selectedItems) {
		this.time_selectedItems = time_selectedItems;
	}
	public String getTech_selectedItems() {
		return tech_selectedItems;
	}
	public void setTech_selectedItems(String tech_selectedItems) {
		this.tech_selectedItems = tech_selectedItems;
	}

	public int getNo_of_trainings_dlvr() {
		return no_of_trainings_dlvr;
	}
	public void setNo_of_trainings_dlvr(int no_of_trainings_dlvr) {
		this.no_of_trainings_dlvr = no_of_trainings_dlvr;
	}
	public int getAverage_rating() {
		return average_rating;
	}
	public void setAverage_rating(int average_rating) {
		this.average_rating = average_rating;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", userRole=" + userRole + ", email=" + email + ", phoneNo=" + phoneNo + ", time_selectedItems="
				+ time_selectedItems + ", tech_selectedItems=" + tech_selectedItems + ", experience=" + experience
				+ ", average_rating=" + average_rating + ", no_of_trainings_dlvr=" + no_of_trainings_dlvr + "]";
	}

	
	
}
