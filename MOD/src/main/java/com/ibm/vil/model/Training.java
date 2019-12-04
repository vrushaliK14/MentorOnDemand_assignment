package com.ibm.vil.model;

import java.util.Date;

public class Training {
	
	String technology;
	String mentor;
	Date startDate;
	Date endDate;
	String startTime;
	String endtime;
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "Training [technology=" + technology + ", mentor=" + mentor + ", startDate=" + startDate + ", endDate="
				+ endDate + ", startTime=" + startTime + ", endtime=" + endtime + "]";
	}	
	
}	
