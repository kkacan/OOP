import java.util.concurrent.ThreadLocalRandom;

public class Goggles {
	
	private int id;
	private static String BEST;
	private static int price;
	
	public Goggles() {
		
	}

	public int getId() {
		
		this.id = ThreadLocalRandom.current().nextInt(1, 150000);
		return id;
	}

	public void setId(int id) {
		this.id = ThreadLocalRandom.current().nextInt(1, 150000);
	}

	public static String getBEST() {
		return BEST;
	}

	public void setBEST(String bEST) {
		BEST = bEST;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int pr) {
		price = pr;
	}
	
	
	

}
