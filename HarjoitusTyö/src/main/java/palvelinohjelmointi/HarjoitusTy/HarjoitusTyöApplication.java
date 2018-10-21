package palvelinohjelmointi.HarjoitusTy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Player;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.PlayerRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Sport;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.SportRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Team;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.TeamRepository;

@SpringBootApplication
public class HarjoitusTyöApplication {

	private static final Logger log = LoggerFactory.getLogger(HarjoitusTyöApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitusTyöApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner sportDemo (PlayerRepository pRepo, SportRepository sRepo, TeamRepository tRepo) {
		return(args)->{
			log.info("save a couple of players, teams and sports");
			pRepo.save(new Player("Laureat", "Grepi", "6"));
			pRepo.save(new Player("Pentti", "Pentikäinen", "15"));
			tRepo.save(new Team("Huuhkajat"));
			tRepo.save(new Team("Leijonat"));
			sRepo.save(new Sport("Koripallo"));
			sRepo.save(new Sport("Jalkapallo"));
			
			log.info("fetch all players");
			for(Player player : pRepo.findAll()) {
				log.info(player.toString());
			}
			
		};
	}
}
