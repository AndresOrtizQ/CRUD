package com.prueba.tecnica.impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.tecnica.model.Ciudad;
import com.prueba.tecnica.model.Cliente;
import com.prueba.tecnica.model.Ocupacion;
import com.prueba.tecnica.repo.CiudadRepo;
import com.prueba.tecnica.repo.ClienteRepo;
import com.prueba.tecnica.repo.OcupacionRepo;
import com.prueba.tecnica.service.ClienteServ;

@Service
public class ClienteImpl implements ClienteServ {
	
	@Autowired
	ClienteRepo clientRepo;
	
	@Autowired
	CiudadRepo cityRepo;
	
	@Autowired
	OcupacionRepo ocupationRepo;
	

	@Override
	public ArrayList<Cliente> AllClient() {
		return (ArrayList<Cliente>) clientRepo.findAll();
	}

	@Override
	public Optional<Cliente> findByIdClient(Long identificacion) {
		return clientRepo.findById(identificacion);
	}

	@Override
	public Cliente saveClient(Cliente c) {
		return clientRepo.save(c);
	}
	
	@Override
	public Boolean deleteClient(Long identificacion) {
		try {
			Optional<Cliente> cli = findByIdClient(identificacion);
			clientRepo.delete(cli.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Ciudad> AllCity() {
		return (ArrayList<Ciudad>)cityRepo.findAll();
	}

	@Override
	public ArrayList<Ocupacion> AllOcupation() {
		return (ArrayList<Ocupacion>)ocupationRepo.findAll();
	}


}
