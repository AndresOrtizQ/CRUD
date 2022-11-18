package com.prueba.tecnica.service;

import java.util.ArrayList;
import java.util.Optional;
import com.prueba.tecnica.model.Ciudad;
import com.prueba.tecnica.model.Cliente;
import com.prueba.tecnica.model.Ocupacion;

public interface ClienteServ {

	 ArrayList<Cliente> AllClient();
	 Optional<Cliente> findByIdClient(Long identificacion);
	 Cliente saveClient (Cliente c);
	 Boolean deleteClient(Long identificacion);
	 ArrayList<Ciudad> AllCity(); 
	 ArrayList<Ocupacion> AllOcupation(); 
}
