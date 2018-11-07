package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Sport;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.SportRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.TeamRepository;

@Controller
public class SportController {
	
	@Autowired
	private SportRepository sportRepo;
	
	@Autowired
	private TeamRepository teamRepo;
	
	@GetMapping("/sports")
	public String showSeries (Model model) {
		model.addAttribute("sports", sportRepo.findAll());
		model.addAttribute("teams", teamRepo.findAll());
		return "sportList";
	}
	@GetMapping("/addSport")
	public String addSport(Model model) {
		model.addAttribute("sport", new Sport());
		return "addSport";
		
	}
	@PostMapping("/saveSport")
	public String saveSport(Sport sport) {
		sportRepo.save(sport);
		return "redirect:sports";
	}
	@GetMapping("/deleteSport/{id}")
	public String deleteSport(@PathVariable("id") Long sportId, Model model){
		sportRepo.deleteById(sportId);
		return "redirect:../sports";
		
		
	}
	
}
