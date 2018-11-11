package palvelinohjelmointi.HarjoitusTy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertNotNull;

import palvelinohjelmointi.HarjoitusTy.HarjoitustyoController.PlayerController;
import palvelinohjelmointi.HarjoitusTy.HarjoitustyoController.SportController;
import palvelinohjelmointi.HarjoitusTy.HarjoitustyoController.TeamController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HarjoitusTyöApplicationTests {

	@Autowired
	private PlayerController pController;
	
	@Autowired
	private TeamController tController;
	
	@Autowired
	private SportController sController;
	
	
	
	@Test
	public void contextLoads() {
		assertNotNull(pController);
		assertNotNull(tController);
		assertNotNull(sController);
		
	}

}
