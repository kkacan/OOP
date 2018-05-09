import java.util.LinkedList;
import java.util.ListIterator;

public class ListProcessing {

	
	public ListProcessing() {
		
	}

	
	void insertVeh(String novi, LinkedList<String> lista) {
		
		ListIterator<String> itr = (ListIterator<String>) lista.iterator();
		
		while(itr.hasNext()){
									 
		    if(itr.next().equals("electronic bike")) itr.add(novi);		      
		}
		System.out.println("--------from insertVeh--------------------");
		for (String items: lista) {
			System.out.println(items);
		}
	}
	
}
