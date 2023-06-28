package com.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	
	Empleado empleadoT = new Empleado();
	
	@BeforeEach
	private void setUp() {
		
	}
	
	@Test
	public void getIdTest() {
		empleadoT.setId(1L);
		assertEquals(1L, empleadoT.getId());
	}
	
	@Test
	public void getNombreTest() {
		String test = "Marco Test";
		empleadoT.setNombre("Marco Test");
		assertEquals(empleadoT.getNombre(), test);
	}

	@Test
	public void getApellidoTest() {
		String test = "SC Test";
		empleadoT.setApellido("SC Test");
		assertEquals(empleadoT.getApellido(), test);
	}
	
	@Test
	public void getEmailTest() {
		String test = "SC@Test";
		empleadoT.setEmail("SC@Test");
		assertEquals(empleadoT.getEmail(), test);
	}
	
}
