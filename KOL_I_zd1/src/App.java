import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class App {

	static String[][] coDta = new String[16][];
	
	public static void main(String[] args) {
		
		ArrayList<String[]> red = new ArrayList<String[]>();
		LinkedHashMap<String, Integer> ukupno= new LinkedHashMap<>();
		LinkedHashMap<String, Integer> ukupno_cijena= new LinkedHashMap<>();
		int [] cijene= {5,10,15};
		
		File file = new File("./prodaja.csv") ;
		Scanner sc;
		try {
			sc = new Scanner(file) ;
			while(sc.hasNextLine()) {
				red.add(sc.nextLine().split(","));
			}
			red.toArray(coDta);
			sc.close ();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace () ;
		}
		
		for (int i = 1; i < coDta.length; i++) {
			int br_artikala=0;
			String firma="";
			int cijena=0;
			
			for (int j = 0; j < coDta[0].length; j++) {
				if (j<1) {
					firma=coDta[i][j];
				} else {
					br_artikala+=Integer.parseInt(coDta[i][j]);
					cijena+=Integer.parseInt(coDta[i][j])*cijene[j-1];
				}
			}
			
			if (ukupno.containsKey(firma)) {
				br_artikala+=ukupno.get(firma);
				cijena+=ukupno_cijena.get(firma);
			}

			ukupno.put(firma, br_artikala);
			ukupno_cijena.put(firma, cijena);
		}

		for (String kljuc: ukupno.keySet()) {
			System.out.println(kljuc+" "+"ukupno artikala "+ukupno.get(kljuc));
		}
		System.out.println("\n");
		for (String kljuc: ukupno_cijena.keySet()) {
			System.out.println(kljuc+" "+"ukupna cijena "+ukupno_cijena.get(kljuc)+"€");
		}

	}

}
