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
	
	private List<User> users;

	
	
	public Database() {
		
		users= new ArrayList<>();

		
	}
	
	public void addUser(User user) {
		
		users.add(user);
	}
	
	
	public List<User> getUsers() {
		return users;
	}

	public void saveUsersToFile(File file){
		

		try (FileOutputStream fos = new FileOutputStream(file)){
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				System.out.println(users.size());
				for (int i=0; i <users.size(); i++) {
					oos.writeObject(users.get(i));
					System.out.println(users.get(i).getUserName());
				}
				oos.close () ;
				} catch (FileNotFoundException e) {
					System.out.println("Greška u zapisivanju!");
				} catch (IOException e) {
					System.out.println("Greška u zapisivanju!");
				}
	}
	
	public void readUsersFromFile(File file) {
		
		
		
		try (FileInputStream fis = new FileInputStream(file)) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				
				String text = "///////////////////// Users //////////////////////"+"\n";
				users= new ArrayList<>();
				User usr;
				while ( fis . available () > 0) {
					usr = (User) ois.readObject();
					users.add(usr);
					text+=usr.getUserName() + " : " + usr.getId() +"\n";
				}
				
				ois.close () ;
				System.out.println(text);
					
					
				} catch (FileNotFoundException e) {

					System.out.println("Greška u èitanju!");
				} catch (IOException e) {

					System.out.println("Greška u èitanju!");
				} catch (ClassNotFoundException e) {

					System.out.println("Greška u èitanju!");
				} finally {

				}
	}
	
	
	
	public void refreshData(List<User> users) {
		this.users=users;
		
	}
	
}
