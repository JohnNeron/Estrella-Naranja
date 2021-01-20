package com.duoc.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.duoc.spring.model.Usuario;
import com.duoc.spring.repository.IUsuarioRepository;

@Service
public class UsuarioServicio implements UserDetailsService{

	@Autowired
	private IUsuarioRepository repoU;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = repoU.findByUsername(username);
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(u.getRol().getNombre()));
		UserDetails usetDT = new User(u.getUsername(), u.getPassword(), roles);
		return usetDT;
	}
	
}
