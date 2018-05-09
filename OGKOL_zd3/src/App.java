import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Server s1 = new Server("s1");
		s1.outOfUsage();
		s1.outOfUsage();
		s1.scheduledMaintance("22-05-2011");
		s1.scheduledMaintance("12-06-2012");
		
		Server s2 = new Server("s2");
		s2.outOfUsage();
		s2.outOfUsage();
		s2.scheduledMaintance("22-05-2011");
		s2.scheduledMaintance("12-07-2012");
		
		Server s3 = new Server("s3");
		s3.outOfUsage();
		s3.outOfUsage();
		s3.scheduledMaintance("22-05-2011");
		s3.scheduledMaintance("12-06-2012");
		
		Elevator e1 = new Elevator(1,3);
		e1.outOfUsage();
		e1.outOfUsage();
		e1.scheduledMaintance("22-05-2015");
		e1.scheduledMaintance("12-06-2016");
		
		Elevator e2 = new Elevator(2,4);
		e2.outOfUsage();
		e2.outOfUsage();
		e2.scheduledMaintance("22-05-2010");
		e2.scheduledMaintance("12-06-2009");
		
		Elevator e3 = new Elevator(3,2);
		e3.outOfUsage();
		e3.outOfUsage();
		e3.scheduledMaintance("22-05-2017");
		e3.scheduledMaintance("12-06-2018");
		
		DatumiOdrzavanja(s1);
		UkupnoDana(s1);
		
		DatumiOdrzavanja(s2);
		UkupnoDana(s2);
		
		DatumiOdrzavanja(s3);
		UkupnoDana(s3);
		
		DatumiOdrzavanja(e1);
		UkupnoDana(e1);
		
		DatumiOdrzavanja(e2);
		UkupnoDana(e2);
		
		DatumiOdrzavanja(e3);
		UkupnoDana(e3);

	}
	
	private static void UkupnoDana(Device device) {
		
		ArrayList<Integer> out= new ArrayList<Integer>();
		int zbroj=0;
		out=device.getOut();
		
		for (int item: out) {
			zbroj+=item;
		}
		if (device.serName!=null) {
			System.out.println("Total numer of days out of usage for server "+device.serName+": "+zbroj);
		} else {
			System.out.println("Total numer of days out of usage for elevator id "+device.getElevID()+" : "+zbroj);
		}
		System.out.println("\n");
	}
	private static void DatumiOdrzavanja(Device device) {
		
		ArrayList<Date> ard= new ArrayList<Date>();
		
		ard=device.getArd();
		
		if (device.serName!=null) {
			System.out.println("Maintance for server -----> "+device.getSerName());
		} else {
			System.out.println("Maintance for elevator -----> "+device.getElevID());
		}
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		for (Date item: ard) {
			System.out.println(df.format(item));
		}
		
		System.out.println("\n");
		
	}

}
