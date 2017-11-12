package com.simple.crud.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simple.crud.domain.User;
import com.simple.crud.exception.CrudException;
import com.simple.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> allUsers(){
		List<User> userList = userService.allUsers();
		if(userList.isEmpty()){
			new CrudException("User table is empty");
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
       
        User user = userService.getUser(id);
        if (user == null) {
           return new ResponseEntity<Object>(new CrudException("User with id " + id  + " not found").getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> getUpdate(@Valid @RequestBody User user) {
        
        String str = userService.save(user);
       
        return new ResponseEntity<Object>(str, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
       
		 String str = userService.delete(id);
        if (str.contains("Not Found")) {
           return new ResponseEntity<Object>(new CrudException("User with id " + id  + " not found").getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(str , HttpStatus.OK);
    }
	
	
	//[{"userid":1,"firstname":"test","lastname":"test","mailid":"test@aa.com"}]
	
}