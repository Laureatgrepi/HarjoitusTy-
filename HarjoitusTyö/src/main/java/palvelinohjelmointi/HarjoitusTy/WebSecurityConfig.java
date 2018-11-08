	package palvelinohjelmointi.HarjoitusTy;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import palvelinohjelmointi.HarjoitusTy.HarjoitustyoController.UserDetailServiceImpl;


@Configuration
@EnableGlobalMethodSecurity
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests().antMatchers("/css/**").permitAll()
		.anyRequest().authenticated()
		.antMatchers("/h2-console/**").permitAll()
		.and()
	.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/index")
		.permitAll()
		.and()
	.logout()
		.permitAll();
		
		http.csrf().disable();
        http.headers().frameOptions().disable();
		
		}
	

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
