package com.Softbarv4.Softbarv4.Impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Softbarv4.Softbarv4.Model.Reserva;
import com.Softbarv4.Softbarv4.Repo.ReservaRepo;
import com.Softbarv4.Softbarv4.Service.ReservaServ;

@Service
public class ReservaImpl implements ReservaServ {

	@Autowired
	//Repositorio_del_servicio
	ReservaRepo reserRepo;

	@Override
	public ArrayList<Reserva> getAllR() {
		// metodo_de_listar
		return (ArrayList<Reserva>) reserRepo.findAll();
	}

	@Override
	public Optional<Reserva> getByIdR(Long id_reserva) {
		// Metodo_de_encontrar_por_id
		return reserRepo.findById(id_reserva);
	}

	@Override
	public Reserva saveR(Reserva r) {
		// Metodo_de_update_y_crear
		return  reserRepo.save(r);
	}

	@Override
	public boolean deleteR(Long id_reserva) {
		// Metodo_de_borrar
		try {
			Optional<Reserva> r = getByIdR(id_reserva);
			reserRepo.delete(r.get());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
