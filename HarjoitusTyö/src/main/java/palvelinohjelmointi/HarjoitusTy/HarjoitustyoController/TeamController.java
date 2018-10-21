package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.TeamRepository;

@Controller
public class TeamController {
	@Autowired
	private TeamRepository teamRepo;
	
	
	@GetMapping("/teams")
	public String showTeams (Model model) {
		model.addAttribute("teams",teamRepo.findAll() );
		return "teamList";
	}
}
