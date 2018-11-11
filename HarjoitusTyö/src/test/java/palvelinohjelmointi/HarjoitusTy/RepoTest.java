package palvelinohjelmointi.HarjoitusTy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Player;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.PlayerRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Sport;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.SportRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Team;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.TeamRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.User;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepoTest {

	@Autowired
	private PlayerRepository pRepo;

	@Autowired
	private TeamRepository tRepo;

	@Autowired
	private SportRepository sRepo;

	@Autowired
	private UserRepository userRepository;

	// PlayerRepon testit
	@Test
	public void findByName() {
		List<Player> list = pRepo.findByLastName("Grepi");

		assertThat(list).hasSize(1);
		assertEquals("Grepi", list.get(0).getLastName());
	}

	@Test
	public void createNewPlayer() {
		Player player = new Player("Esimerkki", "Esimerkkinen");
		pRepo.save(player);
		List<Player> list = pRepo.findByLastName("Esimerkkinen");

		assertNotNull(list.get(0));
	}

	@Test
	public void deletePlayer() {
		Player player = new Player("Esimerkki", "Esimerkkinen");
		pRepo.save(player);
		List<Player> list = pRepo.findByLastName("Esimerkkinen");
		assertNotNull(list.get(0));

		pRepo.delete(player);
		List<Player> list1 = pRepo.findByLastName("Esimerkkinen");
		assertThat(list1.isEmpty());
	}

	// TeamRepon testit

	@Test
	public void findByTeam() {
		List<Team> list = tRepo.findByName("Huuhkajat");

		assertThat(list).hasSize(1);
		assertEquals("Huuhkajat", list.get(0).getName());
	}

	@Test
	public void creatNewTeam() {
		Team team = new Team("Esimerkki");
		tRepo.save(team);
		List<Team> list = tRepo.findByName("Esimerkki");

		assertNotNull(list.get(0).getName());
	}

	@Test
	public void deleteTeam() {
		Team team = new Team("Esimerkki");
		tRepo.save(team);
		List<Team> list = tRepo.findByName("Esimerkki");
		assertNotNull(list.get(0).getName());
		
		tRepo.delete(team);
		List<Team> list1 = tRepo.findByName("Esimerkki");
		assertThat(list1.isEmpty());
	}

	
	//SportRepon testit
	
	@Test
	public void findBySportName() {
		List<Sport> list = sRepo.findByName("Jalkapallo");

		assertThat(list).hasSize(1);
		assertEquals("Jalkapallo", list.get(0).getName());
	}
	
	@Test
	public void createNewSport() {
		Sport sport = new Sport("Esimerkki");
		sRepo.save(sport);
		List<Sport> list = sRepo.findByName("Esimerkki");

		assertNotNull(list.get(0).getName());
	}
	
	@Test
	public void deleteSport () {
		Sport sport = new Sport("Esimerkki");
		sRepo.save(sport);
		List<Sport> list = sRepo.findByName("Esimerkki");
		assertNotNull(list.get(0).getName());
		
		sRepo.delete(sport);
		List<Sport> list1 = sRepo.findByName("Esimerkki");
		
		assertThat(list1.isEmpty());
	}
	
	//UserRepon testit
	
	@Test
	public void findByUsername() {
		User user = userRepository.findByUsername("user");
		
		assertNotNull(user);
	}
	
	@Test
	public void createNewUser() {
		User user = new User("esimerkki", "$2y$12$U0rhRctSen4ovSGLBNWaSuR9QZzXOrSPwOXOUMacFdqphwEsj1xiy", "USER");
		userRepository.save(user);
		User user1 = userRepository.findByUsername("esimerkki");
		assertNotNull(user1);
	}
	
	@Test
	public void deleteUser() {
		User user = new User("esimerkki", "$2y$12$U0rhRctSen4ovSGLBNWaSuR9QZzXOrSPwOXOUMacFdqphwEsj1xiy", "USER");
		userRepository.save(user);
		User user1 = userRepository.findByUsername("esimerkki");
		assertNotNull(user1);
		
		userRepository.delete(user1);
		assertNull(userRepository.findByUsername(user1.getUsername()));
	}
}
