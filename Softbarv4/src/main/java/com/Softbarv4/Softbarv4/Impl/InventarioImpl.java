package com.Softbarv4.Softbarv4.Impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.Model.Inventario;
import com.Softbarv4.Softbarv4.Repo.InventarioRepo;
import com.Softbarv4.Softbarv4.Service.InventarioServ;

@Service
public class InventarioImpl implements InventarioServ {

	@Autowired
	//Repositorio_del_servicio
	InventarioRepo invenRepo;
	
	@Override
	public ArrayList<Inventario> getAllI() {
		// metodo_de_listar
		return (ArrayList<Inventario>) invenRepo.findAll();
	}

	@Override
	public Optional<Inventario> getByIdI(Long id_inventario) {
		// Metodo_de_encontrar_por_id
		return invenRepo.findById(id_inventario);
	}

	@Override
	public Inventario saveI(Inventario i) {
		// Metodo_de_update_y_crear
		return invenRepo.save(i);
	}

	@Override
	public boolean deleteI(Long id_inventario) {
		// Metodo_de_borrar
		try {
			Optional<Inventario> i = getByIdI(id_inventario);
			invenRepo.delete(i.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
