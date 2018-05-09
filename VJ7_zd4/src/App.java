import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		LinkedList<String> lista= new LinkedList<>();
		
		File file = new File("./tekstualna.txt") ;
		
		Scanner sc;
		try {
			sc = new Scanner(file) ;

			while(sc.hasNextLine()) {
				lista.add(sc.nextLine());
			}
			
			sc.close ();
		
		} catch (FileNotFoundException e) {

			e.printStackTrace () ;
		}
		
		for(String item : lista) {
			
			System.out.println (item);
		}
		
		Collections.sort(lista, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
			
				
				if(o1.length() > o2.length()){
				      return 1;
				    } else if(o1.length() < o2.length()){
				      return -1;
				    } else {
				      return 0;
				    }
			}
			
		});
		
		for(String item : lista) {
			
			System.out.println (item);
		}
			
	}
		
}


