package com.ibm.vil.service;

import java.util.List;
import com.ibm.vil.model.UserProfile;

public interface UserService {
	public void saveUser(UserProfile user);
	public List<UserProfile> findAllUsers();
	public UserProfile findUserByName(String name);
	public List<String> getMentorList();
	public boolean isUserPasswordValid(String username,String password);
	public String getUserRole (String username);
}
