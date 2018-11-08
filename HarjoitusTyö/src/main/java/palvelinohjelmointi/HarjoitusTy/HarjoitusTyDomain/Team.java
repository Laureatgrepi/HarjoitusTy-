package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long teamId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
	private List<Player> players;
	
	@Autowired
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id")
	private Sport sport;

	public Team(String name) {
		this.name = name;
	}

	public Team(String name, List<Player> players, Sport sport) {
		this.name = name;
		this.players = players;
		this.sport = sport;
	}

	public Team(String name, Sport sport) {
		this.name = name;
		this.sport = sport;
	}

	public Team() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
	
}
