import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {

	private static ArrayList<Integer> lista = new ArrayList<Integer>();
	private static ArrayList<Integer> lista2 = new ArrayList<Integer>();
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		lista.addAll(slucajan_broj(10));
		
		Collections.sort(lista);
		System.out.println("--------Sortirano-----------");
		for (Integer item: lista) {
			System.out.println(item);
		}
		
		System.out.println("--------Sortirano silazno-----------");
		Collections.sort(lista, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2){
				      return -1;
				    } else if(o1 < o2){
				      return 1;
				    } else {
				      return 0;
				    }
			
			}
		});
		
		for (Integer item: lista) {
			System.out.println(item);
		}

	}
	
	private static ArrayList<Integer> slucajan_broj(int broj_elemenata) {

		int min=10;
		int max=1000;
		
		while (broj_elemenata>0) {
		
			lista2.add(min + (int)(Math.random() * ((max - min) + 1)));
			broj_elemenata-=1;
		}
  
	   return lista2;
	}

}
