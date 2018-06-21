
public class Vessel {
	
	private String vessType;
	private String vessName;
	private int ageCat;
	
	
	public Vessel (String type, String name, int age) {
		this.vessType=type;
		this.vessName=name;
		this.ageCat=age;
	}


	public String getVessType() {
		return vessType;
	}


	public String getVessName() {
		return vessName;
	}


	public int getAgeCat() {
		return ageCat;
	}
	
	

}
