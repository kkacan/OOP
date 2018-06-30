package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja spremnik podataka za nekretnine i stranke. Možemo je
 * proomatrati kao jednostavnu bazu podataka.
 * 
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class Database {
	
	/**
	 * Stranke i nekretnine spremamo u strukturu ArrayList
	 */
	private List<Stranka> stranke;
	private List<Nekretnina> nekretnine;
	
	
	public Database() {
		
		stranke= new ArrayList<>();
		nekretnine= new ArrayList<>();
		
	}
	
	/**
	 * Metoda kojom se stranke spremaju u ArrayList
	 * 
	 * @param stranka
	 *            objekt klase Stranka
	 */
	public void dodajStranku(Stranka stranka) {
		
		stranke.add(stranka);
	}
	
	/**
	 * Metoda kojom se podaci stranke ažuriraju u ArrayList
	 * 
	 * @param index indeks stranke u ArrayList
	 * @param ime ime stranke
	 * @param adresa adresa stranke
	 * @param tel telefon stranke
	 * @param email email stranke
	 */
	public void izmjeniStranku(int index, String ime, String adresa, String tel, String email) {
		
		stranke.get(index).setImePrezime(ime);
		stranke.get(index).setAdresaStanovanja(adresa);
		stranke.get(index).setTel(tel);
		stranke.get(index).setEmail(email);
	}
	
	/**
	 * Metoda kojom se nekretnine spremaju u ArrayList
	 * 
	 * @param nekretnina
	 *            objekt klase Nekretnina
	 */
	public void dodajNekretninu(Nekretnina nekretnina) {
		
		nekretnine.add(nekretnina);
	}
	

	/**
	 * Metoda kojom se podaci nekretnine ažuriraju u ArrayList
	 * 
	 * @param index indeks nekretnine u ArrayList
	 * @param vrsta vrsta nekrenine
	 * @param mjesto mjesto gdje se nalazi nekretnina
	 * @param ulica ulica gdje se nalazi nekretnina
	 * @param cijena cijena nekretnine
	 * @param vrstaPon vrsta ponude nekretnine
	 * @param imeStranke ime stranke koja nudi ili traži nekretninu
	 */
	public void izmjeniNekretninu(int index, String vrsta, String mjesto, String ulica, String cijena, String vrstaPon, String imeStranke) {
		
		nekretnine.get(index).setCijena(cijena);
		nekretnine.get(index).setImeStranke(imeStranke);
		nekretnine.get(index).setMjesto(mjesto);
		nekretnine.get(index).setUlica(ulica);
		nekretnine.get(index).setVrstaNekretnine(vrsta);
		nekretnine.get(index).setVrstaPonude(vrstaPon);
	}

	public List<Stranka> getStranke() {
		return stranke;
	}

	public List<Nekretnina> getNekretnine() {
		return nekretnine;
	}
	
	/**
	 * Metoda za spremanje objekata tipa Nekretnina u datoteku
	 */
	public void saveNekretnineToFile(){
		
		File file= new File("Nekretnine.obj");
		
		try (FileOutputStream fos = new FileOutputStream(file)){
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				for (int i=0; i <nekretnine.size(); i++) {
					oos.writeObject(nekretnine.get(i));
				}
				oos.close () ;
				} catch (FileNotFoundException e) {
					System.out.println("Greška u zapisivanju!");
				} catch (IOException e) {
					System.out.println("Greška u zapisivanju!");
				}
	}
	
	/**
	 * Metoda za èitanje objekata tipa Nekretnina iz datoteke
	 */
	public void readNekretnineFromFile() {
		
		File file= new File("Nekretnine.obj");
		
		try (FileInputStream fis = new FileInputStream(file)) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				nekretnine= new ArrayList<>();
				
				while ( fis . available () > 0) {
					nekretnine.add((Nekretnina) ois .readObject());

				}

				ois.close () ;
					
				} catch (FileNotFoundException e) {

					System.out.println("Greška u èitanju!");
				} catch (IOException e) {

					System.out.println("Greška u èitanju!");
				} catch (ClassNotFoundException e) {

					System.out.println("Greška u èitanju!");
				} finally {

				}
	}
	
	/**
	 * Metoda za spremanje objekata tipa Stranka u datoteku
	 */
	public void saveStrankeToFile(){
		
		File file= new File("Stranke.obj");
		
		try (FileOutputStream fos = new FileOutputStream(file)){
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				for (int i=0; i <stranke.size(); i++) {
					oos.writeObject(stranke.get(i));
				}
				oos.close () ;
				} catch (FileNotFoundException e) {
					System.out.println("Greška u zapisivanju!");
				} catch (IOException e) {
					System.out.println("Greška u zapisivanju!");
				}
	}
	
	/**
	 * Metoda za èitanje objekata tipa Stranka iz datoteke
	 */
	public void readStrankeFromFile() {
		
		File file= new File("Stranke.obj");
		
		try (FileInputStream fis = new FileInputStream(file)) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				stranke= new ArrayList<>();
				
				while ( fis . available () > 0) {
					stranke.add((Stranka) ois.readObject());
				}

				ois.close () ;
					
					
				} catch (FileNotFoundException e) {

					System.out.println("Greška u èitanju!");
				} catch (IOException e) {

					System.out.println("Greška u èitanju!");
				} catch (ClassNotFoundException e) {

					System.out.println("Greška u èitanju!");
				} finally {

				}
	}
	
	/**
	 * Metoda koja prima listu stranaka i pohranjuje ih u datoteku.
	 * @param stranke ArrayList stranke
	 */
	public void refreshDataStranke(List<Stranka> stranke) {
		
		this.stranke=stranke;
		saveStrankeToFile();

	}
	
	/**
	 * Metoda koja prima listu nekretnina i pohranjuje ih u datoteku.
	 * @param nekretnine ArrayList nekretnine
	 */
	public void refreshDataNekretnine(List<Nekretnina> nekretnine) {
		
		this.nekretnine=nekretnine;
		saveNekretnineToFile();
	

	}

	
}
