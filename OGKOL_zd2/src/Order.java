import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class Order {

	private static Map<Integer, ArrayList<?>> orders = new HashMap<Integer, ArrayList<?>>();
	private int cntr;
	
	public Order() {
		
	}
	
	public static void CreateOrder(Customer cust, ArrayList<?> lista) {
		
		ArrayList tempList;
		   if (orders.containsKey(cust.getId())) {
		      tempList = orders.get(cust.getId());
		      if(tempList == null)
		         tempList = new ArrayList();
		      tempList.add(lista);  
		   } else {
		      tempList = new ArrayList();
		      tempList.add(lista);               
		   }
		   
		orders.put(cust.getId(), tempList);
		
	}
	
	public static Map<Integer, ArrayList<?>> getOmp(){
		
		return orders;
		
	}
	
	public ArrayList<Customer> getArrCust(){
		
		
		return null;
		
	}
	
	public static void CalcOrderPrice(ArrayList<?> lista) {

		int cijena=0;
   	 
   	 	for (int i=0; i<lista.size();i++) {
   	 		Goggles g =(Goggles) lista.get(i);
   	 		cijena+=g.getPrice();
   	 	}
   	 
   	 	System.out.println("Order price:" + cijena);
   	 	System.out.println("\n");
	}
	
	
	
}
