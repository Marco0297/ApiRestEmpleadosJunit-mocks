package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.model.Empleado;
import com.app.services.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class Controller {

	@Autowired
	private EmpleadoService empleadoService;

	@PostMapping("/guardarEmpleado")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.saveEmpleado(empleado);
	}

	@GetMapping("/listarEmpleado")
	public List<Empleado> listarEmpleados() {
		return empleadoService.getAllEmpleados();
	}

	@GetMapping("/obtenerEmpleadoPorId/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable("id") long empleadoId) {
		return empleadoService.getEmpleadoById(empleadoId).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/actualizarEmpleado/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable("id") long empleadoId, @RequestBody Empleado empleado) {
		return empleadoService.getEmpleadoById(empleadoId).map(empleadoGuardado -> {
			empleadoGuardado.setNombre(empleado.getNombre());
			empleadoGuardado.setApellido(empleado.getApellido());
			empleadoGuardado.setEmail(empleado.getEmail());

			Empleado empleadoActualizado = empleadoService.updateEmpleado(empleadoGuardado);
			return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/EliminarEmpleadoPorId/{id}")
	public ResponseEntity<String> eliminarEmpleado(@PathVariable("id") long empleadoId) {
		empleadoService.deleteEmpleado(empleadoId);
		return new ResponseEntity<String>("Empleado eliminado exitosamente", HttpStatus.OK);
	}
}
