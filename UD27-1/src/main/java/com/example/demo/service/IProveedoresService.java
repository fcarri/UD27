package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proveedores;

public interface IProveedoresService {

	public List<Proveedores> listarProveedores();
	public Proveedores guardarProveedores(Proveedores proveedores);
	public Proveedores actualizarProveedores(Proveedores proveedores);
	public void eliminarProveedores(int id);
	public Proveedores proveedoresXID(int id);
	
}
