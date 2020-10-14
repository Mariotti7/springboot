package org.generation.blogPessoal.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		
//		.antMatchers(HttpMethod.POST, "/tema").permitAll()
//		.antMatchers(HttpMethod.POST, "/postagens").permitAll()
//		.antMatchers(HttpMethod.GET, "/tema").permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin().permitAll()
//		
//		.and().csrf().disable();

		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").hasRole("administrador")
		.antMatchers(HttpMethod.GET, "/formTema").hasRole("administrador")
		.antMatchers(HttpMethod.POST, "/tema").hasRole("administrador")
		.antMatchers(HttpMethod.POST, "/formTema").hasRole("administrador")
		.antMatchers(HttpMethod.GET, "/cadastrarTema").hasRole("administrador")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncorder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Mariotti").password("mariotti").roles("administrador");
	}
}
