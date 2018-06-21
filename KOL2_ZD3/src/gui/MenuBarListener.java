package gui;


import java.util.List;

import model.User;



public interface MenuBarListener {
		
	public List<User> getUsersData();
	public void setTextFromFile(String text);
	
}
