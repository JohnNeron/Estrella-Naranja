package com.duoc.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.duoc.spring.model.Carrera;
import com.duoc.spring.model.Rol;
import com.duoc.spring.repository.ICarreraRepository;
import com.duoc.spring.repository.IRolRepository;

@SpringBootTest
class InstitutoApplicationTests {

	@Autowired
	private ICarreraRepository repoC;
	@Autowired
	private IRolRepository repoR;
	@Test
	void contextLoads() {
		Carrera c1 = new Carrera();
		Carrera c2 = new Carrera();
		Carrera c3 = new Carrera();
		
		Rol r1 = new Rol();
		Rol r2 = new Rol();
		
		c1.setId(1);
		c1.setNombre("Infórmatica");
		c2.setId(2);
		c2.setNombre("Medicina");
		c3.setId(3);
		c3.setNombre("Psicologia");
		r1.setId(1);
		r1.setNombre("Docente");
		r2.setId(2);
		r2.setNombre("Estudiante");
		
		repoC.save(c1);
		repoC.save(c2);
		repoC.save(c3);
		repoR.save(r1);
		repoR.save(r2);
	}

}
