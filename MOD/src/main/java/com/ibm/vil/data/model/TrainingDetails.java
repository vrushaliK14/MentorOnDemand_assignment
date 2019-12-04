package com.ibm.vil.data.model;

import java.util.Date;

public class TrainingDetails {

	   private int TRAINING_ID;  
	   private String TECHNOLOGY;     
	   private String USER_NAME;    
	   private String MENTOR_NAME;    
	   private String STATUS;   
	   private String BATCH_TIME;     
	   private Date START_DATE;  
	   private Date END_DATE;    
	   private String PAYMENT_STATUS; 
	   private String TRAINING_FEE;
	public int getTRAINING_ID() {
		return TRAINING_ID;
	}
	public void setTRAINING_ID(int tRAINING_ID) {
		TRAINING_ID = tRAINING_ID;
	}
	public String getTECHNOLOGY() {
		return TECHNOLOGY;
	}
	public void setTECHNOLOGY(String tECHNOLOGY) {
		TECHNOLOGY = tECHNOLOGY;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getMENTOR_NAME() {
		return MENTOR_NAME;
	}
	public void setMENTOR_NAME(String mENTOR_NAME) {
		MENTOR_NAME = mENTOR_NAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getBATCH_TIME() {
		return BATCH_TIME;
	}
	public void setBATCH_TIME(String bATCH_TIME) {
		BATCH_TIME = bATCH_TIME;
	}
	public Date getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public Date getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getPAYMENT_STATUS() {
		return PAYMENT_STATUS;
	}
	public void setPAYMENT_STATUS(String pAYMENT_STATUS) {
		PAYMENT_STATUS = pAYMENT_STATUS;
	}
	public String getTRAINING_FEE() {
		return TRAINING_FEE;
	}
	public void setTRAINING_FEE(String tRAINING_FEE) {
		TRAINING_FEE = tRAINING_FEE;
	}
	@Override
	public String toString() {
		return "TrainingDetails [TRAINING_ID=" + TRAINING_ID + ", TECHNOLOGY=" + TECHNOLOGY + ", USER_NAME=" + USER_NAME
				+ ", MENTOR_NAME=" + MENTOR_NAME + ", STATUS=" + STATUS + ", BATCH_TIME=" + BATCH_TIME + ", START_DATE="
				+ START_DATE + ", END_DATE=" + END_DATE + ", PAYMENT_STATUS=" + PAYMENT_STATUS + ", TRAINING_FEE="
				+ TRAINING_FEE + "]";
	}
	   
	   
	   

}
