package changePassword.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain configuration(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				c ->c.anyRequest().permitAll()
		);
		http.csrf(
				c->c.disable()
		);
		return http.build();
	}
}
