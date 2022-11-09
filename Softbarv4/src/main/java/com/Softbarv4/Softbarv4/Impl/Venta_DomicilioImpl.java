package com.Softbarv4.Softbarv4.Impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Softbarv4.Softbarv4.Model.Venta_Domicilio;
import com.Softbarv4.Softbarv4.Repo.Venta_DomicilioRepo;
import com.Softbarv4.Softbarv4.Service.Venta_DomicilioServ;

@Service
public class Venta_DomicilioImpl implements Venta_DomicilioServ {
	
	@Autowired
	//Repositorio_del_servicio
	Venta_DomicilioRepo ventDomiRepo;

	@Override
	public ArrayList<Venta_Domicilio> getAllVD() {
		// metodo_de_listar
		return (ArrayList<Venta_Domicilio>) ventDomiRepo.findAll();
	}

	@Override
	public Optional<Venta_Domicilio> getByIdVD(Long id_venta_domicilio) {
		// Metodo_de_encontrar_por_id
		return ventDomiRepo.findById(id_venta_domicilio);
	}

	@Override
	public Venta_Domicilio saveVD(Venta_Domicilio vd) {
		// Metodo_de_update_y_crear
		return ventDomiRepo.save(vd);
	}

	@Override
	public boolean deleteVD(Long id_venta_domicilio) {
		// Metodo_de_borrar
		try {
			Optional<Venta_Domicilio> vd = getByIdVD(id_venta_domicilio);
			ventDomiRepo.delete(vd.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
