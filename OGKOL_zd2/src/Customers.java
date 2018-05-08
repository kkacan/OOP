import java.util.HashMap;
import java.util.Map;

public class Customers {
	
	private Map<Integer, Customer> mapa = new HashMap<Integer, Customer>();

	public Customers() {
		
	}
	public void addCustomer(int custid, Customer customer) {
		
		mapa.put(customer.getId(), customer);

	}
	
	public Map<Integer, Customer> getHmc(){
		
		
		return mapa;
		
	}
	
	
}
