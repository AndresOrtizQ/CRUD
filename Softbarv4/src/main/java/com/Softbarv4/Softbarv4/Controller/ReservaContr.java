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

import com.Softbarv4.Softbarv4.Model.Reserva;
import com.Softbarv4.Softbarv4.Service.ReservaServ;

@RestController
@CrossOrigin
@RequestMapping("reserva")
public class ReservaContr {

	@Autowired
	//service_respectivo_a_la_clase
	ReservaServ reserServ;
	
	@GetMapping("/all")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Reserva> getAllUser(){
		return reserServ.getAllR();
	} 
	
	@GetMapping("/find/{id_reserva}")
	//Metodo_para_buscar_mediante_el_id
	public Optional<Reserva> getIById(@PathVariable("id_reserva")Long id_reserva ){
		return reserServ.getByIdR(id_reserva);
	}
	
	@PostMapping("/save")
	//metodo_para_crear_y_realizar_update
	public Reserva saveR(@RequestBody Reserva r ) {
		return reserServ.saveR(r);
	}
	
	@DeleteMapping("/delete/{id_reserva}")
	//Metodo_para_borrar_con_el_id
	public String deleteR(@PathVariable("id_reserva")Long id_reserva) {
		if (reserServ.deleteR(id_reserva)) {
			return "Se ha borrado con exito";
		} else {
			return "No e ha borrado con exito";
		}
	}
	
}
