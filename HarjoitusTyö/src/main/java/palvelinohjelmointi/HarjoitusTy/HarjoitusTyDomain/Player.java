package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

public class Player {
	private String firstName, lastName, playerNum;

	public Player(String firstName, String lastName, String playerNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerNum = playerNum;
	}

	public Player(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Player() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(String playerNum) {
		this.playerNum = playerNum;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", playerNum=" + playerNum + "]";
	}
	
	
	
	
}
