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

import com.ibm.vil.model.UserProfile;
import com.ibm.vil.service.UserService;


@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	
	@GetMapping(path="/findAll")
	@ResponseBody
	public List<UserProfile> findAllUsers() {
		log.info("Search users");
		List<UserProfile> allUsers=userService.findAllUsers();
		log.info("allUsers size"+allUsers.size());
		return allUsers;
	}
	
    @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public UserProfile addEmployee(@RequestBody UserProfile user) 
    {
    	log.info("creating user:"+user.toString());
    	userService.saveUser(user);
    	
        return user;
    }
    

	@GetMapping(path="/fetchMentorList" , produces="application/json")
	@ResponseBody
	public List<String> getMentorList(){
		log.info("Fetch mentor list");
		List<String> trainings=userService.getMentorList();
		log.info("Fetched mentor list");
		return trainings;	
	}
	

    
    @GetMapping(path="/findByName" , produces = "application/json")
	@ResponseBody
	public UserProfile findUsersByName(@RequestParam String name) {
		log.info("Search users for "+name);
		UserProfile user=userService.findUserByName(name);
		return user;
	}
    
    @GetMapping(value = "/authenticateUser", produces ="application/json")
    @ResponseBody
    public boolean authenticateUser(@RequestParam String username,String password) {
    	log.info("validating user: {}  and password: {} ",username ,password ); 
    	
    	boolean isvalid=userService.isUserPasswordValid(username, password);
    	
    	log.info("validated user: {}  and password: {} is valid: {}",username ,password,isvalid );
    	
    	return isvalid;
    }
    
    @GetMapping(value = "/isMentor", produces ="application/json")
    @ResponseBody
    public boolean isMentor(@RequestParam String username) {
    	String userRole=userService.getUserRole(username);
    	if(userRole.equals("Mentor")) {
    		log.info("user is Mentor");
    		return true;
    	}else {
    		log.info("user is Student");
    		return false;
    	}
    	
    }
    
}
