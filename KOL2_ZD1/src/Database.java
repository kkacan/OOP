

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private ArrayList<Calculation> calc;
	
	
	public Database() {
		calc = new ArrayList<>();
		
	}
	
	public void addCalc(Calculation cal) {
		calc.add(cal);
	}

	public ArrayList<Calculation> getCalc() {
		return calc;
	}

	public void setCalc(ArrayList<Calculation> calc) {
		this.calc = calc;
	}
	
	


}
