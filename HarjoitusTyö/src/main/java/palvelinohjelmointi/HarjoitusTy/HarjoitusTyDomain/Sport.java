package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String name, serie;

	public Sport(String name, String serie) {
		this.name = name;
		this.serie = serie;
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

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "Sport [name=" + name + ", serie=" + serie + "]";
	}
	
	
}
