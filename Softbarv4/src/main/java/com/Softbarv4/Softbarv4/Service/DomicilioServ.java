package com.Softbarv4.Softbarv4.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Softbarv4.Softbarv4.Model.Domicilio;

public interface DomicilioServ {

	ArrayList<Domicilio> getAllD();
	Optional<Domicilio> getByIdD(Long id_domicilio);
	Domicilio saveD (Domicilio d);
	boolean deleteD(Long id_domicilio);
	
}
