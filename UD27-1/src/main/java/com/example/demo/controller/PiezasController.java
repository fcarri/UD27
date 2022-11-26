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

import com.example.demo.dto.Piezas;
import com.example.demo.service.PiezasServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezasController {

	@Autowired
	PiezasServiceImpl imp;
	
	@GetMapping("/piezas")
	public List<Piezas> listarPiezas(){
		return imp.listarPiezas();
	}
	
	@DeleteMapping("/piezas/{codigo}")
	public void eliminarPiezas(@PathVariable(name="codigo")int codigo) {
		imp.eliminarPiezas(codigo);
	}
	
	@PostMapping("/piezas")
	public Piezas guardarPiezas(@RequestBody Piezas piezas) {		
		return imp.guardarPiezas(piezas);
	}
	
	@PutMapping("/piezas/{codigo}")
	public Piezas actualizarPiezas(@PathVariable(name="codigo")int codigo,@RequestBody Piezas piezas) {
		
		Piezas piezas_seleccionadas= new Piezas();
		Piezas piezas_actualizadas= new Piezas();	
		
		piezas_actualizadas = imp.actualizarPiezas(piezas_actualizadas);
		
		piezas_seleccionadas.setCodigo(piezas.getCodigo());	
		piezas_seleccionadas.setNombre(piezas.getNombre());
				
		piezas_actualizadas = imp.actualizarPiezas(piezas_seleccionadas);		
		
		return piezas_actualizadas;
	}
	
	@GetMapping("/piezas/{codigo}")
	public Piezas piezasXID(@PathVariable(name="codigo") int codigo) {
		
		Piezas piezas_xid= new Piezas();		
		piezas_xid=imp.piezasXID(codigo);		
		
		return piezas_xid;
	}
	
}
