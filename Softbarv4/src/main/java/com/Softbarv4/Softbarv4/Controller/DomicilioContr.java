package com.Softbarv4.Softbarv4.Controller;

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
import com.Softbarv4.Softbarv4.Model.Domicilio;
import com.Softbarv4.Softbarv4.Service.DomicilioServ;

@RestController
@CrossOrigin
@RequestMapping("domicilio")
public class DomicilioContr {

	@Autowired
	//service_respectivo_a_la_clase
	DomicilioServ domiServ;
	
	
	@GetMapping("/all")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Domicilio> getAllUser(){
		return domiServ.getAllD();
	} 
	
	@GetMapping("/find/{id_domicilio}")
	//Metodo_para_buscar_mediante_el_id
	public Optional<Domicilio> getUById(@PathVariable("id_domicilio") Long id_domicilio ){
		return domiServ.getByIdD(id_domicilio);
	}
	
	@PostMapping("/save")
	//metodo_para_crear_y_realizar_update
	public Domicilio saveU(@RequestBody Domicilio d) {
		return domiServ.saveD(d);
	}
	
	@ DeleteMapping("/delete/{id_domicilio}")
	//Metodo_para_borrar_con_el_id
	public  String deleteUById(@PathVariable("id_domicilio") Long id_domicilio ) {
		if (domiServ.deleteD(id_domicilio)) {
			return "Se ha eliminado el usuario";
		} else {
			return "No se ha eliminado el usuario";
		}
	}
	
}
