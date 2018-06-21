import java.util.EventObject;

public class FormEvent extends EventObject{
	
	private String vessType;
	private String vessName;
	private int ageCat;

	public FormEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public String getVessType() {
		return vessType;
	}

	public void setVessType(String vessType) {
		this.vessType = vessType;
	}

	public String getVessName() {
		return vessName;
	}

	public void setVessName(String vessName) {
		this.vessName = vessName;
	}

	public int getAgeCat() {
		return ageCat;
	}

	public void setAgeCat(int ageCat) {
		this.ageCat = ageCat;
	}
	
	

}
