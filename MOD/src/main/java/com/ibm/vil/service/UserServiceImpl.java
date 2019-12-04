package com.ibm.vil.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.vil.adaptor.UserRepository;
import com.ibm.vil.controller.UserController;
import com.ibm.vil.data.model.User;
import com.ibm.vil.model.UserProfile;

@Service("UserService")
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	public void saveUser(UserProfile userProfile) {
		log.info("inside saveUser");
		//User user=userFactory(userProfile);
		//User savedUser=userCRUDRepository.save(user);
		userRepository.createUser(userProfile);
		log.info("user saved"); 
		
	}
	
	public List<UserProfile> findAllUsers(){
		//List<User> userList=userCRUDRepository.findAll();
		List<User> userList=userRepository.findAllUsers();
		List<UserProfile> userProfileList=new ArrayList<UserProfile>();
		for(User user:userList){
			UserProfile userProfile=userProfileFactory(user);
			userProfileList.add(userProfile);
		}		
		log.info("Users fetched"+userList.iterator().toString());
		return userProfileList;
	}
	
	public UserProfile findUserByName(String name){
		User user=userRepository.findUserByName(name);
		UserProfile userProfile=userProfileFactory(user);
		log.info("User fetched"+userProfile.toString());
		return userProfile;
	}
	
	public User userFactory(UserProfile userProfile) {
		
		log.info("tech"+userProfile.getTech_selectedItems().toString());
		String technologies ="";
		String timebatch="";
		for(String technology:userProfile.getTech_selectedItems()) {
			technologies= technology +","+technologies ;
		}
		
		for(String time:userProfile.getTime_selectedItems()) {
			timebatch= time + ","+timebatch ;
		}
		
		User user=new User();
		user.setAddress(userProfile.getAddress());
		user.setEmail(userProfile.getEmail());
		user.setExperience(userProfile.getExperience());
		user.setId(userProfile.getId());
		user.setPassword(userProfile.getPassword());
		user.setPhoneNo(userProfile.getPhoneNo());
		user.setTech_selectedItems(technologies);
		user.setTime_selectedItems(timebatch);
		user.setUserName(userProfile.getUserName());
		user.setUserRole(userProfile.getUserRole());
		user.setAverage_rating(userProfile.getAverage_rating());
		user.setNo_of_trainings_dlvr(userProfile.getNoOfTrainingsDlvr());
		return user;
	}
	
	public UserProfile userProfileFactory(User user) {
		
		UserProfile userProfile=new UserProfile();
		userProfile.setAddress(user.getAddress());
		userProfile.setEmail(user.getEmail());
		userProfile.setExperience(user.getExperience());
		userProfile.setId(user.getId());
		userProfile.setPassword(user.getPassword());
		userProfile.setPhoneNo(user.getPhoneNo());
		userProfile.setTech_selectedItems(user.getTech_selectedItems().split(","));
		userProfile.setTime_selectedItems(user.getTime_selectedItems().split(","));
		userProfile.setUserName(user.getUserName());
		userProfile.setUserRole(user.getUserRole());
		userProfile.setAverage_rating(user.getAverage_rating());
		userProfile.setNoOfTrainingsDlvr(user.getNo_of_trainings_dlvr());
		return userProfile;
		
	}

	@Override
	public List<String> getMentorList() {
		
		List<String> mentorList=userRepository.getMentorList();
		return mentorList;
	}

	@Override
	public boolean isUserPasswordValid(String username,String password) {
		return userRepository.isUserPasswordValid(username, password);
		
	}
	
	@Override
	public String getUserRole (String username) {
		return userRepository.getUserRole(username);
	}
}
