package com.ibm.vil.data.model;



public class TimeBatch {
	
	private String timeBacthId;
	private String timeBacthName;

	public String getTimeBacthName() {
		return timeBacthName;
	}

	public void setTimeBacthName(String timeBacthName) {
		this.timeBacthName = timeBacthName;
	}

	public String getTimeBacthId() {
		return timeBacthId;
	}

	public void setTimeBacthId(String timeBacthId) {
		this.timeBacthId = timeBacthId;
	}

	@Override
	public String toString() {
		return "TimeBatch [timeBacthId=" + timeBacthId + ", timeBacthName=" + timeBacthName + "]";
	}
}
