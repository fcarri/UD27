package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proveedores;
import com.example.demo.service.ProveedoresServiceImpl;


@RestController
@RequestMapping("/api")
public class ProveedoresController {

	@Autowired
	ProveedoresServiceImpl imp;
	
	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores(){
		return imp.listarProveedores();
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedores(@PathVariable(name="id")int id) {
		imp.eliminarProveedores(id);
	}
	
	@PostMapping("/proveedores")
	public Proveedores guardarProveedores(@RequestBody Proveedores proveedores) {		
		return imp.guardarProveedores(proveedores);
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedores actualizarProveedores(@PathVariable(name="id")int id,@RequestBody Proveedores proveedores) {
		
		Proveedores proveedores_seleccionados= new Proveedores();
		Proveedores proveedores_actualizados= new Proveedores();		
				
		proveedores_actualizados = imp.actualizarProveedores(proveedores_seleccionados);
		
		proveedores_seleccionados.setId(proveedores.getId());	
		proveedores_seleccionados.setNombre(proveedores.getNombre());	
					
		return proveedores_actualizados;
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedores proveedoresXID(@PathVariable(name="id") int id) {
		
		Proveedores proveedores_xid= new Proveedores();
		
		proveedores_xid=imp.proveedoresXID(id);		
		
		return proveedores_xid;
	}
	
}
