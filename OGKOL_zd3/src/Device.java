import java.util.ArrayList;
import java.util.Date;

public abstract class Device {
	
	protected int elevID;
	protected String serName;
	
	public Device() {
		
	}
	
	public void describeDev() {
		
	}
	public abstract void start();
	public abstract void stop();
	public abstract void change();
	public abstract void operate();
	public abstract ArrayList<Date> getArd();
	public abstract ArrayList<Integer> getOut();

	public String getSerName() {
		return serName;
	}
	public int getElevID() {
		return elevID;
	}

	

}
