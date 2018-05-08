
public class Customer {

	private int id;
	private String name;
	private String address;
	private String mail;
	
	public Customer(int a, String b, String c, String d){
		id=a;
		name=b;
		address=c;
		mail=d;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getMail() {
		return mail;
	}
	
	
}
