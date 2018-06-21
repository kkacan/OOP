import java.util.EventObject;

public class DialogEvent extends EventObject {
	
	private String userName;
	private int id;
	
	public DialogEvent(Object obj) {
		super (obj);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
