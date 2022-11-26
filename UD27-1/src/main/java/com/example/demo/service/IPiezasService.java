package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Piezas;

public interface IPiezasService {
	
	public List<Piezas> listarPiezas();
	public Piezas guardarPiezas(Piezas piezas);
	public Piezas actualizarPiezas(Piezas piezas);
	public void eliminarPiezas(int codigo);
	public Piezas piezasXID(int codigo);


}
