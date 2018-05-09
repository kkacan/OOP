import java.util.Arrays;


public class App {
	
	public static void main(String[] args){
	
		ReadCSV.csvRead();
		String[][] grades = ReadCSV.gen2DArr();
		System.out.println("\n \n");
		for (String[] sta : grades) {
			System.out.println(Arrays.toString(sta));
		}
		System.out.println("\n");
		Calculation.avgSems(grades);

	}
	

}
