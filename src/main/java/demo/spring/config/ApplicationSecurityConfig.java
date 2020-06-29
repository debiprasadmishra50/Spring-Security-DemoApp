package demo.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override 	// Configure users (in memory, database, idap ...etc)
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in-memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Debi").password("Debi").roles("EMPLOYEE"))
			.withUser(users.username("Debi Prasad").password("Debi Prasad").roles("MANAGER"))
			.withUser(users.username("Vicky").password("Vicky").roles("ADMIN"));
	}

}

















