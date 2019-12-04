package com.ibm.vil.adaptor;

import java.util.List;

import com.ibm.vil.data.model.User;
import com.ibm.vil.model.UserProfile;

public interface UserRepository {
	public User findUserByName(String name) ;
	public List<String> getMentorList();
	public boolean isUserPasswordValid(String username ,String password);
	public String getUserRole (String username);
	public void createUser(UserProfile userProfile);
	public List<User> findAllUsers();
}
