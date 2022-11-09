
package com.Softbarv4.Softbarv4.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Softbarv4.Softbarv4.Model.Venta_Reserva;

public interface Venta_ReservaServ {

	ArrayList<Venta_Reserva> getAllVR();
	Optional<Venta_Reserva> getByIdVR(Long id_venta_reserva);
	Venta_Reserva saveVR (Venta_Reserva vr);
	boolean deleteVR(Long id_venta_reserva);
}
