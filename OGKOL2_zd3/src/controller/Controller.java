package controller;

import java.util.List;

import gui.LeftFormEvent;
import gui.RightFormEvent;
import model.Buy;
import model.Customer;
import model.Database;

public class Controller {

	private Customer cst;
	private Buy buy;
	private Database dbs = new Database();

	public void addCustomerData(LeftFormEvent lfe) {

		String name = lfe.getName();
		String city = lfe.getCity();
		String mail = lfe.getMail();

		cst = new Customer(name, city, mail);
		dbs.addCustomer(cst);

	}

	public void listAllCustomers() {

		for (Customer cst : dbs.getCustomers()) {

			System.out.println("///////////////////// Customer //////////////////////");
			System.out.println(cst.getName() + " : " + cst.getCity() + " : " + cst.getMail());

		}
	}

	public List<Customer> getData() {
		System.out.println("Returning data from database :-)");
		return dbs.getCustomers();
	}
	
	
	public void addBuy(RightFormEvent rfe) {
		
		//buy= new Buy(rfe.getDelivery(),rfe.getGcText(),rfe.isDecorativePack(),rfe.isGiftCard(),rfe.isNewLetter(),rfe.getPaymentMet(),rfe.getProducrCat());
		//dbs.addCustomer(cst);
		dbs.addBuy(buy);
	}
	public void listAllBuy() {
		for (Customer ct : dbs.getAllCustomers()) {
			System.out.println("//////////////Customer/////////////");
			System.out.println(ct.getID()+":" +ct.getName()+":" +ct.getCity()+":" +ct.getMail());
		}
	}

}
