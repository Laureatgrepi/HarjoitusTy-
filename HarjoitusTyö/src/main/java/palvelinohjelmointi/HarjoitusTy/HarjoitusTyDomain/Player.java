package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String firstName, lastName, playerNum;

		@ManyToOne
		@JsonIgnore
		@JoinColumn(name="teamId")
		private Team team;

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

	public Player(String firstName, String lastName, String playerNum, Team team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerNum = playerNum;
		this.team = team;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", playerNum=" + playerNum + "]";
	}
	
	
	
	
}
