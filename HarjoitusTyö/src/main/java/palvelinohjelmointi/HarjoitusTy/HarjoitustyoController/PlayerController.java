package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Player;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.PlayerRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.SportRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.TeamRepository;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired 
	private SportRepository sportRepo;
	
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	@GetMapping("/index")
	public String hae (Model model) {
		model.addAttribute("player", new Player());
		return "index";
	}
	
	
	@GetMapping("/players")
	public String showPlayers (Model model) {
		model.addAttribute("players", playerRepo.findAll());
		return "playerList";
	}
	
	@GetMapping("/addPlayer")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		return "addPlayer";
		
	}
	@PostMapping("/savePlayer")
	public String savePlayer(Player player) {
		playerRepo.save(player);
		return "redirect:playerList";
		//ei toimi tallentaminen
		
	}
	@GetMapping("/edit/{id}")
	public String editPlayer(@PathVariable("id") Long playerId, Model model) {
		model.addAttribute("player", playerRepo.findById(playerId));
		model.addAttribute("teams", teamRepo.findAll());
		model.addAttribute("sports", sportRepo.findAll());
		
		return "editPlayer";
		
	}
	
}
