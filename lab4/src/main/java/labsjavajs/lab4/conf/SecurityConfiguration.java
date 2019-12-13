package labsjavajs.lab4.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;

		@Autowired
		private DataSource dataSource;

		@Value("${spring.queries.users-query}")
		private String usersQuery;

		@Override
		protected void configure(AuthenticationManagerBuilder auth)
						throws Exception {
				auth.
								jdbcAuthentication()
								.usersByUsernameQuery(usersQuery)
								.dataSource(dataSource)
								.passwordEncoder(bCryptPasswordEncoder);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

				http.
								authorizeRequests()
								.antMatchers("/").permitAll()
								.antMatchers("/login").permitAll()
								.antMatchers("/signup").permitAll()
								.antMatchers("/list").permitAll()
								.and().logout()
								.logoutSuccessUrl("/").and().exceptionHandling()
								.accessDeniedPage("/login");
		}

		@Override
		public void configure(WebSecurity web) {
				web
								.ignoring()
								.antMatchers("/resources/**");
		}

}