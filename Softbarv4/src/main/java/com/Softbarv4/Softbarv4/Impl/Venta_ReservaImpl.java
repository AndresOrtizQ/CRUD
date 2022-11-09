package com.Softbarv4.Softbarv4.Impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Softbarv4.Softbarv4.Model.Venta_Reserva;
import com.Softbarv4.Softbarv4.Repo.Venta_ReservaRepo;
import com.Softbarv4.Softbarv4.Service.Venta_ReservaServ;


@Service
public class Venta_ReservaImpl implements Venta_ReservaServ {

	@Autowired
	//Repositorio_del_servicio
	Venta_ReservaRepo venResRepo;
	
	@Override
	public ArrayList<Venta_Reserva> getAllVR() {
		// metodo_de_listar
		return (ArrayList<Venta_Reserva>) venResRepo.findAll();
	}

	@Override
	public Optional<Venta_Reserva> getByIdVR(Long id_venta_reserva) {
		// Metodo_de_encontrar_por_id
		return venResRepo.findById(id_venta_reserva);
	}

	@Override
	public Venta_Reserva saveVR(Venta_Reserva vr) {
		// Metodo_de_update_y_crear
		return venResRepo.save(vr);
	}

	@Override
	public boolean deleteVR(Long id_venta_reserva) {
		// Metodo_de_borrar
		try {
			Optional<Venta_Reserva> vr = getByIdVR(id_venta_reserva);
			venResRepo.delete(vr.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}



}
