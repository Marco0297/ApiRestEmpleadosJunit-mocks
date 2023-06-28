package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.model.Empleado;

public interface EmpleadoService {
	public Empleado saveEmpleado(Empleado empleado);
	public List<Empleado>getAllEmpleados();
	public Optional<Empleado>getEmpleadoById(Long id);
	public Empleado updateEmpleado(Empleado empleadoActualizado);
	public void deleteEmpleado(Long id);
	
	
}
