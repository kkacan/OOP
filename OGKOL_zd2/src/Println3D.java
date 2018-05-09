import java.util.ArrayList;

public class Println3D {
	
	public Println3D(){
		
	}
	
	public static void printGoggles(int broj_naocala, Customer cust) {
		
		ArrayList<Goggles> lista = new ArrayList<Goggles>();
		
		for (int i=0; i<broj_naocala;i++) {
			Goggles goggles = new Goggles();
			goggles.getId();
			goggles.setPrice(10);
			lista.add(goggles);
		}
		
		
		Order.CreateOrder(cust, lista);

		/*int order_price=0;
		for (Goggles item: lista) {
			order_price+=item.getPrice();
		}
		
		System.out.println("Customer: "+cust.getName());
		System.out.println(lista.toString());
		System.out.println("Order price: "+order_price);
		System.out.println("\n");*/
		
		
	}

}
