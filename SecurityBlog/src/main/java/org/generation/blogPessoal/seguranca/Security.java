package org.generation.blogPessoal.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		
		.antMatchers(HttpMethod.POST, "/tema").permitAll()
		.antMatchers(HttpMethod.POST, "/postagens").permitAll()
		.antMatchers(HttpMethod.GET, "/tema").permitAll()
		.antMatchers(HttpMethod.GET, "/postagens").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		
		.and().csrf().disable();
	}
}
