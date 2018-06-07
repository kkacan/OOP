
public class Vessel {
	
	private String vessType;
	private String vessName;
	private int ageCat;
	
	public Vessel(String type, String name, int age) {
		vessType=type;
		vessName=name;
		ageCat=age;
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
