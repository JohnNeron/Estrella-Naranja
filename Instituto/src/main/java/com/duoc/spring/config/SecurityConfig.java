package com.duoc.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.duoc.spring.service.UsuarioServicio;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioServicio usuarioservicio;
	@Autowired
	private BCryptPasswordEncoder bCPE;
	
	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		BCryptPasswordEncoder bCPE = new BCryptPasswordEncoder();
		return bCPE;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/css/**", "/js/**", "/img/**")
		.permitAll()
		.antMatchers("/registrar", "/registrarUsuario", "/registrarEstudiante")
		.permitAll()
		.antMatchers("/modificarEstudiante", "/CargarEstudiante", "/EliminarEstudiante", "/listarUsuario", 
				"/EliminarUsuario", "/CargarUsuario", "/modificarUsuario", 
				"/CargarCarrera", "/modificarCarrera", "/EliminarCarrera")
		.hasAuthority("Docente")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioservicio).passwordEncoder(bCPE);
	}
}
