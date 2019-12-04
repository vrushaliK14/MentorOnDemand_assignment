package com.ibm.vil.adaptor;

import java.util.List;

import com.ibm.vil.model.SearchTraining;


public interface TrainingRepository{ 

	 List<SearchTraining> getTrainingListByTechnology(String tech);
	 
	 List<SearchTraining> getTrainingListByTechTime(String batchTime, String technology);
	 
	 public List<SearchTraining> getTrainingListByMentorTechTime(String batchTime, String technology,String mentorName);
	
	 public List<String> getTechnologyList();
	 
	 public List<SearchTraining> getTrainingDEtailsForUser(String username);
	 
	 public List<SearchTraining> getTrainingDEtailsForMentor(String mentorname);
	 
	 public boolean applyForTraining(SearchTraining training) ;
	 
	 public boolean updateTrainingStatus(String status,int techId);
	 
	 public boolean deleteTechnology(String technology);
	 public boolean addTechnology(String technology,int fee);
	}

