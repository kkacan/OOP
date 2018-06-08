package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private ArrayList<Customer> customers;
	private ArrayList<Buy> buy;
	
	public Database() {
		customers = new ArrayList<>();
		buy= new ArrayList<>();
	}
	
	public void addCustomer(Customer cst) {
		customers.add(cst);
	}
	
	public List<Customer> getCustomers () {
		
		return customers;
	}
	
	public void addBuy(Buy by) {
		buy.add(by);
	
		
	}
	public List<Buy> getAllBuy(){
		
		return buy;
	}
	public List<Customer> getAllCustomers(){
		
		return customers;
	}


}
