package com.simple.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.stereotype.Service;

import com.simple.crud.domain.User;
import com.simple.crud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	public String delete(Long userId) {
		User findUser = findUser(userId);

		if (findUser != null) {
			repository.delete(findUser);
			return "User ID :" + findUser.getUserid() + " Deleted successfully";
		} else {
			
			return "User ID :" + userId + " Not Found";
		}
		
	}

	public String save(User user) {
		
		repository.save(user);
		return "User ID :" + user.getUserid() + " Saved successfully";
	}

	public List<User> allUsers() {
		List<User> userList = (List<User>) repository.findAll();
		
		return userList;
	}

	public User getUser(Long userId) {
		
		return findUser(userId);
	}
	
	
	private User findUser(Long userId){
		return repository.findOne(userId);
	}

}
