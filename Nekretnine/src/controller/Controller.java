package controller;

import java.util.List;
import gui.LeftFormEvent;
import gui.RightFormEvent;
import model.Database;
import model.Nekretnina;
import model.Stranka;

public class Controller {

	private Stranka stranka;
	private Nekretnina nekretnina;
	private Database dbs;
	
	
	public Controller() {
		dbs = new Database();
	}
	
	public void addNekretninaData(LeftFormEvent lfe) {
		
		int id =getNekretninaId();

		String vrsta = lfe.getVrstaNekretnine();
		String mjesto = lfe.getMjesto();
		String ulica = lfe.getUlica();
		String cijena =lfe.getCijena();
		String vrstaPon = lfe.getVrstaPonude();
		boolean ponuda = lfe.isPonuda();
		String imeStranke = lfe.getImeStranke();

		nekretnina = new Nekretnina(id, vrsta, mjesto, ulica, cijena, vrstaPon ,ponuda, imeStranke);
		dbs.dodajNekretninu(nekretnina);
		
		dbs.saveNekretnineToFile();

	}
	
	public void addStrankeData(RightFormEvent rfe) {
		
		String ime = rfe.getIme();
		String adresa = rfe.getAdresa();
		String tel = rfe.getTel();
		String email = rfe.getEmail();
		
		int id = getStrankaId();
		
		stranka= new Stranka (id, ime, adresa, tel, email);
		dbs.dodajStranku(stranka);
		
		dbs.saveStrankeToFile();
		
	}

	public void listAllCustomers() {

		/*for (Stranka cst : dbs.getStranke()) {

			System.out.println("///////////////////// Stranke //////////////////////");
			//System.out.println(cst.getName() + " : " + cst.getCity() + " : " + cst.getMail());

		}*/
	}

	public List<Stranka> getDataStranke() {
		dbs.readStrankeFromFile();
		//System.out.println("Returning data from database :-)");
		return dbs.getStranke();
	}
	public List<Nekretnina> getDataNekretnine() {
		dbs.readNekretnineFromFile();
		//System.out.println("Returning data from database :-)");
		return dbs.getNekretnine();
	}
	
	public void readDataFromFile() {
		dbs.readNekretnineFromFile();
		dbs.readStrankeFromFile();
	}
	
	private int getNekretninaId() {
		
		int id=1;
		
		for (int i=0; i<getDataNekretnine().size();i++) {
			if (getDataNekretnine().get(i).getId()>id) id=getDataNekretnine().get(i).getId();
		}
		
		id+=1;
		
		return id;
	}
	private int getStrankaId() {
		
		int id=1;
		
		for (int i=0; i<getDataStranke().size();i++) {
			if (getDataStranke().get(i).getId()>id) id=getDataStranke().get(i).getId();
		}
		
		id+=1;
		
		return id;
	}
	
	/*public void saveDataToFile() {
		dbs.saveNekretnineToFile();
		dbs.saveStrankeToFile();
	}*/
	
/*	public void refreshData(ArrayList<Stranka> stranke, ArrayList<Nekretnina> nekretnine) {
		dbs.refreshData(stranke, nekretnine);
	}*/
	
	
	/*public void addBuy(RightFormEvent rfe) {
		
		//buy= new Buy(rfe.getDelivery(),rfe.getGcText(),rfe.isDecorativePack(),rfe.isGiftCard(),rfe.isNewLetter(),rfe.getPaymentMet(),rfe.getProducrCat());
		//dbs.addCustomer(cst);
		dbs.addBuy(buy);
	}*/
	/*public void listAllBuy() {
		for (Customer ct : dbs.getAllCustomers()) {
			System.out.println("//////////////Customer/////////////");
			System.out.println(ct.getID()+":" +ct.getName()+":" +ct.getCity()+":" +ct.getMail());
		}
	}*/
	
		
	
	

}
