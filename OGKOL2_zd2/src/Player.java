
public class Player {

	private String playerName;
	private String playerAge;
	private int id;
	private static int cnt=4;
	
	public Player(String name, String age) {
		playerName=name;
		playerAge=age;
		this.id=cnt;
		cnt++;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
}
