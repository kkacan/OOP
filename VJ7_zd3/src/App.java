import java.util.concurrent.ArrayBlockingQueue;

public class App {

	private static ArrayBlockingQueue<Integer> red = new ArrayBlockingQueue<Integer>(5);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			red.add(1);
			red.add(2);
			red.add(3);
			red.add(4);
			red.add(5);
			
			for (Integer item: red) {
				System.out.println(item);
			}
			
			red.add(1);
		} catch (IllegalStateException e) {
			
			System.out.println("Ne možete dodati više od 5 elemenata u ovaj red!");
		}
		
		if (obrada(1)) {
			primi(7);
		}
		for (Integer item: red) {
			System.out.println(item);
		}
		if (obrada(1)) {
			primi(11);
		}
	
		for (Integer item: red) {
			System.out.println(item);
		}

	}
	
	private static boolean obrada(int flag) {
		
		if (flag==1) {
			System.out.println("Obrada u tijeku....");
			red.poll();
			return true;
		} else {
			return false;
		}
	}
	
	private static void primi(int element) {
		red.add(element);
	}

}
