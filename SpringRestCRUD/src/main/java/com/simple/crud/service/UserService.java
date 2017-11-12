package com.simple.crud.service;

import java.util.List;

import com.simple.crud.domain.User;

public interface UserService {
	String save(User user);
	String delete(Long userId);
	User getUser(Long userId);
	List<User> allUsers();
}
