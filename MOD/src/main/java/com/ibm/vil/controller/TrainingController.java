package com.ibm.vil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.vil.adaptor.TrainingRepository;
import com.ibm.vil.model.SearchTraining;


@CrossOrigin
@Controller
@RequestMapping("/training")
public class TrainingController {
	
	private static final Logger log = LoggerFactory.getLogger(TrainingController.class);
	
	@Autowired
	TrainingRepository trainingRepository;
	
	
	@GetMapping(path="/listByTech" , produces="application/json")
	@ResponseBody
	public List<SearchTraining> getTrainingListByTech(@RequestParam String technology){
		log.info("Fetch Trainings");
		List<SearchTraining> trainings=trainingRepository.getTrainingListByTechnology(technology);
		log.info("Fetched Trainings"+trainings.size());
		return trainings;	
	}
	
	@GetMapping(path="/listByTechTime" , produces="application/json")
	@ResponseBody
	public List<SearchTraining> getTrainingListByTechTime(@RequestParam String batchTime,String technology){
		log.info("Fetch Trainings");
		List<SearchTraining> trainings=trainingRepository.getTrainingListByTechTime(batchTime, technology);
		log.info("Fetched Trainings"+trainings.size());
		return trainings;	
	}
	
	@GetMapping(path="/listByMentorTechTime" , produces="application/json")
	@ResponseBody
	public List<SearchTraining> getTrainingListByMentorTechTime(@RequestParam String batchTime,String technology,String mentorName){
		log.info("Fetch Trainings");
		List<SearchTraining> trainings=trainingRepository.getTrainingListByMentorTechTime(batchTime, technology, mentorName);
		log.info("Fetched Trainings"+trainings.size());
		return trainings;	
	}
	
	
	@GetMapping(path="/fetchTechnologies" , produces="application/json")
	@ResponseBody
	public List<String> getTechnologyList(){
		log.info("Fetch Tech list");
		List<String> trainings=trainingRepository.getTechnologyList();
		log.info("Fetched Tech list");
		return trainings;	
	}
	
	
	
	@GetMapping(path="/trainingDetailsForUser" , produces="application/json")
	@ResponseBody
	public List<SearchTraining> getTrainingDetailsForUser(@RequestParam String username){
		log.info("Fetch Trainings");
		List<SearchTraining> trainings=trainingRepository.getTrainingDEtailsForUser(username);
		log.info("Fetched Trainings"+trainings.size());
		return trainings;	
	}
	
	@GetMapping(path="/trainingDetailsForMentor" , produces="application/json")
	@ResponseBody
	public List<SearchTraining> getTrainingDetailsForMentor(@RequestParam String username){
		log.info("Fetch Trainings");
		List<SearchTraining> trainings=trainingRepository.getTrainingDEtailsForMentor(username);
		log.info("Fetched Trainings"+trainings.size());
		return trainings;	
	}
	
	
	
	@PostMapping(path="/applyForTraining" , consumes="application/json", produces="application/json")
	@ResponseBody
	public boolean applyForTraining(@RequestBody SearchTraining trainingDetails) {
		log.info("Apply for training : "+trainingDetails.toString());
		boolean flag=trainingRepository.applyForTraining(trainingDetails);
		log.info("data updated");
		return flag;
	}
	
	@GetMapping(path="/updateTrainingStatus" , produces="application/json")
	@ResponseBody
	public boolean updateTrainingStatus(@RequestParam String status,int techId) {
		log.info("update status {} for  training is :{} "+status,techId);
		boolean flag=trainingRepository.updateTrainingStatus(status, techId);
		log.info("data updated");
		return flag;
	}
	
	@GetMapping(path="/deleteTechonology" , produces="application/json")
	@ResponseBody
	public boolean deleteTechnology(@RequestParam String technology) {
		log.info("delete  technology is :{} "+technology);
		boolean flag=trainingRepository.deleteTechnology(technology);
		log.info("deleted technology");
		return flag;
	}
	

	@GetMapping(path="/addTechonology" , produces="application/json")
	@ResponseBody
	public boolean deleteTechnology(@RequestParam String technology,int fee) {
		log.info("add  technology is :{} "+technology);
		boolean flag=trainingRepository.addTechnology(technology,fee);
		log.info("added technology");
		return flag;
	}
	
}
