package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String name;
		
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy ="sport")
		private List<Team> teams;
		

	public Sport(String name, String serie) {
		this.name = name;
	}
	public Sport(String name, List<Team> teams) {
		super();
		this.name = name;
		this.teams = teams;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sport(String name) {
		this.name = name;
	}

	public Sport() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
}
