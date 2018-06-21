package controller;

import java.io.File;

import gui.DialogEvent;

import model.Database;

import model.User;

public class Controller {

	private User user;
	private Database dbs = new Database();
	
	
	public void addUserData(DialogEvent de) {
		
		
		String userName= de.getUserName();
		int id = de.getId();
		user = new User(userName,id);
		dbs.addUser(user);
		
		
	}
	

	public void getUsersFromFile(File file) {
		dbs.readUsersFromFile(file);
		
	}
	
	
	public void saveUsersToFile(File file) {
		dbs.saveUsersToFile(file);
		
	}


	public Database getDbs() {
		return dbs;
	}


	
	
}
