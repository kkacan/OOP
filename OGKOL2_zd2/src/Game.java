import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	private int randomBroj;
	private ArrayList<Integer> pokusaji =new ArrayList();
	
	public Game() {
		
	}

	public void setRandomBroj() {
		this.randomBroj = ThreadLocalRandom.current().nextInt(1, 42);
	}

	public int getRandomBroj() {
		
		
		return randomBroj;
	}
	
	public void dodajPokusaj(int broj) {
		pokusaji.add(broj);
		
	}

	public ArrayList<Integer> getPokusaji() {
		return pokusaji;
	}
	
	public void obrisiPokusaje() {
		pokusaji =new ArrayList();
	}
	
	
}
