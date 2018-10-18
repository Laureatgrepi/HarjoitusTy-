package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Player;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.PlayerRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Sport;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Team;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@GetMapping("/index")
	public String hae (Model model) {
		model.addAttribute("player", new Player());
		return "index";
	}
	
	
	@GetMapping("/players")
	public String showPlayers (Model model) {
		model.addAttribute("player", new Player());
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
		
	}

	
}
