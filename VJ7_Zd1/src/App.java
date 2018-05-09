import java.util.ArrayList;
import java.util.Collections;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add("auto");
		lista.add("svemirski brod");
		lista.add("avion");
		lista.add("helikopter");
		lista.add("jedrilica");
		lista.add("gliser");
		lista.add("romobil");
		lista.add("bicikla");
		
		System.out.println("--------Nesortirano-----------");
		for (String item: lista) {
			System.out.println(item);
		}
		
		Collections.sort(lista);
		System.out.println("--------Sortirano-----------");
		for (String item: lista) {
			System.out.println(item);
		}
		
		Collections.sort(lista, new LengthStrComparator());
		
		System.out.println("--------Sortirano po dužini stringa-----------");
		for (String item: lista) {
			System.out.println(item);
		}
		
		Collections.sort(lista, new MojComparator());
		
		System.out.println("--------Sortirano po dužini stringa silazno-----------");
		for (String item: lista) {
			System.out.println(item);
		}
	}

}
