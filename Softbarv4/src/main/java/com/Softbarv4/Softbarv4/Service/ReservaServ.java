package com.Softbarv4.Softbarv4.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Softbarv4.Softbarv4.Model.Reserva;

public interface ReservaServ {

	ArrayList<Reserva> getAllR();
	Optional<Reserva> getByIdR(Long id_reserva);
	Reserva saveR (Reserva r);
	boolean deleteR(Long id_reserva);
}
