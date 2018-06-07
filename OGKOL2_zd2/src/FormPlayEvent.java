import java.util.EventObject;

public class FormPlayEvent extends EventObject {
	
	private String name;
	private String broj;
	
	
	public FormPlayEvent(Object obj) {
		super(obj);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBroj() {
		return broj;
	}


	public void setBroj(String broj) {
		this.broj = broj;
	}


	

	

}
