package com.ibm.vil.model;

import java.util.Date;

public class SearchTraining {
	
	private int id;
	private String technology;
	private String mentorName;
	private Date startDate;
	private Date endDate;
	private String batchTime;
	private int experience;
	private String email;
	private int payment_status;
	private String status;
	private int trainingFee;
	private String userName;
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getBatchTime() {
		return batchTime;
	}
	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPaymentStatus() {
		return payment_status;
	}
	public void setPaymentStatus(int payment_status) {
		this.payment_status = payment_status;
	}
	public int getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrainingFee() {
		return trainingFee;
	}
	public void setTrainingFee(int trainingFee) {
		this.trainingFee = trainingFee;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "SearchTraining [id=" + id + ", technology=" + technology + ", mentorName=" + mentorName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", batchTime=" + batchTime + ", experience=" + experience
				+ ", email=" + email + ", payment_status=" + payment_status + ", status=" + status + ", trainingFee="
				+ trainingFee + ", userName=" + userName + "]";
	}
	
	
}
