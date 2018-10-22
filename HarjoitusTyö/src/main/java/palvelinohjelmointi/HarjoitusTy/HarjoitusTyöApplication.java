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
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.User;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.UserRepository;

@SpringBootApplication
public class HarjoitusTyöApplication {

	private static final Logger log = LoggerFactory.getLogger(HarjoitusTyöApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitusTyöApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner sportDemo (PlayerRepository pRepo, SportRepository sRepo, TeamRepository tRepo, UserRepository uRepo) {
		return(args)->{
			log.info("save a couple of players, teams and sports");
			pRepo.save(new Player("Laureat", "Grepi", "6"));
			pRepo.save(new Player("Pentti", "Pentikäinen", "15"));
			tRepo.save(new Team("Huuhkajat"));
			tRepo.save(new Team("Leijonat"));
			sRepo.save(new Sport("Koripallo"));
			sRepo.save(new Sport("Jalkapallo"));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			
			uRepo.save(user1);
			uRepo.save(user2);
			
			
			log.info("fetch all players");
			for(Player player : pRepo.findAll()) {
				log.info(player.toString());
			}
			
		};
	}
}
