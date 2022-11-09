package com.Softbarv4.Softbarv4.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Softbarv4.Softbarv4.Model.Venta_Domicilio;

public interface Venta_DomicilioServ {

	ArrayList<Venta_Domicilio> getAllVD();
	Optional<Venta_Domicilio> getByIdVD(Long id_venta_domicilio);
	Venta_Domicilio saveVD (Venta_Domicilio vd);
	boolean deleteVD(Long id_venta_domicilio);
}
