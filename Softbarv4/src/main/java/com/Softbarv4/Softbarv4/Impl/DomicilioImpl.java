package com.Softbarv4.Softbarv4.Impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.Model.Domicilio;
import com.Softbarv4.Softbarv4.Repo.DomicilioRepo;
import com.Softbarv4.Softbarv4.Service.DomicilioServ;

@Service
public class DomicilioImpl implements DomicilioServ {

	@Autowired
	//Repositorio_del_servicio
	DomicilioRepo domirepo;
	
	@Override
	public ArrayList<Domicilio> getAllD() {
		// metodo_de_listar
		return (ArrayList<Domicilio>) domirepo.findAll();
	}

	@Override
	public Optional<Domicilio> getByIdD(Long id_domicilio) {
		// Metodo_de_encontrar_por_id
		return domirepo.findById(id_domicilio);
	}

	@Override
	public Domicilio saveD(Domicilio d) {
		// Metodo_de_update_y_crear
		return domirepo.save(d);
	}

	@Override
	public boolean deleteD(Long id_domicilio) {
		// Metodo_de_borrar
		try {
			Optional<Domicilio> d = getByIdD(id_domicilio);
			domirepo.delete(d.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
