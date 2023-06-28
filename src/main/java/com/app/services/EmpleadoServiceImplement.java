package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.app.model.Empleado;
import com.app.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoServiceImplement implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	@Transactional
	public Empleado saveEmpleado(Empleado empleado) {
		Optional<Empleado>empleadoGuardado = empleadoRepository.findByEmail(empleado.getEmail());
		if(empleadoGuardado.isPresent()) {
			throw new ResourceAccessException("El empleado YA EXISTE "+ empleado.getNombre());
		}
		return empleadoRepository.save(empleado);
	}

	@Override
	@Transactional
	public List<Empleado> getAllEmpleados() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Empleado> getEmpleadoById(Long id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id);
	}

	@Override
	public Empleado updateEmpleado(Empleado empleadoActualizado) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleadoActualizado);
	}

	@Override
	public void deleteEmpleado(Long id) {
		empleadoRepository.deleteById(id);
		
	}
	
	

}
