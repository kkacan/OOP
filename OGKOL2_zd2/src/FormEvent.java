import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String age;
	
	
	public FormEvent(Object obj) {
		super(obj);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}

	

}
