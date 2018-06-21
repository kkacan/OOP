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

public class Database {
	
	private List<Stranka> stranke;
	private List<Nekretnina> nekretnine;
	
	
	public Database() {
		
		stranke= new ArrayList<>();
		nekretnine= new ArrayList<>();
		
	}
	
	public void dodajStranku(Stranka stranka) {
		
		stranke.add(stranka);
	}
	
	public void dodajNekretninu(Nekretnina nekretnina) {
		
		nekretnine.add(nekretnina);
	}

	public List<Stranka> getStranke() {
		return stranke;
	}

	public List<Nekretnina> getNekretnine() {
		return nekretnine;
	}
	
	
	public void saveNekretnineToFile(){
		
		File file= new File("Nekretnine.obj");
		
		try (FileOutputStream fos = new FileOutputStream(file)){
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				System.out.println(nekretnine.size());
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
	
	public void refreshData(List<Stranka> stranke, List<Nekretnina> nekretnine) {
		this.stranke=stranke;
		this.nekretnine=nekretnine;
		saveNekretnineToFile();
		saveStrankeToFile();

	}
	
}
