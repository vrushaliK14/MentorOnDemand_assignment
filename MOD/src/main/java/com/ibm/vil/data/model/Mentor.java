package com.ibm.vil.data.model;

import java.util.Arrays;

public class Mentor {
	
	private String fullName;
	private String phoneNumber;
	private int mentorId;
	private double avgRating;
	private int experiance; 
	private String [] expertInTechnls;
	private int noOfTrainingsDelivered;
	private String [] trainingBatchTimes;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getExperiance() {
		return experiance;
	}
	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}
	public String[] getExpertInTechnls() {
		return expertInTechnls;
	}
	public void setExpertInTechnls(String[] expertInTechnls) {
		this.expertInTechnls = expertInTechnls;
	}
	
	public int getNoOfTrainingsDelivered() {
		return noOfTrainingsDelivered;
	}
	public void setNoOfTrainingsDelivered(int noOfTrainingsDelivered) {
		this.noOfTrainingsDelivered = noOfTrainingsDelivered;
	}
	public String[] getTrainingBatchTimes() {
		return trainingBatchTimes;
	}
	public void setTrainingBatchTimes(String[] trainingBatchTimes) {
		this.trainingBatchTimes = trainingBatchTimes;
	}
	@Override
	public String toString() {
		return "Mentor [fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", mentorId=" + mentorId
				+ ", avgRating=" + avgRating + ", experiance=" + experiance + ", expertInTechnls="
				+ Arrays.toString(expertInTechnls) + ", noOfTrainingsDelivered=" + noOfTrainingsDelivered
				+ ", trainingBatchTimes=" + Arrays.toString(trainingBatchTimes) + "]";
	}
	
	
	
}
