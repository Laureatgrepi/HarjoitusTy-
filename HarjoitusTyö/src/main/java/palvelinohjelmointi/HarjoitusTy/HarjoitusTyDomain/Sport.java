package palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain;

public class Sport {
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
