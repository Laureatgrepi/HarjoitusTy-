package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Sport;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.SportRepository;

@Controller
public class SportController {
	
	@Autowired
	private SportRepository sportRepo;
	
	
	@GetMapping("/sports")
	public String showSeries (Model model) {
		model.addAttribute("sports", sportRepo.findAll());
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
	
}
