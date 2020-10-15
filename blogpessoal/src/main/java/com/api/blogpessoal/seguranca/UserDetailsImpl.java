package com.api.blogpessoal.seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.blogpessoal.model.Usuario;

// Classe criada para implementação de detalhes do usuario(
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;

	// construtor para receber login e senha
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	// construtor vazio
	public UserDetailsImpl() {
	}

	@Override // Retorna as autoridades concedidas ao usuário
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override // Retorna a senha usada para autenticar o usuário
	public String getPassword() {
		return password;
	}

	@Override // Retorna o nome de usuário usado para autenticar o usuário
	public String getUsername() {
		return userName;
	}
	
	// Como boa prática os metodos abaixo retornam todos como TRUE

	@Override // Indica se a conta do usuário expirou
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override // Indica se o usuário está bloqueado ou desbloqueado
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override // Indica se as credenciais do usuário (senha) expiraram
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override // Indica se o usuário está habilitado ou desabilitado
	public boolean isEnabled() {
		return true;
	}

}
