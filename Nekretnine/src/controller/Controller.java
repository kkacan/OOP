package controller;

import java.util.List;
import gui.LeftFormEvent;
import gui.RightFormEvent;
import model.Database;
import model.Nekretnina;
import model.Stranka;


/**
 * Kontroler komunicira s bazom podataka koja predstavlja skup
 * objekata tipa Stranka i Nekretnina. 
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class Controller {

	private Stranka stranka;
	private Nekretnina nekretnina;
	private Database dbs;
	
	/**
	 * Konstruktor kreira novu bazu podataka.
	 */
	public Controller() {
		dbs = new Database();
	}
	
	/**
	 * Metoda kojom se dodaje novo kreiranu nekretninu u bazu i sprema sve nekretnine u datoteku.
	 * @param lfe 
	 * 			 objekt klase LeftFormEvent pomoæu kojeg primamo podatke iz lijeve forme
	 */
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
	/**
	 * Metoda kojom se editira nekretnina i sprema sve nekretnine u datoteku.
	 * @param lfe 
	 * 			 objekt klase LeftFormEvent pomoæu kojeg primamo podatke iz NekretninaDialog dialoga
	 * @param index 
	 *    		   indeks nekretnine u ArrayListi
	 */
	public void editNekretninaData(LeftFormEvent lfe, int index) {

		String vrsta = lfe.getVrstaNekretnine();
		String mjesto = lfe.getMjesto();
		String ulica = lfe.getUlica();
		String cijena =lfe.getCijena();
		String vrstaPon = lfe.getVrstaPonude();
		String imeStranke = lfe.getImeStranke();

		dbs.izmjeniNekretninu(index, vrsta, mjesto, ulica, cijena, vrstaPon, imeStranke);
		
		dbs.saveNekretnineToFile();

	}
	/**
	 * Metoda kojom se dodaje novo kreiranu stranku u bazu i sprema sve stranke u datoteku.
	 * @param rfe 
	 * 			 objekt klase RightFormEvent pomoæu kojeg primamo podatke iz desne forme
	 */
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
	/**
	 * Metoda kojom se editira stranka i sprema sve stranke u datoteku.
	 * @param rfe 
	 * 			 objekt klase RightFormEvent pomoæu kojeg primamo podatke iz StrankaDialog dialoga
	 * @param index 
	 * 			   indeks stranke u ArrayListi
	 */
	public void editStrankaData(RightFormEvent rfe, int index) {
		
		String ime = rfe.getIme();
		String adresa = rfe.getAdresa();
		String tel = rfe.getTel();
		String email = rfe.getEmail();
		
		dbs.izmjeniStranku(index, ime, adresa, tel, email);
		
		dbs.saveStrankeToFile();
		
	}

	/**
	 * Metoda kojom dohvaæamo cijelu bazu stranki.
	 * @return referencu na bazu stranki
	 */
	public List<Stranka> getDataStranke() {
		
		dbs.readStrankeFromFile();

		return dbs.getStranke();
	}
	/**
	 * Metoda kojom dohvaæamo cijelu bazu nekretnina.
	 * @return referencu na bazu nekretnina
	 */
	public List<Nekretnina> getDataNekretnine() {

		dbs.readNekretnineFromFile();

		return dbs.getNekretnine();
	}
	/**
	 * Metoda kojom uèitavamo objekte nekretnina i stranki iz datoteke.
	 */
	public void readDataFromFile() {
		
		dbs.readNekretnineFromFile();
		dbs.readStrankeFromFile();
	}
	/**
	 * Metoda koja generira novi id nekretnine koji je za 1 veæi od trenutno najveæeg u bazi.
	 * @return vraæa novi id nekretnine
	 */
	private int getNekretninaId() {
		
		int id=1;
		
		for (int i=0; i<getDataNekretnine().size();i++) {
			if (getDataNekretnine().get(i).getId()>id) id=getDataNekretnine().get(i).getId();
		}
		
		id+=1;
		
		return id;
	}
	/**
	 * Metoda koja generira novi id stranke koji je za 1 veæi od trenutno najveæeg u bazi.
	 * @return vraæa novi id stranke
	 */
	private int getStrankaId() {
		
		int id=1;
		
		for (int i=0; i<getDataStranke().size();i++) {
			if (getDataStranke().get(i).getId()>id) id=getDataStranke().get(i).getId();
		}
		
		id+=1;
		
		return id;
	}
	/**
	 * Metoda koja osvježava sve stranke u bazi.
	 * @param stranke 
	 * 				 ArrayList stranke
	 */
	public void refreshDataStranke(List<Stranka> stranke) {
		dbs.refreshDataStranke(stranke);
	}
	/**
	 * Metoda koja osvježava sve nekretnine u bazi.
	 * @param nekretnine 
	 * 					ArrayList nekretnine
	 */
	public void refreshDataNekretnine(List<Nekretnina> nekretnine) {
		dbs.refreshDataNekretnine(nekretnine);
	}


}
