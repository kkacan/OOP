package gui;

import java.util.List;

import model.Customer;

public interface MenuBarListener {
		
	public List<Customer> getCustomersData();
	public void setTextFromFile(String text);

}
