
public class Calculation {
	
	public static void avgSems(String[][] grades) {
		
			
		for (int row = 1; row < grades.length; row++) {
			
			Double ocjena = 0.0;
			int broj_ocjena = 0;
			
			for (int element = 1; element < grades[row].length; element++) {
			    
			    ocjena += Double.parseDouble(grades[row][element]);
			    broj_ocjena++;
			}
			  
			System.out.println(grades[row][0] +" ------> "+ roundN(ocjena/broj_ocjena,2));
		}
		
	}
	
	private static double roundN(double value, int places) {
			double scale = Math.pow(10, places);
			return Math.round(value * scale) / scale;
	}

}
