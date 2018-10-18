package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", playerNum=" + playerNum + "]";
	}
	
	
	
	
}
