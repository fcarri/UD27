package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="precio")
	private int precio;
	
	@ManyToOne
	@JoinColumn(name="codigopieza")
	private Piezas piezas;

	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedores proveedores;	

	
	public Suministra() {}

	public Suministra(int id, Piezas piezas, Proveedores proveedores, int precio) {

		this.id = id;
		this.piezas = piezas;
		this.proveedores = proveedores;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Piezas getPieza() {
		return piezas;
	}

	public void setPieza(Piezas piezas) {
		this.piezas = piezas;
	}

	public Proveedores getProveedores() {
		return proveedores;
	}

	public void setProveedor(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}
