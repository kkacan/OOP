import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String type;
	private int ageCat;
	
	public FormEvent(Object obj) {
		super(obj);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAgeCat() {
		return ageCat;
	}

	public void setAgeCat(int ageCat) {
		this.ageCat = ageCat;
	}

}
