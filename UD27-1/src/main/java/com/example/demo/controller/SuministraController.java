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

import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl imp;
	
	@GetMapping("/suministra")
	public List<Suministra> listarSuministra(){
		return imp.listarSuministra();
	}
	
	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name="id")int id) {
		imp.eliminarSuministra(id);
	}
	
	@PostMapping("/suministra")
	public Suministra guardarSuministra(@RequestBody Suministra suministra) {		
		return imp.guardarSuministra(suministra);
	}
	
	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id")int id,@RequestBody Suministra suministra) {
		
		Suministra suministra_seleccionados= new Suministra();
		Suministra suministra_actualizados= new Suministra();		
				
		suministra_actualizados = imp.actualizarSuministra(suministra_seleccionados);
		
		suministra_seleccionados.setId(suministra.getId());			
		suministra_seleccionados.setPrecio(suministra.getPrecio());
					
		return suministra_actualizados;
	}
	
	@GetMapping("/suministra/{id}")
	public Suministra suministraXID(@PathVariable(name="id") int id) {
		
		Suministra suministra_xid= new Suministra();
		
		suministra_xid=imp.suministraXID(id);		
		
		return suministra_xid;
	}
	
	
}
