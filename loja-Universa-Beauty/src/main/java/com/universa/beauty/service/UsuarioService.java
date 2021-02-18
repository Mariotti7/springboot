package com.universa.beauty.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.universa.beauty.model.UserLogin;
import com.universa.beauty.model.Usuario;
import com.universa.beauty.repositorio.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	//Método para gerar senha criptografada
	//O BCryptPasswordEncoder pode ser usado para gerar uma senha criptografada com um salt aleatório. 
	
	public Usuario CadastrarUsuario(Usuario email) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(email.getSenha());
		email.setSenha(senhaEncoder);
		
		return repository.save(email);
	}
	
	public Optional<UserLogin> Logar(Optional<UserLogin> user){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmail(user.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setFoto(usuario.get().getFoto());
				
				return user;
			}
		}
		
		return null;
		
	}
	
	

}
