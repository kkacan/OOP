import java.util.Iterator;
import java.util.LinkedList;

public class App {
	
	private static LinkedList<String> lista = new LinkedList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		lista.add("car");
		lista.add("helicopter");
		lista.add("electronic bike");
		lista.add("truck");
		lista.add("motorcycle");
		lista.add("carriage");
		
		printList(lista);
		
		System.out.println("--------from Iteratora--------------------");
		
		Iterator<String> itr = lista.iterator();
		while(itr.hasNext()){
			
			String item=itr.next();
			System.out.println(item);
		    if(item.equals("carriage")) itr.remove();		      
		}
		
		ListProcessing processing = new ListProcessing();
		processing.insertVeh("Novi", lista);
		printList(lista);
		
	}
	
	private static void printList(LinkedList<String> lista2) {
		
		
		System.out.println("--------printList--------------------");
		for (String items: lista2) {
			System.out.println(items);
		}

	}

}
