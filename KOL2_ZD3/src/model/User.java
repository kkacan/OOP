package model;
import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private int id;
	
	public User(String userName, int id) {
		
		this.userName=userName;
		this.id=id;
	}

	public String getUserName() {
		return userName;
	}

	public int getId() {
		return id;
	}
	
	

}
