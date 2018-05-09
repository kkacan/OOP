import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Elevator extends Device implements Maintance{
	
	private int floor;
	
	public ArrayList<Date> ard= new ArrayList<Date>();
	public ArrayList<Integer> out= new ArrayList<Integer>();
	
	public Elevator(int ID,int floor) {
		this.elevID=ID;
		this.floor= floor;
	}
	public void start() {
		
	}
	public void stop() {
		
	}
	public void change() {
	
	}
	public void operate() {
	
	}
	public int getCurrFloor() {
		
		return floor;
		
	}
	public void changeFloor(int floor) {
		
	}
	public void scheduledMaintance(String date){
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			ard.add(df.parse(date));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void outOfUsage(){

		int broj_dana = ThreadLocalRandom.current().nextInt(1, 50);
		out.add(broj_dana);
	
	}
	@Override
	public ArrayList<Date> getArd() {
		// TODO Auto-generated method stub
		return ard;
	}
	@Override
	public ArrayList<Integer> getOut() {
		// TODO Auto-generated method stub
		return out;
	}
	public int getElevID() {
		return elevID;
	}
	

}
