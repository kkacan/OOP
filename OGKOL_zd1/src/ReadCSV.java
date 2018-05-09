import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class ReadCSV {
	
	private static String [] lista = new String[10];
	private static String [][] lista2;
	
	public static void csvRead(){
		
		try {
			
			File file = new File("./studenti.csv") ;
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			for (int i=0; i<lista.length; i++) {
	        
				lista[i]=br.readLine();
				System.out.println(lista[i]);
			}
		
			br.close();
		
		} catch (FileNotFoundException e) {
			
			System.out.println("Datoteka nije pronađena!");

		} catch (IOException e) {
			
			System.out.println("Greška kod čitanja datoteke!");
		}

		
	}
	
	public static String[][] gen2DArr() {
	
		ArrayList<String[]> red = new ArrayList<String[]>();
		
		for (int i=0; i<lista.length; i++) {
			if (lista[i]!=null) red.add(lista[i].split(","));
		}

		lista2 = new String[red.size()][0];
		red.toArray(lista2);
	
		return lista2;
		
	}

}
