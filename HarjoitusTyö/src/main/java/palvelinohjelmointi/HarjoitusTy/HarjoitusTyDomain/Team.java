package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long teamId;
	private String name;

	public Team(String name) {
		this.name = name;
	}

	public Team() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + "]";
	}
	
	
	
}
