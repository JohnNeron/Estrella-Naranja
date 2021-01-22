package com.duoc.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.duoc.spring.model.Carrera;
import com.duoc.spring.model.Estudiante;
import com.duoc.spring.model.Rol;
import com.duoc.spring.model.Usuario;
import com.duoc.spring.repository.ICarreraRepository;
import com.duoc.spring.repository.IEstudianteRepository;
import com.duoc.spring.repository.IRolRepository;
import com.duoc.spring.repository.IUsuarioRepository;

@Controller
public class WebController {
	
	@ModelAttribute("usuario")
	public Usuario setUsuario() {
		return new Usuario();
	}
	
	@ModelAttribute("rol")
	public Rol setRol() {
		return new Rol();
	}
	
	@ModelAttribute("estudiante")
	public Estudiante setEstudiante() {
		return new Estudiante();
	}
	
	@ModelAttribute("carrera")
	public Carrera setCarrera() {
		return new Carrera();
	}
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private IUsuarioRepository repoU;
	@Autowired
	private IRolRepository repoR;
	@Autowired
	private IEstudianteRepository repoE;
	@Autowired
	private ICarreraRepository repoC;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model, Authentication auth) {
		model.addAttribute("roles", repoR.findAll());
		if(auth == null)
		{
			return "registroUsuario";
		} else if(auth.getAuthorities().contains(new SimpleGrantedAuthority("Docente")))
		{
			return "registroUsuarioB";
		} else {
			return "registroUsuario";
		}
	}

	@GetMapping("/agregarEstudiante")
	public String agregarEstudiante(Model model) {
		model.addAttribute("carreras", repoC.findAll());
		return "registrarDatos";
	}
	
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(@Valid @ModelAttribute("usuario")Usuario u, BindingResult br, Model model, Authentication auth) {
		if(br.hasErrors()) {
			model.addAttribute("roles", repoR.findAll());
			return "registroUsuario";
		} else {
			u.setPassword(encoder.encode(u.getPassword()));
			repoU.save(u);
			if(auth == null) {
				return "confirmacionB";
				} else {
					return "confirmacion";
				}
		}
	}
	
	@PostMapping("/registrarEstudiante")
	public String registrarDatos(@Valid @ModelAttribute("estudiante")Estudiante e, BindingResult br, Model model, Authentication auth) {
		if(br.hasErrors()) {
			model.addAttribute("carreras", repoC.findAll());
			return "registrarDatos";
		} else {
			repoE.save(e);
			return "confirmacion";
		}
	}
	
	@GetMapping("/listar")
	public String getVer(Authentication auth, Model model) {
		return listar(model, auth);
	}
	
	@PostMapping("/EliminarEstudiante")
	public String eliminarEstudiante(String id, Model model, Authentication auth) {
		repoE.deleteById(Integer.parseInt(id));
		return "confirmacion";
	}
	
	@PostMapping("/CargarEstudiante")
	public String cargarEstudiante(String id, Model model) {
		model.addAttribute("carrera", repoC.findAll());
		model.addAttribute("estudiante", repoE.getOne(Integer.parseInt(id)));
		return "modificarEstudiante";
	}
	
	@PostMapping("/modificarEstudiante")
	public String modificarEstudiante(@Valid @ModelAttribute("estudiante")Estudiante e, BindingResult br, Model model, Authentication auth) {
		if(br.hasErrors()) {
			model.addAttribute("carrera", repoC.findAll());
			return "modificar";
		} else {
			repoE.save(e);
			return "confirmacion";
		}
	}
	
	@GetMapping("/listarUsuario")
	public String verUsuarios(Model model, Authentication auth) {
		return listarUsuarios(model);
	}
	
	@PostMapping("/EliminarUsuario")
	public String eliminarUsuario(String id, Model model) {
		repoU.deleteById(Integer.parseInt(id));
		return "confirmacion";
	}
	
	@PostMapping("/CargarUsuario")
	public String cargarUsuario(String id, Model model) {
		model.addAttribute("roles", repoR.findAll());
		model.addAttribute("usuario", repoU.getOne(Integer.parseInt(id)));
		return "modificarUsuario";
	}
	
	@PostMapping("/modificarUsuario")
	public String modificarUsuario(@Valid @ModelAttribute("usuario")Usuario u, BindingResult br, Model model) {
		if(br.hasErrors()) {
			model.addAttribute("usuario", repoR.findAll());
			return "modificarUsuario";
		} else {
			repoU.save(u);
			return "confirmacion";
		}
	}
	
	@GetMapping("/listarCarrera")
	public String verCarreras(Model model, Authentication auth) {
		return listarCarrera(model, auth);
	}
	
	@GetMapping("/agregarCarrera")
	public String agregarCarrera() {
		return "registroCarrera";
	}
	
	@PostMapping("/registrarCarrera")
	public String registrarCarrera(@Valid @ModelAttribute("carrera")Carrera c, BindingResult br, Model model, Authentication auth) {
		if(br.hasErrors()) {
			return "registroCarrera";
		} else {
			repoC.save(c);
			return "confirmacion";
		}
	}
	
	@PostMapping("/EliminarCarrera")
	public String eliminarCarrera(String id, Model model, Authentication auth) {
		repoC.deleteById(Integer.parseInt(id));
		return "confirmacion";
	}
	
	@PostMapping("/CargarCarrera")
	public String cargarCarrera(String id, Model model) {
		model.addAttribute("carrera", repoC.getOne(Integer.parseInt(id)));
		return "modificarCarrera";
	}
	
	@PostMapping("/modificarCarrera")
	public String modificarC(@Valid @ModelAttribute("carrera")Carrera c, BindingResult br, Model model, Authentication auth) {
		if(br.hasErrors()) {
			return "modificarCarrera";
		} else {
			repoC.save(c);
			return "confirmacion";
		}
	}
	
	private String listar(Model model, Authentication auth) {
		List<Estudiante> estudiantes = repoE.findAll();
		model.addAttribute("estudiantes", estudiantes);
		if(auth == null) {
			return "login";
		} else if(auth.getAuthorities().contains(new SimpleGrantedAuthority("Docente")))
		{
			return "ver";
		} else {
			return "verEstudiante";
		}
	}
	
	private String listarUsuarios(Model model) {
		List<Usuario> usuarios = repoU.findAll();
		model.addAttribute("usuarios", usuarios);
		return "verUsuarios";
	}
	
	private String listarCarrera(Model model, Authentication auth) {
		List<Carrera> carreras = repoC.findAll();
		model.addAttribute("carreras", carreras);
		if(auth == null) {
			return "login";
		} else if(auth.getAuthorities().contains(new SimpleGrantedAuthority("Docente")))
		{
			return "verCarrera";
		} else {
			return "verCarreraE";
		}
	}
}
