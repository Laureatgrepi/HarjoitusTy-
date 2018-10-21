package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
