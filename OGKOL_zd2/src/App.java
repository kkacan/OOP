import java.util.ArrayList;
import java.util.Iterator;

public class App {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customers customers= new Customers();
		
		createCustomer(1,"Jure","Put Petrica 1", "bncnb@djh.com", customers);
		createCustomer(2,"Stipe","Put Petrica 2", "dfdf@djh.com", customers);
		createCustomer(3,"Mate","Put Petrica 3", "dds@djh.com", customers);
		
		Println3D.printGoggles(5, customers.getHmc().get(1));
		Println3D.printGoggles(10, customers.getHmc().get(1));
		Println3D.printGoggles(8, customers.getHmc().get(3));

		Iterator<Integer> it = Order.getOmp().keySet().iterator();
		ArrayList<?> tempList;
		int broj_nar=0;
		  
		while (it.hasNext()) {
		   int key = it.next(); 
		     
		   tempList = Order.getOmp().get(key);
		   if (tempList != null) {
		      for (Object value: tempList) {
		        	 
		        System.out.println("Customer: "+customers.getHmc().get(key).getName());
		        System.out.println(value);
		        	 
		        ArrayList al1 = (ArrayList) value;
		        	 
		        Order.CalcOrderPrice(al1);
		        broj_nar++;
		      }
		   }
		}
		   
		System.out.println("Ukupan broj naru�bi: "+broj_nar);
	
	}
	
	
	public static void createCustomer(int a, String b, String c, String d, Customers e) {
	
		Customer cust= new Customer(a, b, c, d);
		e.addCustomer(cust.getId(), cust);
		
	}

}
