import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Server extends Device implements Maintance{
	
	public ArrayList<Date> ard= new ArrayList<Date>();
	public ArrayList<Integer> out= new ArrayList<Integer>();
	
	
	public Server(String serName) {
		this.serName=serName;
	}
	public void start() {
		
	}
	public void stop() {
		
	}
	public void change() {
	
	}
	public void operate() {
	
	}
	
	public static String getUrlSource(String str) {
		
		
		return str;
		
	}
	public ArrayList<Date> getArd(){
		
		return ard;
		
	}
	
	public ArrayList<Integer> getOut(){
		
		return out;
		
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
	public String getSerName() {
		return serName;
	}
	

	
	}
