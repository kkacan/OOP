import java.util.ArrayList;

public class Calculation {
	private double pay;
	private float kreda;
	private float kamata;
	private int nacin;
	private int godina;
	
	public Calculation (float kreda, float kamata, int nacin, int godina) {
		
		this.kreda=kreda;
		this.kamata=kamata;
		this.nacin=nacin;
		this.godina=godina;
				
	}
	
	public static double calculate(float kreda, float kamata, int nacin, int godina) {

		double pay;
		float intr = kamata/nacin;
		int n = godina*12;
		double D = (Math.pow((1+intr), n)-1) / (intr*Math.pow((1+intr),n));
		pay = kreda / D;
		return pay;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public float getKreda() {
		return kreda;
	}

	public void setKreda(float kreda) {
		this.kreda = kreda;
	}

	public float getKamata() {
		return kamata;
	}

	public void setKamata(float kamata) {
		this.kamata = kamata;
	}

	public int getNacin() {
		return nacin;
	}

	public void setNacin(int nacin) {
		this.nacin = nacin;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}
	
}
