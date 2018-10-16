package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Player;

@Controller
public class PlayerController {
	
	ArrayList<Player> players = new ArrayList<>();
	
	@GetMapping("/index")
	public String hae (Model model) {
		model.addAttribute("player", new Player());
		return "addPlayer";
	}
	
	@PostMapping("/add")
	public String addPlayer(@ModelAttribute Player player, Model model) {
		players.add(player);
		model.addAttribute("players",players);
		return "addPlayer";
		
	}
	
}
