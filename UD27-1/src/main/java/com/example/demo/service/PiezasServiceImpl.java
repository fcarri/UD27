package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezasDAO;
import com.example.demo.dto.Piezas;

@Service
public class PiezasServiceImpl implements IPiezasService {

	@Autowired
	IPiezasDAO iPiezasDAO;
	
	@Override
	public List<Piezas> listarPiezas() {	
		return iPiezasDAO.findAll();
	}
	
	@Override
	public Piezas guardarPiezas(Piezas piezas) {		
		return iPiezasDAO.save(piezas);
	}
	
	@Override
	public Piezas actualizarPiezas(Piezas piezas) {		
		return iPiezasDAO.save(piezas);
	}

	@Override
	public void eliminarPiezas(int codigo) {		
		iPiezasDAO.deleteById(codigo);
		
	}
	
	@Override
	public Piezas piezasXID(int codigo) {
		
		return iPiezasDAO.findById(codigo).get();
	}

		
	
}
