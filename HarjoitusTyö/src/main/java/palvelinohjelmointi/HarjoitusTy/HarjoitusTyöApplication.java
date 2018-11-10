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

	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HarjoitusTyöApplication.class, args);
	}

	@Bean
	public CommandLineRunner sportDemo(PlayerRepository pRepo, SportRepository sRepo, TeamRepository tRepo,
			UserRepository uRepo) {
		return (args) -> {
			log.info("save a couple of players, teams and sports");
			
			Sport koripallo = sRepo.save(new Sport("Koripallo"));
			Sport jalkapallo = sRepo.save(new Sport("Jalkapallo"));
			
			
			
			tRepo.save(new Team("Huuhkajat", jalkapallo));
			tRepo.save(new Team("Susijengi", koripallo));
			tRepo.save(new Team("Seagulls", koripallo));
			tRepo.save(new Team("KTP", koripallo));
			tRepo.save(new Team("Pyrintö",koripallo));
			tRepo.save(new Team("Kobrat", koripallo));
			tRepo.save(new Team("Ura Basket",koripallo));
			tRepo.save(new Team("HJK",jalkapallo));
			tRepo.save(new Team("HIFK",jalkapallo));
			tRepo.save(new Team("VJS",jalkapallo));
			tRepo.save(new Team("Lakers",koripallo));
			tRepo.save(new Team("Warriors",koripallo));
			tRepo.save(new Team("Celtics",koripallo));
			tRepo.save(new Team("Rockets",koripallo));
			tRepo.save(new Team("Arsenal",jalkapallo));
			tRepo.save(new Team("Juventus",jalkapallo));
			tRepo.save(new Team("FC Barcelona",jalkapallo));
			tRepo.save(new Team("Chelsea FC",jalkapallo));
			
			
			pRepo.save(new Player("Laureat", "Grepi", "6",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Pentti", "Pentikäinen", "15",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Matti", "Mattinen", "34",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Mikko", "Mikkonen", "64",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Maija", "Maijanen", "21",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Pekka", "Pekkanen", "23",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Esa", "Esanen", "43",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Minttu", "Minttunen", "10",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Jaska", "Jokunen", "61",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Kevin", "Durant", "35",tRepo.findByName("Warriors").get(0)));
			pRepo.save(new Player("Tuomo", "Tuomonen", "5",tRepo.findByName("Huuhkajat").get(0)));
			pRepo.save(new Player("Steph", "Curry", "30",tRepo.findByName("Warriors").get(0)));
			pRepo.save(new Player("LeBron", "James", "23",tRepo.findByName("Lakers").get(0)));
			pRepo.save(new Player("Lonzo", "Ball", "2",tRepo.findByName("Lakers").get(0)));
			pRepo.save(new Player("Rajon", "Rondo", "9",tRepo.findByName("Lakers").get(0)));
			pRepo.save(new Player("Kyrie", "Irving", "2",tRepo.findByName("Celtics").get(0)));
			pRepo.save(new Player("James", "Harden", "6",tRepo.findByName("Rockets").get(0)));
			pRepo.save(new Player("Christiano", "Ronaldo", "7",tRepo.findByName("Juventus").get(0)));
			pRepo.save(new Player("Lionel", "Messi", "10",tRepo.findByName("FC Barcelona").get(0)));
			pRepo.save(new Player("Didier", "Drogba", "14",tRepo.findByName("Arsenal").get(0)));
			pRepo.save(new Player("Mohammed", "Salah", "34",tRepo.findByName("Arsenal").get(0)));
			pRepo.save(new Player("Eden", "Hazard", "10",tRepo.findByName("Chelsea FC").get(0)));
			
			
		
			
		

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			uRepo.save(user1);
			uRepo.save(user2);

			log.info("fetch all players");
			for (Player player : pRepo.findAll()) {
				log.info(player.toString());
			}
			
			log.info("fetch all teams");
			for (Team team :tRepo.findAll()) {
				log.info(team.toString());
			}

		};
	}
}
