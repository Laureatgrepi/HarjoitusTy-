package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Team;

@Controller
public class TeamController {
	
	@GetMapping("/teams")
	public String showTeams (Model model) {
		model.addAttribute("team", new Team());
		return "teamList";
	}
}
