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
import com.Softbarv4.Softbarv4.Model.Venta_Reserva;
import com.Softbarv4.Softbarv4.Service.Venta_ReservaServ;

@RestController
@CrossOrigin
@RequestMapping("ventareserva")
public class Venta_ReservaContr {

	@Autowired
	//service_respectivo_a_la_clase
	Venta_ReservaServ  ventResServ;
	
	@GetMapping("/all")
	//Metodo_para_listar_toda_la_tabla
	public ArrayList<Venta_Reserva> getAllVentaReserva (){
		return ventResServ.getAllVR();
	} 
	
	@GetMapping("/find/{id_venta_reserva}")
	//Metodo_para_buscar_mediante_el_id
	public Optional<Venta_Reserva> getVentaReservaById(@PathVariable("id_venta_reserva") Long id_venta_reserva ){
		return  ventResServ.getByIdVR(id_venta_reserva);
	}
	
	@PostMapping("/save")
	//metodo_para_crear_y_realizar_update
	public Venta_Reserva saveVentaReserva (@RequestBody Venta_Reserva vr) {
		return ventResServ.saveVR(vr);
	}
	
	@ DeleteMapping("/delete/{id_venta_reserva}")
	//Metodo_para_borrar_con_el_id
	public  String deleteVentaReservaById(@PathVariable("id_venta_reserva") Long id_venta_reserva ) {
		if (ventResServ.deleteVR(id_venta_reserva)) {
			return "Se ha eliminado el usuario";
		} else {
			return "No se ha eliminado el usuario";
		}
	}
}
