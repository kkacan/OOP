import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

	public static void main(String[] args) {
		
		//čitanje datoteke scannerom i dodavanje svakog reda u povezanu listu
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
		
		// ispis liste stringova
		for(String item : lista) {
			System.out.println (item);
		}
					
		// ispis mape sa ključevima
		LinkedHashMap<Integer, String> mapa= new LinkedHashMap<Integer, String>();
		
		for (Integer kljuc: mapa.keySet()) {
			System.out.println("id= "+kljuc+" "+"opis= "+mapa.get(kljuc));
		}
		
		// ispis liste i brisanje vrijednosti pomoću iteratora
		Iterator<String> itr = lista.iterator();
		while(itr.hasNext()){
			String item=itr.next();
			System.out.println(item);
		    if(item.equals("carriage")) itr.remove();		      
		}
		
		// deklariranje i inicijalizacija 2D niza
		double[][] vars = new double[3][5];
		
		// popunjavanje vrijednosti 2D niza
		for (int i = 0; i < vars.length; i++) {
			for (int j = 0; j < vars[0].length; j++) {
				// Generiranje slučajne vrijednosti između zadanih granica
				vars[i][j] = ThreadLocalRandom.current().nextDouble(1, 100);
			}
		}
		
		// sortiranje anonimnom klasom
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
		
		// proširivanje metode klase
		Mob smart = new Mob() {
			private int izbor ;
			@Override
			public void poruka(int iz ) {
				switch ( iz ) {
					case 1: System.out. println ("Smart i SMS :􀀀)"); break;
					case 2: System.out. println ("Smart i MMS :􀀀)"); break;
					case 3: System.out. println ("Smart i mail poruka :􀀀)");break;
					default : System.out. println ("Smart jos nema tu mogucnost");
					break;
				}
			}
		};
		

		

	}
	
	//rekurzija faktorjela
	public static int faktorjele(int n) {
		if (n<1) return 1;
		return faktorjele(n-1)*(n);
	}
	
	
	//HashSet daje nasumično vrijednosti
	//LinkedHashSet daje vrijednosti po redu unosa
	//TreeSet daje vrijednosti po prirodnom redoslijedu
	
	//HashMap nasumično
	//TreeMap po ključu sortira
	//LinkedHashMap po redu unosa
	

}
