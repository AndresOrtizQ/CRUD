package com.prueba.tecnica.controller;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.tecnica.model.Ciudad;
import com.prueba.tecnica.model.Cliente;
import com.prueba.tecnica.model.Ocupacion;
import com.prueba.tecnica.service.ClienteServ;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteServ clientServ;
	
	@GetMapping("/all")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Cliente> getAll(){
		return clientServ.AllClient();
	} 
	
	@GetMapping("/find/{identificacion}")
	//Metodo_para_buscar_mediante_el_id
	public Optional<Cliente> findClientById(@PathVariable("identificacion") Long identificacion ){
		return clientServ.findByIdClient(identificacion);
	}
	
	@PostMapping("/save")
	//metodo_para_crear_y_realizar_update
	public Cliente saveclient(@RequestBody Cliente c) {
		return clientServ.saveClient(c);
	}
	
	
	@ DeleteMapping("/delete/{identificacion}")
	//Metodo_para_borrar_con_el_id
	public  String deleteClientById(@PathVariable("identificacion") Long identificacion ) {
		if (clientServ.deleteClient(identificacion)) {
			return "Se ha eliminado el cliente";
		} else {
			return "No se ha eliminado el cliente";
		}
	}
	
	@GetMapping("/ciudad")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Ciudad> AllCiudad(){
		return clientServ.AllCity();
	} 
	
	@GetMapping("/ocupacion")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Ocupacion> AllOcupacion(){
		return clientServ.AllOcupation();
	} 
	
	
	
}
