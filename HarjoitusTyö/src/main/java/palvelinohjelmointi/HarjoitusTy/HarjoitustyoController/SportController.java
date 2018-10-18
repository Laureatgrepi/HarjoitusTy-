package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Sport;

@Controller
public class SportController {
	
	@GetMapping("/sports")
	public String showSeries (Model model) {
		model.addAttribute("sport", new Sport());
		return "teamList";
	}
}
