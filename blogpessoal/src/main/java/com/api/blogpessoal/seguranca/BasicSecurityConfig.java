package com.api.blogpessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override //throws Exception = tratativa de erro
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("usuarios/logar").permitAll() // permite o acesso no endpoint sem precisar de um token
		.antMatchers("usuarios/cadastrar").permitAll()
		.anyRequest().authenticated() //qualquer outra requisição precisará ser autenticada
		.and().httpBasic() // utilização basica de geração de token
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//tipo de sessao a ser utilizada(uma politica de acesso e qual tipo de politica - STATELESS > não guarda a sessão)
		.and().cors()
		.and().csrf().disable();
	
	}
	
}
